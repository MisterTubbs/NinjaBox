package com.jbs.ninja.gui;

import com.jbs.ninja.Main;
import com.jbs.ninja.asset.Manager;
import com.jbs.ninja.game.Game;

public class PlayButton extends Button {

	public PlayButton() {
		super(Manager.playButton, Main.centered.x - (Manager.playButton.getTexture().getWidth() / 2), Main.centered.y, Manager.playButton.getTexture().getWidth(), Manager.playButton.getTexture().getHeight());
	}

	@Override
	public void onClick() {
		Main.activeGame.switchState(new Game());
	}
}
