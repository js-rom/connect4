package connect4.views;

import connect4.types.PlayerType;

public class PlayerViewPrototypeDirector {

    public PlayerView get(PlayerViewPrototypeRegistry playerViewRegistry, PlayerType type) {
		PlayerView playerView = playerViewRegistry.getPlayerView(type);
		return playerView.copy();
	}
}
