package com.jbs.ninja;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameObject {
	public void tick();
	public void render(SpriteBatch batch);
}
