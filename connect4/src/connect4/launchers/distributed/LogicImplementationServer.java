package connect4.launchers.distributed;

import connect4.controllers.implementation.Logic;
import connect4.launchers.distributed.dispatchers.DispatcherPrototype;
import connect4.launchers.distributed.dispatchers.FrameType;

public class LogicImplementationServer extends Logic {

    public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
       //dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.StartController));
    }
}
