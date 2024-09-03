package utils.menu;

import utils.Console;

public class QuitOption extends Option {

    private boolean executed;

    public QuitOption() {
        super("Salir");
        this.executed = false;
    }

    public void interact() {
        this.executed = true;
        Console.getInstance().writeln("Adiós");
    }

    protected boolean isExecuted() {
        return this.executed;
    }

}
