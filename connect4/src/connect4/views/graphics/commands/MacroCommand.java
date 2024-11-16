package connect4.views.graphics.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MacroCommand implements Command{

    private List<Command> commands;

    public MacroCommand() {
        this.commands = new ArrayList<>();
    }

    @Override
    public void execute() {
        ListIterator<Command> iterator = commands.listIterator();
        while(iterator.hasNext()) {
            iterator.next().execute();
        }
    }

    public void add(Command command) {
        this.commands.add(command);
    }

}
