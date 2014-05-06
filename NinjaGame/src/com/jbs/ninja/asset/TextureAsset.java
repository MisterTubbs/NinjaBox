package com.jbs.ninja.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureAsset {
	
	private Texture texture;
	
	public TextureAsset(String location, int x, int y, int size) {
		TextureAsset atlas = new TextureAsset(location);
		TextureRegion texture = new TextureRegion(atlas.getTexture(), x, y, size, size);
		this.texture = texture.getTexture();
	}
	
	public TextureAsset(String locaton) {
		texture = new Texture(Gdx.files.internal(locaton));
	}
	
	public Texture getTexture() {
		return texture;
	}
}
