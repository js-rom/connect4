package connect4;

import java.util.concurrent.CountDownLatch;

import connect4.controllers.PlayController;
import connect4.controllers.ResumeController;
import connect4.controllers.StartController;
import connect4.views.View;
import connect4.views.graphics.GraphicsView;

public class GraphicsConnect4 extends Connect4 {

    private CountDownLatch latch;

    protected void playGames() {
        GraphicsView graphicsView = (GraphicsView) this.getView();
        do {
            this.latch = new CountDownLatch(1);
            graphicsView.setLatch(latch);
            if (logic.getController() instanceof StartController) {
                graphicsView.start((StartController) logic.getController());
            } else {
                if (logic.getController() instanceof PlayController) {
                    graphicsView.play((PlayController) logic.getController());
                } else {
                   graphicsView.resume((ResumeController) logic.getController());
                }
            }

            try {
                latch.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (logic.getController() != null);
         System.exit(0);
    }

    @Override
    protected View createView() {
        return new GraphicsView();
    }

    public static void main(String[] args) throws Exception {
        new GraphicsConnect4().playGames();
    }
}
