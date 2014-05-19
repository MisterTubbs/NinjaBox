package com.jbs.ninja.asset;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureAsset extends TextureRegion {
	public String texturePath;
	public String textureID;
	public boolean loaded = false;
	boolean regionDefined = false;
	TextureAsset[][] tiles = null;

	/**
	 * Updates any changes to the texture reference for this instance. Useful if
	 * you want to do a skin swap for instance by calling
	 * {@link Assets#setAlias()}
	 * 
	 * @return Convenience for when you want to update a texture while passing
	 *         it to a method
	 */
	public TextureAsset update() {
		this.texturePath = Assets.getAlias(textureID);
		this.setTexture(Assets.loadTexture(texturePath));
		if (!regionDefined)
			this.setRegion(getTexture());
		return this;
	}

	@Override
	public void setRegion(int x, int y, int w, int h) {
		regionDefined = true;
		super.setRegion(x, y, w, h);
	}

	/**
	 * replaces texture region. split(w,h)
	 * 
	 * @param x
	 *            number of columns
	 * @param y
	 *            number of rows
	 * @return
	 */
	public TextureAsset cut(int x, int y) {
		int w = getRegionWidth() / x;
		int h = getRegionHeight() / y;
		tiles = new TextureAsset[x][y];
		for (int i = 0; i < x * y; i++) {
			TextureAsset tile = Assets.newTexture(texturePath);
			tile.setRegion(this.getRegionX() + i % x * w, this.getRegionY() + i / x * h, w, h);
			tile.update();
			tiles[i % x][i / x] = tile;
		}
		return this; // for chaining
	}

	public TextureAsset getTile(int x, int y) {
		if (tiles == null || x < 0 || y < 0 || x >= tiles.length || y >= tiles[0].length)
			return null;
		return tiles[x][y];
	}

	public TextureAsset getTile(int id) {
		if (id < 0 || id >= tiles.length * tiles[0].length)
			return null;
		return getTile(id % tiles.length, id / tiles.length);
	}

	// wrapper methods
	public float getWidth() {
		return getTexture().getWidth();
	}

	public float getHeight() {
		return getTexture().getHeight();
	}
}
