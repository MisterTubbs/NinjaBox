package com.jbs.ninja.entity;

import com.badlogic.gdx.math.Vector2;

public class Entity {

	protected Vector2 pos, size, scale;
	protected float rot;
	private boolean isAlive;

	public Entity() {
		this.pos = new Vector2(0, 0);
	}

	public Entity(float x, float y) {
		this.pos = new Vector2(x, y);
	}

	public void create() {
	}

	public void destroy() {
	}

	public Vector2 getPos() {
		return pos;
	}

	public Vector2 getSize() {
		return size;
	}

	public Vector2 getScale() {
		return scale;
	}

	public float getRot() {
		return rot;
	}

	public void setRot(float rot) {
		this.rot = rot;
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
