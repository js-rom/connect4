package connect4.views.graphics;

import connect4.models.Game;
import connect4.models.Turn;
import connect4.types.PlayerType;
import connect4.views.graphics.commands.Command;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class StartPanelView extends GameLoopView implements ActionListener {

    private final PlayerType[] players;
    private final JComboBox<PlayerType>[] CBoxPlayers;
    protected JButton button;

    public StartPanelView(Game game) {
        super(game);
        this.players = PlayerType.values();
        this.CBoxPlayers = new JComboBox[Turn.NUMBER_PLAYERS];
    }

    public StartPanelView(Game game, Command callback) {
        this(game);
        this.setCallback(callback);
    }

    public void write() {
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
        this.getCallback().execute();
    }

}
