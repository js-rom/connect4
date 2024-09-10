package connect4.views;

import utils.Console;

public class YesNoDialog {

    private static char AFFIRMATIVE = 'y';
    private static char NEGATIVE = 'n';
    private static String SUFFIX = "? (" +
        YesNoDialog.AFFIRMATIVE + "/" +
        YesNoDialog.NEGATIVE + "): ";
    private static String MESSAGE = "The value must be " + YesNoDialog.AFFIRMATIVE + " or " + YesNoDialog.NEGATIVE;
    private String answer;

    public YesNoDialog() {

    }

    public void read(String message) {
        boolean ok;
        do {
            Console.getInstance().write(message);
            this.answer = Console.getInstance().readString(YesNoDialog.SUFFIX);
            ok = this.isAffirmative() || this.isNegative();
            if (!ok) {
                Console.getInstance().writeln(YesNoDialog.MESSAGE);
            }
        } while (!ok);
    }

    public boolean isAffirmative() {
        return this.getAnswer() == YesNoDialog.AFFIRMATIVE;
    }

    public boolean isNegative() {
        return this.getAnswer() == YesNoDialog.NEGATIVE;
    }

    private char getAnswer() {
        return this.answer.toLowerCase().charAt(0);
    }
}
