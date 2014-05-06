package com.jbs.ninja.game.Tile;

import java.util.HashMap;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jbs.ninja.Tickable;
import com.jbs.ninja.asset.TextureAsset;

public class Tile implements Tickable {

	public static HashMap<Byte, Tile> tiles = new HashMap<Byte, Tile>();
	
	public static Tile Grass = new TileGrass();
	
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
	
	public static void init() {
		tiles.put((byte) 0, Grass);
	}
}
