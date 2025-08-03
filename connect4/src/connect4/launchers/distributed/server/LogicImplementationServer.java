package connect4.launchers.distributed.server;

import connect4.controllers.implementation.Logic;
import connect4.launchers.distributed.server.dispatchers.ActiveColorDispatcher;
import connect4.launchers.distributed.server.dispatchers.ActivePlayerTypeDispatcher;
import connect4.launchers.distributed.server.dispatchers.AddPlayerDispatcher;
import connect4.launchers.distributed.server.dispatchers.ColorDispatcher;
import connect4.launchers.distributed.server.dispatchers.ColumnDispatcher;
import connect4.launchers.distributed.server.dispatchers.DispatcherPrototype;
import connect4.launchers.distributed.server.dispatchers.DropTokenDispatcher;
import connect4.launchers.distributed.server.dispatchers.FrameType;
import connect4.launchers.distributed.server.dispatchers.IsCompleteDispatcher;
import connect4.launchers.distributed.server.dispatchers.IsFinishedDispatcher;
import connect4.launchers.distributed.server.dispatchers.IsResetDispatcher;
import connect4.launchers.distributed.server.dispatchers.IsWinnerDispatcher;
import connect4.launchers.distributed.server.dispatchers.NextDispatcher;
import connect4.launchers.distributed.server.dispatchers.NextStateDispatcher;
import connect4.launchers.distributed.server.dispatchers.NumberPlayersDispatcher;
import connect4.launchers.distributed.server.dispatchers.PlayerTypesDispatcher;
import connect4.launchers.distributed.server.dispatchers.RedoDispatcher;
import connect4.launchers.distributed.server.dispatchers.RedoableDispatcher;
import connect4.launchers.distributed.server.dispatchers.RegisterMementoDispatcher;
import connect4.launchers.distributed.server.dispatchers.ResetDispatcher;
import connect4.launchers.distributed.server.dispatchers.StateDispatcher;
import connect4.launchers.distributed.server.dispatchers.UndoDispatcher;
import connect4.launchers.distributed.server.dispatchers.UndoableDispatcher;

public class LogicImplementationServer extends Logic {

    public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
        dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.NUMBRE_PPLAYERS, new NumberPlayersDispatcher(this.startController));
        dispatcherPrototype.add(FrameType.PLAYER_TYPES, new PlayerTypesDispatcher(this.startController));
        dispatcherPrototype.add(FrameType.RESET, new ResetDispatcher(this.startController));
        dispatcherPrototype.add(FrameType.IS_RESET, new IsResetDispatcher(this.startController));
        dispatcherPrototype.add(FrameType.ADD_PLAYER, new AddPlayerDispatcher(this.startController));
        dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.ACTIVE_PLAYER_TYPE, new ActivePlayerTypeDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.COLOR, new ColorDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.IS_FINISHED, new IsFinishedDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.REGISTER_MEMENTO, new RegisterMementoDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.DROP_TOKEN, new DropTokenDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.COLUMN, new ColumnDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.IS_WINNER, new IsWinnerDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.IS_COMPLETE, new IsCompleteDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.START_NEXT_STATE, new NextStateDispatcher(this.startController));
        dispatcherPrototype.add(FrameType.ACTIVE_COLOR, new ActiveColorDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.NEXT, new NextDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.PLAY_NEXT_STATE, new NextStateDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.RESUME_NEXT_STATE, new NextStateDispatcher(this.resumeController));
    }
}
