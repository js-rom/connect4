package connect4.views.graphics;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import connect4.controllers.PlayController;
import connect4.models.MachinePlayer;
import connect4.models.Player;
import utils.models.Coordinate;

public class MachinePlayerBoardView extends PlayerBoardView {

    private MachinePlayer player;

    public MachinePlayerBoardView(PlayController playController, PanelViewCommand callback) {
        super(playController, callback);
    }

    public MachinePlayerBoardView(PlayController playController, PanelViewCommand callback, Player player) {
        super(playController, callback, player);
        this.setPlayer(player);
        this.dropToken();
    }

    @Override
    protected Square createSquare(Coordinate coordiante) {
        ImageIcon icon = this.getColors().get(this.getPlayController().getColor(coordiante));
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
                if (!getPlayController().isFinished()) {
                    getPlayController().next();
                }
                getCallback().execute();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public BoardView copy() {
        PanelViewCommand callback = this.getCallback();
        return new MachinePlayerBoardView(this.getPlayController(), callback, this.getPlayController().getActivePlayer());
    }

    @Override
    public void setPlayer(Player player) {
        this.player = (MachinePlayer) this.getPlayController().getActivePlayer();
    }

}
