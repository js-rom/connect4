package connect4.launchers.standalone;

import connect4.controllers.implementation.Logic;
import connect4.daos.SessionDAO;

public class ConsoleConnect4 extends connect4.launchers.ConsoleConnect4 {

    protected void createLogic() {
        this.logic = new Logic(new SessionDAO());
    }

    public static void main(String[] args) throws Exception {
        new ConsoleConnect4().playGames();
    }

}