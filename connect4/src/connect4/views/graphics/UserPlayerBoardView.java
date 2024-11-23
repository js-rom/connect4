package connect4.views.graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import connect4.controllers.PlayController;
import connect4.models.Player;
import connect4.models.UserPlayer;
import utils.models.Coordinate;

public class UserPlayerBoardView extends PlayerBoardView implements ActionListener {

    private UserPlayer player;

    public UserPlayerBoardView(PlayController playController, PanelViewCommand callback) {
        super(playController, callback);
    }

    public UserPlayerBoardView(PlayController playController, PanelViewCommand callback, Player player) {
        super(playController, callback, player);
    }

    @Override
    protected Square createSquare(Coordinate coordiante) {
        assert (coordiante != null);
        ImageIcon icon = this.getColors().get(this.getPlayController().getColor(coordiante));
        ClickableSquare square = new ClickableSquare(icon, coordiante);
        square.addActionListener(this);
        return square;
    }

    @Override
    public BoardView copy() {
        PanelViewCommand callback = this.getCallback();
        return new UserPlayerBoardView(this.getPlayController(), callback, this.getPlayController().getActivePlayer());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ClickableSquare square = (ClickableSquare) e.getSource();
        int column = square.getColumn();
        this.getPlayController().dropToken(column);
        write();
        if (!this.getPlayController().isFinished()) {
            this.getPlayController().next();
        }
        this.getCallback().execute();
    }

    @Override
    public void setPlayer(Player player) {
        this.player = (UserPlayer) getPlayController().getActivePlayer();
    }

}
