package com.jbs.ninja.asset;

public class AnimationSet {
	
	private TextureAsset[] textures;
	
	public AnimationSet(TextureAsset... textures) {
		this.textures = textures;
	}

	public TextureAsset[] getTextures() {
		return textures;
	}
	
	public TextureAsset getTexture(int index) {
		return textures[index];
	}
	
	public void setTexture(int index, TextureAsset texture) {
		textures[index] = texture;
	}
}
