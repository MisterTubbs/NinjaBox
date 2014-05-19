package com.jbs.ninja.entity.mob;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jbs.ninja.Debug;
import com.jbs.ninja.InputProxy;
import com.jbs.ninja.Main;
import com.jbs.ninja.asset.Assets;
import com.jbs.ninja.collision.BoxCollider;
import com.jbs.ninja.collision.Collision;

public class Player extends Mob {

	private BoxCollider touchZone;

	public Player(float x, float y) {
		super(Assets.tileGrass, x, y);
		// 128 is the width of the "touch zone"
		this.touchZone = new BoxCollider(0, 0, x + 128 - (48), Main.screenSize.y);
		this.touchZone.setPosition(x - 128, 0);
	}

	@Override
	public void tick() {
		if (Gdx.input.isTouched()) {
			// test code
			if (Collision.pointBoxTest(InputProxy.screenToWorld(InputProxy.getTouch()), touchZone)) {
				this.setPos(getPos().x + 2, getPos().y);
				//move();
			}
		}
		touchZone.setPosition(this.getPos().x - 64, 0);
	}

	@Override
	public void render(SpriteBatch batch) {
		Debug.drawRect(pos.x, pos.y, 48, 48);
		batch.draw(getTexture(), pos.x, pos.y, 24, 24, 48, 48, 1, 1, getRot(), false);
		touchZone.render(batch, touchZone.getBounds().x, touchZone.getBounds().y);
	}
	
	private void move() {
		//I'll do this soon
	}
}
