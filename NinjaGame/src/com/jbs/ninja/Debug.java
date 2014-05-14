package com.jbs.ninja;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Debug {
	public static final boolean debug = true;
	private static ShapeRenderer shapeRenderer;

	public static void init() {
		shapeRenderer = new ShapeRenderer();
	}
	
	public static void log( String msg ) {
		System.out.println( msg );
	}
	
	public static void drawRect( float x, float y, float w, float h ) {
		shapeRenderer.triangle(x, y, x, y+h, x+w, y+h);
		shapeRenderer.triangle(x+w, y+h, x+w, y, x, y);
	}
	
	public static void begin() {
		shapeRenderer.setProjectionMatrix(Main.camera.combined);
		shapeRenderer.begin(ShapeType.Triangle);
	}
	public static void end() {
		shapeRenderer.end();
	}
}
