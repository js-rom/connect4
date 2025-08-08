package connect4.launchers.standalone;

import connect4.controllers.implementation.Logic;

public class GraphicsConnect4 extends connect4.launchers.GraphicsConnect4 {

    @Override
    protected void createLogic() {
        this.logic = new Logic();
    }

    @Override
    protected void playGames() {
        super.playGames();
        System.exit(0);
    }

    public static void main(String[] args) throws Exception {
        new GraphicsConnect4().playGames();
    }
}
