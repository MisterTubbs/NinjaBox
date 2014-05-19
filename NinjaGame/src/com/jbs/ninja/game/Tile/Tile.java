package com.jbs.ninja.game.Tile;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jbs.ninja.Tickable;
import com.jbs.ninja.asset.Assets;
import com.jbs.ninja.asset.TextureAsset;

public abstract class Tile implements Tickable {

	public static final int TILESIZE = 64;
	
	public static final byte NONE = 0;
	public static final byte GRASS = 1;
	public static final byte DIRT = 2;
	public static final Tile tileTypes[] = {
		null,
		new TileGrass(),
		new TileDirt()
	};
	
	private TextureAsset texture;
	
	public Tile(TextureAsset texture) {
		this.texture = texture;
	}
	
	@Override
	public void tick() {
	}

	public void render(SpriteBatch batch, float x, float y) {
		batch.draw(texture, x, y, TILESIZE, TILESIZE );
	}
	public void render(SpriteBatch batch, int tileID, float x, float y) {
		batch.draw(Assets.tileset.getTile(tileID), x, y, TILESIZE, TILESIZE );
	}
	
	public abstract byte getID();

	public static Tile getTile(byte id) {
		if(id <= 0 || id >= tileTypes.length) return null;
		return tileTypes[id];
	}
}
