package connect4.views.graphics;

import connect4.controllers.StartController;
import connect4.types.PlayerType;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class StartPanelView extends GameLoopView implements ActionListener {

    private StartController startController;
    private final JComboBox<PlayerType>[] cBoxPlayers;
    protected JButton button;
    private CountDownLatch latch;

    public StartPanelView(StartController startController, CountDownLatch latch) {
        assert (startController != null);
        this.startController = startController;
        this.latch = latch;
        this.cBoxPlayers = new JComboBox[this.startController.getNumberPlayers()];
    }

    public void write() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(new JLabel("SELECT PLAYERS:"));
        for (int i = 0; i < this.startController.getNumberPlayers(); i++) {
            this.cBoxPlayers[i] = new JComboBox<>(this.startController.getPlayerTypes());
            this.add(this.cBoxPlayers[i]);
        }
        this.button = new JButton("Play");
        this.add(button);
        this.button.addActionListener(this);
    }

    public void addPlayers() {
        this.startController.reset();
        for (JComboBox<PlayerType> jComboBox : cBoxPlayers) {
            PlayerType playerType = (PlayerType) jComboBox.getSelectedItem();
            this.startController.addPlayer(playerType);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.addPlayers();
        this.startController.nextState();
        this.latch.countDown();
    }

}
