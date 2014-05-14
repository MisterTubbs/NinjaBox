package com.jbs.ninja.collision;


public class Collision {
	
	/* Very simple collision - Temporary
	 */
	public static boolean boxTest( BoxCollider a, BoxCollider b ) {
		return a.getBounds().overlaps(b.getBounds());
	}
	
}
