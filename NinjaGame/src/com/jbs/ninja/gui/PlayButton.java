package com.jbs.ninja.gui;

import com.jbs.ninja.Main;
<<<<<<< HEAD
import com.jbs.ninja.asset.Manager;
=======
import com.jbs.ninja.asset.Assets;
>>>>>>> ab345cac2d877509090f72ddfb79d1797eb1648a
import com.jbs.ninja.game.Game;

public class PlayButton extends Button {

	public PlayButton() {
<<<<<<< HEAD
		super(Manager.playButton, Main.centered.x - (Manager.playButton.getTexture().getWidth() / 2), Main.centered.y, Manager.playButton.getTexture().getWidth(), Manager.playButton.getTexture().getHeight());
=======
		super(Assets.playButton, Main.centered.x - (Assets.playButton.getTexture().getWidth() / 2), Main.centered.y, Assets.playButton.getTexture().getWidth(), Assets.playButton.getTexture().getHeight());
>>>>>>> ab345cac2d877509090f72ddfb79d1797eb1648a
	}

	@Override
	public void onClick() {
		Main.activeGame.switchState(new Game());
	}
}
