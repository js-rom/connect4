package connect4.views.graphics;

import java.util.concurrent.CountDownLatch;

import javax.swing.JOptionPane;

import connect4.controllers.core.ControllerVisitor;
import connect4.controllers.core.PlayController;
import connect4.controllers.core.ResumeController;
import connect4.controllers.core.SaveController;
import connect4.controllers.core.StartController;
import connect4.views.View;
import connect4.views.graphics.gameLoop.start.StartPanelView;

public class GraphicsView implements View, ControllerVisitor {

    MainFrame frame;
    CountDownLatch latch;

    public GraphicsView() {
        this.frame = new MainFrame();
    }

    @Override
    public void start(StartController startController) {
        this.frame.setPanel(new StartPanelView(startController, this.latch));
        this.frame.interact();
        this.frame.write();
    }

    @Override
    public void play(PlayController playController) {
        this.frame
                .setPanel(new connect4.views.graphics.gameLoop.play.Factory(playController, this.latch)
                        .createPlayPanelView());
    }

    @Override
    public boolean resume(ResumeController resumeController) {
        this.frame.write();
        boolean isResumed = this.frame.isResumed(resumeController);
        if (isResumed) {
            resumeController.reset();
        } else {
            resumeController.nextState();
        }
        this.latch.countDown();
        return isResumed;
    }

    @Override
    public void save(SaveController saveController) {

        class SaveDialog {

            private boolean isCanceled = false;
            String name = "";

            public void interact() {
                if (isSaveConfirmed()) {
                    this.save();
                }
                saveController.nextState();
                GraphicsView.this.latch.countDown();
            }

            private boolean isSaveConfirmed() {
                int result = JOptionPane.showConfirmDialog(
                        GraphicsView.this.frame,
                        Message.SAVE_GAME.toString(),
                        "Select an Option",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                return JOptionPane.YES_OPTION == result;
            }

            private void save() {
                this.setName();
                if (!isCanceled) {
                    saveController.save();
                }
            }

            private void setName() {
                if (!saveController.hasName()) {
                    boolean valid = false;
                    do {
                        name = JOptionPane.showInputDialog(
                                GraphicsView.this.frame,
                                Message.ENTER_GAME_NAME.toString(),
                                "Input",
                                JOptionPane.OK_OPTION);
                        isCanceled = (name == null);
                        valid = !saveController.exists(name) || isCanceled;
                        if (!valid) {
                            JOptionPane.showMessageDialog(
                                    GraphicsView.this.frame,
                                    Message.NAME_ALREADY_EXISTS.toString(),
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }

                    } while (!valid);

                    if (!isCanceled) {
                        saveController.setName(name);
                    }
                }
            }

        }

        new SaveDialog().interact();
      
    }

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void visit(StartController startController) {
        this.start(startController);
    }

    @Override
    public void visit(PlayController playController) {
        this.play(playController);
    }

    @Override
    public boolean visit(ResumeController resumeController) {
        return this.resume(resumeController);
    }

    @Override
    public void visit(SaveController saveController) {
        this.save(saveController);
    }

}
