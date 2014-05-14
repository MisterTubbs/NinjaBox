package com.jbs.ninja.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jbs.ninja.Main;
import com.jbs.ninja.Screen;
import com.jbs.ninja.editor.Editor;
import com.jbs.ninja.entity.EntityManager;
import com.jbs.ninja.entity.mob.Mob;
import com.jbs.ninja.game.Tile.Tile;
import com.jbs.ninja.game.level.TileMap;

public class Game implements Screen {
	public static boolean paused;
	
	private TileMap map;
	private EntityManager entityManager;
	private Editor editor;
	
	private Mob testMob;
	
	public Game(OrthographicCamera camera) {
		Main.camera = camera;
		this.entityManager = new EntityManager();
		
		map = new TileMap( 100, (int) Main.screenSize.y / Tile.TILESIZE );
		editor = new Editor( map );
		
		testMob = new Mob( 100,300 );
		entityManager.add( testMob );
	}
	

	@Override
	public void tick() {
		//test code
		editor.tick();
		entityManager.tick();
	}

	@Override
	public void render(SpriteBatch batch) {
		map.render(batch);
		editor.render(batch);
		entityManager.render( batch );
	}

	@Override
	public Color getClearColor() {
		return Color.CYAN;
	}

	public void reset() {
		entityManager.reset();
		Main.camera.position.set(0, 0, 0);
	}
}
