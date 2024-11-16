package connect4.views.graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import connect4.models.Game;
import connect4.models.Player;
import connect4.models.UserPlayer;
import connect4.views.graphics.commands.Command;
import utils.models.Coordinate;

public class UserPlayerBoardView extends PlayerBoardView implements ActionListener {

    private UserPlayer player;

    public UserPlayerBoardView(Game game, Command callback) {
        super(game, callback);
    }

    public UserPlayerBoardView(Game game, Command callback, Player player) {
        super(game, callback, player);
    }

    @Override
    protected Square createSquare(ImageIcon icon, Coordinate coordiante) {
        ClickableSquare square = new ClickableSquare(icon, coordiante);
        square.addActionListener(this);
        return square;
    }

    @Override
    public BoardView copy() {
        Game game = this.getGame();
        Command callback = this.getCallback();
        return new UserPlayerBoardView(game, callback, game.getActivePlayer());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("user action performed");
        ClickableSquare square = (ClickableSquare) e.getSource();
        int column = square.getColumn();
        this.player.dropToken(column);
        write();
        if (!this.getGame().isFinished()) {
            this.getGame().next();
        }
        this.getCallback().execute();
    }

    @Override
    public void setPlayer(Player player) {
        this.player = (UserPlayer) getGame().getActivePlayer();
    }

}
