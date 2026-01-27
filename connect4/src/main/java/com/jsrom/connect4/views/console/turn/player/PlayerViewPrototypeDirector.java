package com.jsrom.connect4.views.console.turn.player;

import com.jsrom.connect4.types.PlayerType;

public class PlayerViewPrototypeDirector {

    public PlayerView get(PlayerViewPrototypeRegistry playerViewRegistry, PlayerType type) {
		PlayerView playerView = playerViewRegistry.getPlayerView(type);
		return playerView.copy();
	}
}
