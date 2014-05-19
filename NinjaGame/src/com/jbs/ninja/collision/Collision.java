package com.jbs.ninja.collision;

import com.badlogic.gdx.math.Vector2;

public class Collision {

	/*
	 * Very simple collision - Temporary
	 */
	public static boolean boxTest(BoxCollider a, BoxCollider b) {
		return a.getBounds().overlaps(b.getBounds());
	}
	
	public static boolean pointBoxTest(Vector2 point, BoxCollider a) {
		return a.getBounds().contains(point.x, point.y);
	}
}
