package com.jbs.ninja.asset;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets extends ResourceHash {

	public static TextureAsset playButton;
	public static TextureRegionAsset tileGrass, tileDirt;

	public static void update() {
		if (!manager.update()) {
		}
	}

	public static void load() {
		ForceLoad = true;
		newTexture("gui/play.png", "playButton");
		newTexture("sprites/tiles.png", "tileset");
		ForceLoad = false;

		playButton = newTexture("@playButton");
		// get tile textures
		TextureRegion[][] tiles = TextureRegion.split(ResourceHash.loadTexture("sprites/tiles.png"), 16, 16);
		tileDirt = new TextureRegionAsset(tiles[0][0]);
		tileGrass = new TextureRegionAsset(tiles[0][1]);
	}

	public static void loadAll() {
		manager.finishLoading();
	}
}
