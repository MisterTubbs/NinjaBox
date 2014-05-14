package com.jbs.ninja.entity;

import com.badlogic.gdx.math.Vector2;

public class Entity {
	
	/* Remember, an entity is a container not a super object. Don't make it do everything */
	
	protected Vector2 pos, size, scale;
	protected float rot;
	private boolean isAlive;
	
	//Ace: always have a blank constructor in super types >.<
	public Entity() {
		this.pos = new Vector2( 0,0 );
	}
	public Entity( float x, float y ) {
		this.pos = new Vector2(x,y);
	}
	//these constructors were nothing but convenience and hard code-y - messy

	//methods meant to be abstracted
	public void create() { }
	public void destroy() { }

	
	
	/*
	 * while it's good to use getters and setters, if it has no legit
	 * reason within a inherited class don't
	 */
	public Vector2 getPos() {
		return pos;
	}
	
	public Vector2 getSize() {
		return size;
	}
	
	public Vector2 getScale() {
		return scale;
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	
	public void setPos(float x, float y) {
		pos.set(x, y);
	}
	
	public void setSize(float x, float y) {
		size.set(x, y);
	}
	
	public void setScale(float x, float y) {
		scale.set(x, y);
	}
	
	public void kill() {
		isAlive = false;
	}

}
