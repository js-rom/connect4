package connect4.views.graphics.gameLoop.start;

import connect4.controllers.core.StartController;
import connect4.types.PlayerType;
import connect4.views.graphics.gameLoop.GameLoopView;

import java.awt.Component;
import java.awt.FlowLayout;
import java.util.concurrent.CountDownLatch;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartPanelView extends GameLoopView {

    private StartController startController;

    public StartPanelView(StartController startController, CountDownLatch latch) {
        super(latch);
        assert (startController != null);
        this.startController = startController;
    }

    public void write() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.writeNewGameMenu();
        this.writeOpenGameMenu();
    }

    private void writeNewGameMenu() {

        class NewGameMenu {
            JPanel newGamePanel;
            JButton button;
            private final JComboBox<PlayerType>[] cBoxPlayers;

            public NewGameMenu() {
                this.newGamePanel = new JPanel();
                this.newGamePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
                this.newGamePanel.add(new JLabel("SELECT PLAYERS:"));
                this.cBoxPlayers = new JComboBox[StartPanelView.this.startController.getNumberPlayers()];
                for (int i = 0; i < StartPanelView.this.startController.getNumberPlayers(); i++) {
                    this.cBoxPlayers[i] = new JComboBox<>(StartPanelView.this.startController.getPlayerTypes());
                    newGamePanel.add(this.cBoxPlayers[i]);
                }
                this.button = new JButton("Play");
                button.addActionListener(e -> {
                    this.addPlayers();
                    StartPanelView.this.startController.start();
                    StartPanelView.this.nextGameLoopView();
                });
                newGamePanel.add(button);
                StartPanelView.this.add(newGamePanel);
            }

            private void addPlayers() {
                for (JComboBox<PlayerType> jComboBox : cBoxPlayers) {
                    PlayerType playerType = (PlayerType) jComboBox.getSelectedItem();
                    StartPanelView.this.startController.addPlayer(playerType);
                }
            }

            public JPanel getNewGamePanel() {
                return this.newGamePanel;
            }
        }

        this.add(new NewGameMenu().getNewGamePanel());

    }

    private void writeOpenGameMenu() {
        JPanel openGamePanel = new JPanel();
        openGamePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        openGamePanel.add(new JLabel("OPEN SAVED GAME:"));
        JComboBox<String> jComboBox = new JComboBox<>(this.startController.getGameNames());
        openGamePanel.add(jComboBox);
        JButton openGame = new JButton("Open");
        openGame.addActionListener(e -> {
            if (jComboBox.getSelectedItem() != null) {
                String gameName = (String) jComboBox.getSelectedItem();
                this.startController.start(gameName);
                this.nextGameLoopView();
            }
        });
        openGamePanel.add(openGame);
        this.add(openGamePanel);
    }

}
