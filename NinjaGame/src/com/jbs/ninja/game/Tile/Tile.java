package com.jbs.ninja.game.Tile;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jbs.ninja.Tickable;
import com.jbs.ninja.asset.TextureAsset;

public class Tile implements Tickable {

	private TextureAsset texture;
	
	public Tile(TextureAsset texture) {
		this.texture = texture;
	}
	
	@Override
	public void tick() {
	}

	public void render(SpriteBatch batch, int x, int y) {
		batch.draw(texture.getTexture(), x, y, texture.getTexture().getWidth(), texture.getTexture().getHeight());
	}
	
	public void dispose() {
		texture.getTexture().dispose();
	}
}
