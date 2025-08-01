package connect4.launchers.distributed.server;

import connect4.controllers.implementation.Logic;
import connect4.launchers.distributed.server.dispatchers.DispatcherPrototype;
import connect4.launchers.distributed.server.dispatchers.FrameType;
import connect4.launchers.distributed.server.dispatchers.NumberPlayersDispatcher;
import connect4.launchers.distributed.server.dispatchers.PlayerTypesDispatcher;
import connect4.launchers.distributed.server.dispatchers.StateDispatcher;

public class LogicImplementationServer extends Logic {

    public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
        dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.NUMBRE_PPLAYERS, new NumberPlayersDispatcher(this.startController));
        dispatcherPrototype.add(FrameType.PLAYER_TYPES, new PlayerTypesDispatcher(this.startController));
        dispatcherPrototype.add(FrameType.RESET, new ResetDispatcher(this.startController));
    }
}
