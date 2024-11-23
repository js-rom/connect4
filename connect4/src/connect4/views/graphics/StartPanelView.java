package connect4.views.graphics;

import connect4.controllers.StartController;
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

    private StartController startController;
    private final PlayerType[] players;
    private final JComboBox<PlayerType>[] CBoxPlayers;
    protected JButton button;

    public StartPanelView(StartController startController) {
        assert(startController != null);
        this.startController = startController;
        this.players = PlayerType.values();
        this.CBoxPlayers = new JComboBox[Turn.NUMBER_PLAYERS];
    }

    public StartPanelView(StartController startController, Command callback) {
        this(startController);
        assert(callback != null);
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
        this.startController.reset();
        for (JComboBox<PlayerType> jComboBox : CBoxPlayers) {
            PlayerType playerType = (PlayerType) jComboBox.getSelectedItem();
            this.startController.getTurn().addPlayer(playerType);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.addPlayers();
        this.getCallback().execute();
    }

}
