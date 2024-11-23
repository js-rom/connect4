package connect4.views.graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import connect4.controllers.ResumeController;
import connect4.views.graphics.commands.Command;

public class mainFrame extends JFrame implements FrameView {

    private ResumeController resumeController;
    private GameLoopView panel;

    public mainFrame(ResumeController resumeController) {
        this.resumeController = resumeController;
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

    public void setPanelCallback(Command command) {
        this.panel.setCallback(command);
    }

    public void write() {
        this.revalidate();
        this.repaint();
    }

    public boolean isResumed() {
        String message;
        if (this.resumeController.isWinner()) {
            message = Message.PLAYER_WIN.toString();
            message = message.replace("#color", this.resumeController.getActiveColor().toString());
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
