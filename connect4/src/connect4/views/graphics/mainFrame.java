package connect4.views.graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import connect4.controllers.ResumeController;

public class MainFrame extends JFrame implements FrameView {

    private GameLoopView panel;

    public MainFrame() {
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void interact() {
        this.setVisible(true);
    }

    public void setPanel(GameLoopView panel) {
        if (this.panel != null) {
            this.remove(this.panel);
        }
        this.panel = panel;
        this.add(this.panel);
        this.panel.write();
        this.write();
    }

    public void write() {
        this.revalidate();
        this.repaint();
    }

    public boolean isResumed(ResumeController resumeController) {
        String message;
        if (resumeController.isWinner()) {
            message = Message.PLAYER_WIN.toString();
            message = message.replace("#color", resumeController.getActiveColor().toString());
        } else {
            message = Message.PLAYERS_TIED.toString();
        }

        message += "\n";
        message += Message.RESUME.toString();
        int result = JOptionPane.showConfirmDialog(
                this,
                message,
                "Select an Option",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        this.setVisible(false);
        return JOptionPane.YES_OPTION == result;
    }
}
