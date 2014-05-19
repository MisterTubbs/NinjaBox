package com.jbs.ninja.editor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.jbs.ninja.GameObject;
import com.jbs.ninja.InputProxy;
import com.jbs.ninja.Main;
import com.jbs.ninja.asset.Assets;
import com.jbs.ninja.asset.TextureAsset;
import com.jbs.ninja.game.Tile.Tile;
import com.jbs.ninja.game.level.TileMap;

public class Editor implements GameObject {
	
	class EditorMouse {
		int button;
		int pointer;
		float x, y;
		float xStart, yStart;
		int tileX, tileY;
		int scroll;
	}

	int gridX = 32;
	int gridY = 32;
	byte activeTile = Tile.DIRT;
	TileMap map;
	EditorMouse mouseState = new EditorMouse();
	
	public Editor( TileMap map ) {
		this.map = map;
	}
	
	void OnClick( EditorMouse m ) {
	}
	void OnPress( EditorMouse m ) {
		Vector2 mouse = InputProxy.screenToWorld( InputProxy.getTouchRaw() );
		map.placeTile((int)mouse.x / Tile.TILESIZE, (int)mouse.y / Tile.TILESIZE, activeTile);
	}
	
	public void Save() {
		
	}
	
	public void Load() {
		
	}

	@Override
	public void tick() {
		Vector2 touch = InputProxy.getTouch();
		float mx = mouseState.x = touch.x;
		float my = mouseState.y = touch.y;
		mouseState.tileX = (int) (mx/gridX);
		mouseState.tileY = (int) (my/gridY);
		mouseState.scroll = InputProxy.Scroll;
		
		activeTile -= InputProxy.Scroll;
		
		if(Gdx.input.justTouched()) {
			mouseState.xStart = mx;
			mouseState.yStart = my;
			OnClick( mouseState );
		}
		if(Gdx.input.isTouched()) {
			OnPress( mouseState );
		}
		
		float panSpeed = 10;
		if(Gdx.input.isKeyPressed( Keys.LEFT )) {
			Main.camera.translate( -panSpeed,0 );
		}
		if(Gdx.input.isKeyPressed( Keys.RIGHT )) {
			Main.camera.translate( panSpeed,0 );
		}
	}

	@Override
	public void render(SpriteBatch batch) {
		//map.render( batch );
		
		Vector2 m = InputProxy.screenToWorld( InputProxy.getTouchRaw() );
		TextureAsset tilePreview = Assets.tileset.getTile( activeTile );
		if(tilePreview!=null)
			batch.draw( tilePreview, m.x, m.y,Tile.TILESIZE, Tile.TILESIZE );
	}
	
	
}
