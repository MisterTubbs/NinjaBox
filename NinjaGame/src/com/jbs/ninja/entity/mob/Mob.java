package com.jbs.ninja.entity.mob;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jbs.ninja.Debug;
import com.jbs.ninja.Renderable;
import com.jbs.ninja.Tickable;
import com.jbs.ninja.collision.BoxCollider;
import com.jbs.ninja.entity.Entity;

public class Mob extends Entity implements Renderable,Tickable {

	BoxCollider collider;
	
	public Mob( float x, float y ) {
		super(x,y);
		collider = new BoxCollider( 0,0, 32,32 );
		collider.setPosition( this.getPos() );
	}
	/*
	 * Why multiple constructors???
	 */

	@Override
	public void tick() {
		System.out.println("mob tick");
	}
	
	@Override
	public void render( SpriteBatch batch ) {
		Debug.drawRect( pos.x, pos.y, 32, 32 );
	}
}
