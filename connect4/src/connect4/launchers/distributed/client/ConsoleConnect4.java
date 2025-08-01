package connect4.launchers.distributed.client;

import connect4.controllers.proxies.Logic;

public class ConsoleConnect4 extends connect4.launchers.GraphicsConnect4 {

    @Override
    protected void createLogic() {
        this.logic = new Logic();
    }

    public static void main(String[] args) throws Exception {
        new ConsoleConnect4().playGames();
    }

}
