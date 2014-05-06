package com.jbs.ninja.gui;

import com.jbs.ninja.Main;
import com.jbs.ninja.asset.AssetManager;
import com.jbs.ninja.game.Game;

public class PlayButton extends Button {

	public PlayButton() {
		super(AssetManager.playButton, Main.centered.x - (AssetManager.playButton.getTexture().getWidth() / 2), Main.centered.y, AssetManager.playButton.getTexture().getWidth(), AssetManager.playButton.getTexture().getHeight());
	}

	@Override
	public void onClick() {
		Main.activeGame.switchState(new Game());
	}
}
