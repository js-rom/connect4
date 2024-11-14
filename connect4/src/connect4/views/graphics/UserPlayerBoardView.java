package connect4.views.graphics;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import connect4.models.Game;
import connect4.models.Player;
import connect4.models.UserPlayer;
import connect4.views.graphics.commands.Command;
import utils.models.Coordinate;

public class UserPlayerBoardView extends BoardView implements ActionListener {

    private UserPlayer player;
    private Command callback;

    public UserPlayerBoardView(Game game, Command callback) {
        super(game);
        this.callback = callback;
    }

    public UserPlayerBoardView(Game game, Command callback, Player player) {
        this(game, callback);
        this.player = (UserPlayer) game.getActivePlayer();
    }

    @Override
    public void write() {
        this.removeAll();
        this.setLayout(new GridLayout(Coordinate.NUMBER_ROWS, Coordinate.NUMBER_COLUMNS));
        for (int i = Coordinate.NUMBER_ROWS - 1; i >= 0; i--) {
            for (int j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
                ImageIcon icon = this.getColors().get(this.getGame().getColor(new Coordinate(i, j)));
                Coordinate coordiante = new Coordinate(i, j);
                Square square = new Square(icon, coordiante);
                square.addActionListener(this);
                square.setBorderPainted(false);
                square.setOpaque(true);
                Border border = BorderFactory.createLineBorder(java.awt.Color.DARK_GRAY, 6);
                square.setBorder(border);
                square.setBackground(java.awt.Color.DARK_GRAY);
                this.add(square);
            }
        }
    }

    @Override
    public BoardView copy() {
        Game game = this.getGame();
        Command callback = this.callback;
        return new UserPlayerBoardView(game, callback, game.getActivePlayer());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("user action performed");
        Square square = (Square) e.getSource();
        int column = square.getColumn();
        this.player.dropToken(column);
        write();
        callback.execute();
    }
}
