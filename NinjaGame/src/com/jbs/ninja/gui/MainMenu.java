package com.jbs.ninja.gui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jbs.ninja.GameObject;

public class MainMenu implements GameObject {

	private Button play;
	
	public MainMenu() {
		play = new PlayButton();
 	}
	
	@Override
	public void tick() {
		play.tick();
	}

	@Override
	public void render(SpriteBatch batch) {
		play.render(batch);
	}
}
