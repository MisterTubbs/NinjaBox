package com.jbs.ninja.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.jbs.ninja.Animated;
import com.jbs.ninja.Renderable;
import com.jbs.ninja.asset.Animation;
import com.jbs.ninja.asset.TextureAsset;

public class Entity implements Renderable, Animated {
	
	private TextureAsset texture;
	private Animation anim;
	private Vector2 pos, size, scale;
	private float rot;
	private boolean isAlive, isAnimated;
	
	public Entity(TextureAsset texture, float x, float y) {
		this(texture, new Vector2(x, y));
	}
	
	public Entity(Animation anim, float x, float y) {
		this(anim.getTexture(0), x, y);
		this.anim = anim;
		this.isAnimated = true;
	}

	public Entity(Animation anim, int firstTexIndex, float x, float y) {
		this(anim.getTexture(firstTexIndex), x, y);
		this.anim = anim;
		this.isAnimated = true;
	}
	
	public Entity(TextureAsset texture, Vector2 pos) {
		this.texture = texture;
		this.pos = pos;
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.draw(texture.getTexture(), pos.x, pos.y, 0f, 0f, size.x, size.y, scale.x, scale.y, rot, 0, 0, 1, 1, false, false);
	}

	public void tick() {
		if(isAnimated) animate();
	}
	
	@Override
	public void animate() {
		anim.tick();
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
	
	public void setTexture(TextureAsset texture) {
		this.texture = texture;
	}

}
