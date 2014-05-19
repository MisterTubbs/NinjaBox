package com.jbs.ninja.asset;

import com.jbs.ninja.Tickable;

public class Animation implements Tickable {
	
	private AnimationSet set;
	private int currentIndex, delayTime, currentTime;
	
	public Animation(int delayTime, AnimationSet set) {
		this.set = set;
	}

	@Override
	public void tick() {
		if(currentTime % delayTime == 0) {
			currentIndex++;
			currentTime = 0;
		}
		if(currentIndex >= set.getTextures().length - 1) currentIndex = 0;
		currentTime++;
	}
	
	public TextureAsset getTexture(int index) {
		return set.getTexture(index);
	}
	
 	public TextureAsset getCurrentTexture() {
		return set.getTexture(currentIndex);
	}
	
	public void setDelayTime(int delayTime) {
		this.delayTime = delayTime;
	}
}
