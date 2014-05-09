package com.jbs.ninja.entity.mob;

import com.jbs.ninja.asset.TextureAsset;
import com.jbs.ninja.entity.Entity;

public class Mob extends Entity {

	public Mob(TextureAsset texture, float x, float y) {
		super(texture, x, y);
	}

	@Override
	public void tick() {
	}
}
