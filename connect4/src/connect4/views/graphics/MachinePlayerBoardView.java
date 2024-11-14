package connect4.views.graphics;

import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.border.Border;
import connect4.models.Game;
import connect4.models.MachinePlayer;
import connect4.models.Player;
import connect4.views.graphics.commands.Command;
import utils.models.Coordinate;

public class MachinePlayerBoardView extends BoardView {

    private MachinePlayer player;
    private Command callback;

    public MachinePlayerBoardView(Game game, Command callback) {
        super(game);
        this.callback = callback;
    }

    public MachinePlayerBoardView(Game game, Command callback, Player player) {
        this(game, callback);
        this.player = (MachinePlayer) game.getActivePlayer();
        this.dropToken();
    }

    public void write() { 
        this.removeAll();
        this.setLayout(new GridLayout(Coordinate.NUMBER_ROWS, Coordinate.NUMBER_COLUMNS));
        for (int i = Coordinate.NUMBER_ROWS - 1; i >= 0; i--) {
            for (int j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
                ImageIcon icon = this.getColors().get(this.getGame().getColor(new Coordinate(i, j)));
                JLabel square = new JLabel(icon);
                square.setOpaque(true);
                Border border = BorderFactory.createLineBorder(java.awt.Color.DARK_GRAY, 6);
                square.setBorder(border);
                square.setBackground(java.awt.Color.DARK_GRAY);
                this.add(square);
            }
        }
    }

    public int getColumn() {
        int column = this.player.getColumn();
        return column;
    }

    public void dropToken() {
        //player.dropToken(getColumn());
        //write();
        int delay = 1000;
        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.dropToken(getColumn());
                write();
                callback.execute();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public BoardView copy() {
        Game game = this.getGame();
        Command callback = this.callback;
        return new MachinePlayerBoardView(game, callback, game.getActivePlayer());
    }
}
