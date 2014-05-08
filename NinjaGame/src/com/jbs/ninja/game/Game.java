package com.jbs.ninja.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jbs.ninja.Main;
import com.jbs.ninja.Screen;
import com.jbs.ninja.game.Tile.Tile;
import com.jbs.ninja.game.level.TileMap;

public class Game implements Screen {

	private TileMap map;
	
	public Game() {
		Tile.init();
		byte[][] tiles = new byte[(int) Main.screenSize.x / Tile.TILESIZE][(int) Main.screenSize.y / Tile.TILESIZE];
		for(int x = 0; x < (int) Main.screenSize.x / Tile.TILESIZE; x++) { 
			for(int y = 0; y < (int) Main.screenSize.y / Tile.TILESIZE; y++) {
				if(y <= 4) tiles[x][y] = Tile.Dirt.getID();
				if(y == 5) tiles[x][y] = Tile.Grass.getID();
			} 
		}
		
		map = new TileMap(tiles, (int) Main.screenSize.x / Tile.TILESIZE, (int) Main.screenSize.y / Tile.TILESIZE);
	}
	
	@Override
	public void tick() {
		map.tick();
	}

	@Override
	public void render(SpriteBatch batch) {
		map.render(batch);
	}

	@Override
	public Color getClearColor() {
		return Color.CYAN;
	}
}
