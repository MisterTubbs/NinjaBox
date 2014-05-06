package com.jbs.ninja;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class InputProxy {
	
	public static Vector2 getTouch() {
		Vector2 actual = Main.actualScreenSize;
		int x = Gdx.input.getX();
		int y = (int) actual.y - Gdx.input.getY();
		return new Vector2(x * (Main.screenSize.x / actual.x), y * (Main.screenSize.y / actual.y));
	}

}
