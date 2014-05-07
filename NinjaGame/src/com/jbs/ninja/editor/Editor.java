package com.jbs.ninja.editor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.jbs.ninja.GameObject;
import com.jbs.ninja.InputProxy;
import com.jbs.ninja.game.level.TileMap;

public class Editor implements GameObject {
	
	class EditorMouse {
		float x, y;
		float xStart, yStart;
		int tileX, tileY;
	}

	int gridX = 32;
	int gridY = 32;
	byte activeTile = 0;
	TileMap map;
	EditorMouse mouseState = new EditorMouse();
	
	
	void OnClick( EditorMouse m ) {
	}
	void OnPress( EditorMouse m ) {
		map.placeTile(m.tileX, m.tileY, activeTile);
		System.out.println("Tile :"+activeTile+" at "+m.tileX+","+m.tileY);
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
		
		if(Gdx.input.justTouched()) {
			mouseState.xStart = mx;
			mouseState.yStart = my;
			OnClick( mouseState );
		}
		if(Gdx.input.isTouched()) {
			OnPress( mouseState );
		}
	}

	@Override
	public void render(SpriteBatch batch) {
		//map.render( batch );
	}
	
	
}
