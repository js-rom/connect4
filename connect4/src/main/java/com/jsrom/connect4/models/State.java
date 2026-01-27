package com.jsrom.connect4.models;

import com.jsrom.connect4.types.StateValue;

public class State {

    private StateValue stateValue;

    public State() {
        this.reset();
    }

    public void reset() {
        this.stateValue = StateValue.INITIAL;
    }

    public void next() {
        this.stateValue = StateValue.values()[(this.stateValue.ordinal() + 1) % StateValue.values().length];
    }

    public StateValue getValueState() {
        return this.stateValue;
    }

    public void setValueState(StateValue stateValue) {
        this.stateValue = stateValue;
    }
}
