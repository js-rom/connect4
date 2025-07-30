package connect4.views.console;

import java.util.EnumMap;
import java.util.Map;

import connect4.controllers.core.PlayController;
import connect4.types.PlayerType;

public class PlayerViewPrototypeRegistry {

    private Map<PlayerType, PlayerView> playerViews;

	public PlayerViewPrototypeRegistry(PlayController playController) {

		this.playerViews = new EnumMap<>(PlayerType.class);

		PlayerView playerView;
		playerView = new UserPlayerView(playController);
		this.addPlayerView(PlayerType.USER_PLAYER, playerView);
		playerView = new RandomMachinePlayerView(playController);
		this.addPlayerView(PlayerType.RANDOM_MACHINE_PLAYER, playerView);
        playerView = new MinMaxMachinePlayerView(playController);
		this.addPlayerView(PlayerType.MIN_MAX_MACHINE_PLAYER, playerView);
	}

	private void addPlayerView(PlayerType type, PlayerView playerView) {
		this.playerViews.put(type, playerView);
	}
	
	public PlayerView getPlayerView(PlayerType type) {
		return this.playerViews.get(type);
	}
}
