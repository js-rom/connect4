package connect4.launchers.distributed.client;

import connect4.controllers.proxies.Logic;

public class ConsoleConnect4 extends connect4.launchers.ConsoleConnect4 {

    @Override
    protected void createLogic() {
        this.logic = new Logic();
    }

    @Override
    protected void playGames() {
        super.playGames();
        ((Logic) this.logic).close();
    }

    public static void main(String[] args) throws Exception {
        new ConsoleConnect4().playGames();
    }

}
