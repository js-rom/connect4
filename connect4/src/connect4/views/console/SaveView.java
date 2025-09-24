package connect4.views.console;

import connect4.controllers.core.SaveController;
import connect4.views.console.shared.Message;
import utils.views.Console;
import utils.views.YesNoDialog;

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
