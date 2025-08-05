package connect4.launchers;

import java.util.concurrent.CountDownLatch;

import connect4.views.graphics.GraphicsView;

public abstract class GraphicsConnect4 extends Connect4 {

    private CountDownLatch latch;

    @Override
    protected void createView() {
        this.view = new GraphicsView();
    }

    @Override
    protected void playGames() {
        GraphicsView graphicsView = (GraphicsView) this.view;
        do {
            this.latch = new CountDownLatch(1);
            graphicsView.setLatch(latch);
            if (this.logic.getController() != null) {
                this.logic.getController().accept(graphicsView);
            }
            try {
                latch.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (this.logic.getController() != null);
    }

}
