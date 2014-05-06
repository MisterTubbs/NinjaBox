package com.jbs.ninja.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.jbs.ninja.GameObject;
import com.jbs.ninja.InputProxy;
import com.jbs.ninja.asset.TextureAsset;

public abstract class Button implements GameObject {

	private TextureAsset texture;
	private Vector2 loc, size;
	
	public Button(TextureAsset texture, float x, float y, float w, float h) {
		this.loc = new Vector2(x, y);
		this.size = new Vector2(w, h);
		this.texture = texture;
	}
	
	@Override
	public void tick() {
		if(Gdx.input.isTouched() && isClicked()) onClick();
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(texture.getTexture(), loc.x, loc.y, size.x, size.y);
	}

	public boolean isClicked() {
		Vector2 pos = InputProxy.getTouch();
		int x = (int) pos.x;
		int y = (int) pos.y;
		
		return x >= loc.x && y >= loc.y && x <= loc.x + size.x && y <= loc.y + size.y;
	}
	
	public abstract void onClick();
}
