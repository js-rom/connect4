package connect4.models;

import connect4.types.PlayerType;
import java.util.HashMap;

public class PlayerPrototype {

    private HashMap<PlayerType, Player> players;

    public PlayerPrototype() {

        this.players = new HashMap<PlayerType, Player>();

        Player player;
        player = new UserPlayer();
        this.addPlayer(PlayerType.USER_PLAYER, player);
        player = new RandomMachinePlayer();
        this.addPlayer(PlayerType.RANDOM_MACHINE_PLAYER, player);
        player = new MinMaxMachinePlayer();
        this.addPlayer(PlayerType.MIN_MAX_MACHINE_PLAYER, player);
    }

    private void addPlayer(PlayerType type, Player player) {
        this.players.put(type, player);
    }

    public Player getPlayer(PlayerType type) {
        return this.players.get(type);
    }
}
