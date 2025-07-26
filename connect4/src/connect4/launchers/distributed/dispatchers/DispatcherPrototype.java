package connect4.launchers.distributed.dispatchers;

import java.io.IOException;
import java.util.Map;

import utils.tcpip.Server;

public class DispatcherPrototype {

    private Server server;
    private Map<FrameType, Dispatcher> dispatcherMap;

    public DispatcherPrototype() throws IOException {
        this.server = new Server("2020");
    }

    public void add(FrameType frameType, Dispatcher dispatcher) {
        this.dispatcherMap.put(frameType, dispatcher);
        dispatcher.associate(this.server);
    }

    public void serve() {
        try {
            server.listen();
            FrameType frameType;
            do {
                frameType = FrameType.parser(this.server.receiveLine());
                if (frameType != FrameType.CLOSE) {
                    this.dispatcherMap.get(frameType).dispatch();
                }
            } while (frameType != FrameType.CLOSE);
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
