package connect4.views.graphics;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import connect4.models.Game;
import connect4.models.MachinePlayer;
import connect4.models.Player;
import connect4.views.graphics.commands.Command;
import utils.models.Coordinate;

public class MachinePlayerBoardView extends PlayerBoardView {

    private MachinePlayer player;

    public MachinePlayerBoardView(Game game, PanelViewCommand callback) {
        super(game, callback);
    }

    public MachinePlayerBoardView(Game game, PanelViewCommand callback, Player player) {
        super(game, callback, player);
        this.setPlayer(player);
        this.dropToken();
    }

    @Override
    protected Square createSquare(ImageIcon icon, Coordinate coordiante) {
        NonClickableSquare square = new NonClickableSquare(icon, coordiante);
        return square;
    }

    public int getColumn() {
        int column = this.player.getColumn();
        return column;
    }

    public void dropToken() {
        int delay = 1000;
        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.dropToken(getColumn());
                write();
                if (!getGame().isFinished()) {
                    getGame().next();
                }
                getCallback().execute();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public BoardView copy() {
        Game game = this.getGame();
        PanelViewCommand callback = this.getCallback();
        return new MachinePlayerBoardView(game, callback, game.getActivePlayer());
    }

    @Override
    public void setPlayer(Player player) {
        this.player = (MachinePlayer) getGame().getActivePlayer();
    }

}
