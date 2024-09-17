package connect4.views.console;

import java.util.HashMap;

import connect4.types.PlayerType;

public class PlayerViewPrototypeRegistry {

    private HashMap<PlayerType, PlayerView> playerViews;

	public PlayerViewPrototypeRegistry() {

		this.playerViews = new HashMap<PlayerType, PlayerView>();

		PlayerView playerView;
		playerView = new UserPlayerView();
		this.addPlayerView(PlayerType.USER_PLAYER, playerView);
		playerView = new RandomMachinePlayerView();
		this.addPlayerView(PlayerType.RANDOM_MACHINE_PLAYER, playerView);
        playerView = new MinMaxMachinePlayerView();
		this.addPlayerView(PlayerType.MIN_MAX_MACHINE_PLAYER, playerView);
	}

	private void addPlayerView(PlayerType type, PlayerView playerView) {
		this.playerViews.put(type, playerView);
	}
	
	public PlayerView getPlayerView(PlayerType type) {
		return this.playerViews.get(type);
	}
}
