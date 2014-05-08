package com.jbs.ninja.game.Tile;

import java.util.HashMap;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jbs.ninja.Tickable;
import com.jbs.ninja.asset.TextureRegionAsset;

public abstract class Tile implements Tickable {

	public static int TILESIZE = 64;
	public static HashMap<Byte, Tile> tiles = new HashMap<Byte, Tile>();
	
	public static Tile Grass = new TileGrass();
	public static Tile Dirt = new TileDirt();
	
	private TextureRegionAsset texture;
	
	public Tile(TextureRegionAsset texture) {
		this.texture = texture;
	}
	
	@Override
	public void tick() {
	}

	public void render(SpriteBatch batch, int x, int y) {
		batch.draw(texture.getTexture(), x, y, TILESIZE, TILESIZE);
	}
	
	public abstract byte getID();
	
	public static void init() {
		tiles.put((byte) 1, Grass);
		tiles.put((byte) 2, Dirt);
	}

	public static Tile getTile(byte id) {
		return tiles.get(id);
	}
}
