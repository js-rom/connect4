package connect4.views.graphics;

import connect4.models.Game;
import connect4.views.View;
import connect4.views.graphics.commands.Command;
import connect4.views.graphics.commands.MacroCommand;
import connect4.views.graphics.commands.MakeInvisibleCommand;
import connect4.views.graphics.commands.NextTurnCommand;
import connect4.views.graphics.commands.PlayCommand;
import connect4.views.graphics.commands.ResumeCommand;

public class JFrameViewFactory {

    private Game game;

    public JFrameViewFactory(Game game) {
        this.game = game;
    }

    public JFrameView createStartView(View view) {
        StartView startView = new StartView(game);
        MacroCommand nextView = new MacroCommand();
        nextView.add(new MakeInvisibleCommand(startView));
        nextView.add(new PlayCommand(view));
        PlayerSelectionView playerSelectionView = new PlayerSelectionView(game, nextView);
        startView.setPanel(playerSelectionView);
        return startView;
    }

    public JFrameView createPlayView(View view) {
        PlayView playView = new PlayView(game);
        MacroCommand nextView = new MacroCommand();
        nextView.add(new MakeInvisibleCommand(playView));
        nextView.add(new ResumeCommand(view)); // quitar logica de command y ponerla en View
        playView.setNextView(nextView);
        Command playNextTurn = new NextTurnCommand(playView);
        BoardViewPrototypeRegistry boardViewPrototypeRegistry = new BoardViewPrototypeRegistry(this.game, playNextTurn);
        PanelView gameView = new PlayGameView(this.game, boardViewPrototypeRegistry);
        playView.setPanel(gameView);
        return playView;
    }

    public JFrameView createResumeView(View view) {
        PlayView playView = new PlayView(game);
        PanelView gameView = new PauseGameView(this.game); // informative GameView
        gameView.write();
        playView.setPanel(gameView);
        return playView;
    }

}