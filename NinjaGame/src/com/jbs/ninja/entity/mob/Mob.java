package com.jbs.ninja.entity.mob;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jbs.ninja.Debug;
import com.jbs.ninja.Renderable;
import com.jbs.ninja.Tickable;
import com.jbs.ninja.asset.TextureAsset;
import com.jbs.ninja.collision.BoxCollider;
import com.jbs.ninja.entity.Entity;

public class Mob extends Entity implements Renderable, Tickable {

	private BoxCollider collider;
	private TextureAsset texture;
	
	public Mob(TextureAsset texture, float x, float y) {
		super(x, y);
		this.texture = texture;
		this.setRot(270);
		collider = new BoxCollider(0, 0, 48, 48);
		collider.setPosition(this.getPos());
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(SpriteBatch batch) {
		Debug.drawRect(pos.x, pos.y, 48, 48);
		batch.draw(texture, pos.x, pos.y, 24, 24, 48, 48, 1, 1, getRot(), false);
	}

	public TextureAsset getTexture() {
		return texture;
	}

	public void setTexture(TextureAsset texture) {
		this.texture = texture;
	}
}
