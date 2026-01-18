package com.jsrom.connect4.launchers.distributed.server;

import com.jsrom.connect4.controllers.implementation.Logic;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.ActiveColor;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.ActivePlayerType;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.AddPlayer;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.Color;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.Column;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.DispatcherPrototype;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.DropToken;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.ExistGameName;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.GetGameNames;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.HasGameName;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.HasSavedGames;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.IsComplete;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.IsFinished;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.IsReset;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.IsWinner;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.Next;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.NextState;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.NumberPlayers;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.PlayerTypes;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.Redo;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.Redoable;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.RegisterMemento;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.Reset;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.Save;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.SetGameName;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.StartWithName;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.State;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.Undo;
import com.jsrom.connect4.launchers.distributed.server.dispatchers.Undoable;
import com.jsrom.connect4.persistence.files.SessionDAO;
import com.jsrom.connect4.types.FrameType;

public class LogicImplementationServer extends Logic {

    public LogicImplementationServer() {
        super(new SessionDAO());
    }

    public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
        dispatcherPrototype.add(FrameType.STATE, new State(this.playController));
        dispatcherPrototype.add(FrameType.NUMBRE_PPLAYERS, new NumberPlayers(this.startController));
        dispatcherPrototype.add(FrameType.PLAYER_TYPES, new PlayerTypes(this.startController));
        dispatcherPrototype.add(FrameType.RESET, new Reset(this.startController));
        dispatcherPrototype.add(FrameType.IS_RESET, new IsReset(this.startController));
        dispatcherPrototype.add(FrameType.ADD_PLAYER, new AddPlayer(this.startController));
        dispatcherPrototype.add(FrameType.UNDO, new Undo(this.playController));
        dispatcherPrototype.add(FrameType.UNDOABLE, new Undoable(this.playController));
        dispatcherPrototype.add(FrameType.REDO, new Redo(this.playController));
        dispatcherPrototype.add(FrameType.REDOABLE, new Redoable(this.playController));
        dispatcherPrototype.add(FrameType.ACTIVE_PLAYER_TYPE, new ActivePlayerType(this.playController));
        dispatcherPrototype.add(FrameType.COLOR, new Color(this.playController));
        dispatcherPrototype.add(FrameType.IS_FINISHED, new IsFinished(this.playController));
        dispatcherPrototype.add(FrameType.REGISTER_MEMENTO, new RegisterMemento(this.playController));
        dispatcherPrototype.add(FrameType.DROP_TOKEN, new DropToken(this.playController));
        dispatcherPrototype.add(FrameType.COLUMN, new Column(this.playController));
        dispatcherPrototype.add(FrameType.IS_WINNER, new IsWinner(this.playController));
        dispatcherPrototype.add(FrameType.IS_COMPLETE, new IsComplete(this.playController));
        dispatcherPrototype.add(FrameType.START_NEXT_STATE, new NextState(this.startController));
        dispatcherPrototype.add(FrameType.ACTIVE_COLOR, new ActiveColor(this.playController));
        dispatcherPrototype.add(FrameType.NEXT, new Next(this.playController));
        dispatcherPrototype.add(FrameType.HAS_GAME_NAME, new HasGameName(this.saveController));
        dispatcherPrototype.add(FrameType.SET_GAME_NAME, new SetGameName(this.saveController));
        dispatcherPrototype.add(FrameType.EXISTS_GAME_NAME, new ExistGameName(this.saveController));
        dispatcherPrototype.add(FrameType.SAVE, new Save(this.saveController));
        dispatcherPrototype.add(FrameType.PLAY_NEXT_STATE, new NextState(this.playController));
        dispatcherPrototype.add(FrameType.RESUME_NEXT_STATE, new NextState(this.resumeController));
        dispatcherPrototype.add(FrameType.GET_GAME_NAMES, new GetGameNames(this.startController));
        dispatcherPrototype.add(FrameType.HAS_SAVED_GAMES, new HasSavedGames(this.startController));
        dispatcherPrototype.add(FrameType.START_NAME, new StartWithName(this.startController));
    }
}
