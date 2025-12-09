package connect4.views.graphics.gameLoop;

import java.util.concurrent.CountDownLatch;

public abstract class GameLoopView extends PanelView {

    private CountDownLatch latch;

    public GameLoopView(CountDownLatch latch) {
        this.latch = latch;
    }

    public void nextGameLoopView() {
        this.latch.countDown();
    }

}
