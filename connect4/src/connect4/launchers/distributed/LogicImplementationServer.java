package connect4.launchers.distributed;

import connect4.controllers.implementation.Logic;
import connect4.launchers.distributed.dispatchers.DispatcherPrototype;
import connect4.launchers.distributed.dispatchers.FrameType;
import connect4.launchers.distributed.dispatchers.NumberPlayersDispatcher;
import connect4.launchers.distributed.dispatchers.PlayerTypesDispatcher;
import connect4.launchers.distributed.dispatchers.StateDispatcher;

public class LogicImplementationServer extends Logic {

    public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
       dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playController));
       dispatcherPrototype.add(FrameType.NUMBRE_PPLAYERS, new NumberPlayersDispatcher(this.startController));
       dispatcherPrototype.add(FrameType.PLAYER_TYPES, new PlayerTypesDispatcher(this.startController));
    }
}
