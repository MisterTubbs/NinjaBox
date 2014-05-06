package com.jbs.ninja.game.level;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jbs.ninja.GameObject;

public class TileMap implements GameObject {

	private byte[][] tiles;
	
	@Override
	public void render(SpriteBatch batch) {
	}

	@Override
	public void tick() {
	}

	public void placeTile(int x, int y, byte id) {
		//add in check to make sure tile is within map bounds
		tiles[x][y] = id;
	}
}
