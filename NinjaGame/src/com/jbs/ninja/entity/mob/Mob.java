package com.jbs.ninja.entity.mob;

import com.jbs.ninja.asset.Animation;
import com.jbs.ninja.entity.Entity;

public class Mob extends Entity {

	public Mob(Animation anim, float x, float y) {
		super(anim, x, y);
	}
	
	public Mob(Animation anim, int firstTexIndex, float x, float y) {
		super(anim, firstTexIndex, x, y);
	}

	@Override
	public void tick() {
	}
}
