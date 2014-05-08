package com.jbs.ninja.gui;

import com.jbs.ninja.Main;
import com.jbs.ninja.asset.Assets;
import com.jbs.ninja.game.Game;

public class PlayButton extends Button {

	public PlayButton() {
		super(Assets.playButton, Main.centered.x - (Assets.playButton.getTexture().getWidth() / 2), Main.centered.y, Assets.playButton.getTexture().getWidth(), Assets.playButton.getTexture().getHeight());
	}

	@Override
	public void onClick() {
		Main.activeGame.switchState(new Game());
	}
}
