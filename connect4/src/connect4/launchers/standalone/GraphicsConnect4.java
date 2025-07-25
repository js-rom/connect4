package connect4.launchers.standalone;

import java.util.concurrent.CountDownLatch;

import connect4.Connect4;
import connect4.launchers.factories.LauncherProvider;
import connect4.launchers.factories.StandaloneGraphics;
import connect4.views.graphics.GraphicsView;

public class GraphicsConnect4 extends Connect4 {

    private CountDownLatch latch;

    protected void playGames() {
        GraphicsView graphicsView = (GraphicsView) launcherProvider.getView();
        do {
            this.latch = new CountDownLatch(1);
            graphicsView.setLatch(latch);
            if (launcherProvider.getController() != null) {
                launcherProvider.getController().accept(graphicsView);
            }
            try {
                latch.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (launcherProvider.getController() != null);
        System.exit(0);
    }

    @Override
    protected LauncherProvider createLauncherProvider() {
        return this.launcherProvider = new StandaloneGraphics();
    }

    public static void main(String[] args) throws Exception {
        new GraphicsConnect4().playGames();
    }
}
