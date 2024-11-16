package connect4.views.graphics;

import connect4.models.Game;
import connect4.models.Turn;
import connect4.types.PlayerType;
import connect4.views.graphics.commands.Command;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerSelectionView extends PanelView implements ActionListener {

    private final PlayerType[] players;
    private final JComboBox<PlayerType>[] CBoxPlayers;
    protected JButton button;
    private Game game;
    private Command callback;

    public PlayerSelectionView(Game game, Command callback) {

        this.game = game;
        this.callback = callback;
        this.players = PlayerType.values();
        this.CBoxPlayers = new JComboBox[Turn.NUMBER_PLAYERS];
        this.write();
    }

    protected void write() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(new JLabel("SELECT PLAYERS:"));
        for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
            this.CBoxPlayers[i] = new JComboBox<PlayerType>(this.players);
            this.add(this.CBoxPlayers[i]);
        }
        this.button = new JButton("Play");
        this.add(button);
        this.button.addActionListener(this);
    }

    public void addPlayers() {
        this.game.reset();
        for (JComboBox<PlayerType> jComboBox : CBoxPlayers) {
            PlayerType playerType = (PlayerType) jComboBox.getSelectedItem();
            this.game.getTurn().addPlayer(playerType);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.addPlayers();
        callback.execute();
    }

}
