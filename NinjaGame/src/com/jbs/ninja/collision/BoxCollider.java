package com.jbs.ninja.collision;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.jbs.ninja.Debug;

public class BoxCollider {
	float x, y;
	float sizeX, sizeY;
	Vector2 position = new Vector2();

	public BoxCollider(float originX, float originY, float width, float height) {
		this.x = originX;
		this.y = originY;
		this.sizeX = width;
		this.sizeY = height;
	}

	public void setPosition(float x, float y) {
		position.set(x, y);
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Rectangle getBounds() {
		return new Rectangle(position.x - this.x, position.y - this.y, sizeX, sizeY);
	}

	public void render(SpriteBatch batch, float x, float y) {
		Debug.drawRect(x - this.x, y - this.y, sizeX, sizeY);
	}
}
