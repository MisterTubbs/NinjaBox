package com.jbs.ninja.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.jbs.ninja.Main;
import com.jbs.ninja.Screen;
import com.jbs.ninja.entity.EntityManager;
import com.jbs.ninja.game.Tile.Tile;
import com.jbs.ninja.game.level.TileMap;

public class Game implements Screen {

	public static boolean paused;

	private TileMap map;
	private OrthographicCamera camera;
	private Vector2 offset;
	private EntityManager entityManager;
	
	public Game(OrthographicCamera camera) {
		this.camera = camera;
		this.offset = new Vector2();
		this.entityManager = new EntityManager();
		
		Tile.init();
		//test code
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
		//test code
		camera.translate(1, 0);
		offset.x += 1;
		
		entityManager.tick(map.getWidth(), map.getHeight());
		map.tick(offset);
	}

	@Override
	public void render(SpriteBatch batch) {
		map.render(batch);
	}

	@Override
	public Color getClearColor() {
		return Color.CYAN;
	}

	public void reset() {
		entityManager.reset();
		offset.set(0, 0);
		camera.position.set(0, 0, 0);
	}
}
