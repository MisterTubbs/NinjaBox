package com.jbs.ninja.game.level;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jbs.ninja.Renderable;
import com.jbs.ninja.game.Tile.Tile;

public class TileMap implements Renderable {

	private byte[][] tiles;
	int minX = 0, minY = 0, maxX = 10, maxY = 10;

	public TileMap(int width, int height) {
		maxX = width;
		maxY = height;

		tiles = new byte[width][height];
		for (int x = minX; x < maxX; x++) {
			for (int y = minY; y < maxY; y++) {
				placeTile(x, y, (byte) 0);
				if (y <= 2)
					tiles[x][y] = Tile.DIRT;
				if (y == 3)
					tiles[x][y] = Tile.GRASS;
			}
		}
	}

	@Override
	public void render(SpriteBatch batch) {
		for (int x = minX; x < maxX; x++) {
			for (int y = minY; y < maxY; y++) {
				Tile tile = Tile.getTile(tiles[x][y]);
				if (tile != null)
					tile.render(batch, x * Tile.TILESIZE, y * Tile.TILESIZE);
			}
		}
	}

	public boolean placeTile(int x, int y, byte id) {
		if (x < minX || y < minY || x >= maxX || y >= maxY)
			return false;
		else
			tiles[x][y] = id;
		return true;
	}

	public int getTileID(int x, int y) {
		if (x < minX || y < minY || x > maxX || y > maxY)
			return -1;
		return tiles[x][y];
	}

	public int getWidth() {
		return maxX - minX;
	}

	public int getHeight() {
		return maxY - minY;
	}
}
