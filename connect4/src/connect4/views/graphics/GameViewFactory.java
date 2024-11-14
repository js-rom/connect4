package connect4.views.graphics;

import connect4.models.Game;
import connect4.views.View;
import connect4.views.graphics.commands.MacroCommand;
import connect4.views.graphics.commands.MakeInvisibleCommand;
import connect4.views.graphics.commands.PlayCommand;
import connect4.views.graphics.commands.ResumeCommand;

public class GameViewFactory {

    private Game game;

    public GameViewFactory(Game game) {
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
        nextView.add(new ResumeCommand(view));
        playView.setCallback(nextView);
        PanelView inGameView = new InGameView(this.game);
        playView.setPanel(inGameView);
        return playView;
    }

}