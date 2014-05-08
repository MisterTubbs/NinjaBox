package com.jbs.ninja.asset;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureRegionAsset {
	
	private TextureRegion texture;
	
	public TextureRegionAsset(TextureRegion texture) {
		this.texture = texture;
	}
	
	public TextureRegion getTexture() {
		return texture;
	}
}
