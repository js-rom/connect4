package main.java.com.jsrom.connect4.views.console;

import main.java.com.jsrom.connect4.controllers.core.SaveController;
import main.java.com.jsrom.connect4.views.console.shared.Message;

import main.java.com.jsrom.utils.views.Console;
import main.java.com.jsrom.utils.views.YesNoDialog;

public class SaveView {

    public void interact(SaveController saveController) {
        YesNoDialog saveDialog = new YesNoDialog();
        saveDialog.read(Message.SAVE.toString());
        if (saveDialog.isAffirmative()) {
            if (!saveController.hasName()) {
                saveController.setName(this.askName(saveController));
            }
            saveController.save();
        }
        saveController.nextState();
    }

    private String askName(SaveController saveController) {
        String name = "";
        boolean valid = false;
        do {
            name = Console.getInstance().readString(Message.NAME.toString());
            valid = !saveController.exists(name);
            if (!valid) {
                Console.getInstance().writeln(Message.NAME_ALREADY_EXISTS.toString());
            }
        } while (!valid);
        return name;
    }
}
