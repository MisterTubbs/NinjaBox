package com.jbs.ninja.gui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jbs.ninja.GameObject;

public class MainMenu implements GameObject {

	private Button play, editor;
	
	public MainMenu() {
		play = new PlayButton();
		editor = new EditorButton();
 	}
	
	@Override
	public void tick() {
		play.tick();
		editor.tick();
	}

	@Override
	public void render(SpriteBatch batch) {
		play.render(batch);
		editor.render(batch);
	}
}
