package com.jbs.ninja.asset;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Assets extends ResourceHash {

	public static TextureAsset playButton, editorButton;
	public static TextureAsset tileset, tileGrass, tileDirt;
	public static BitmapFont menuFont;

	public static void update() {
		if (!manager.update()) {
		}
	}

	public static void load() {
		ForceLoad = true;
		newTexture("gui/play.png", "playButton");
		newTexture("gui/editor.png", "editorButton");
		tileset = newTexture("sprites/tiles.png", "tileset").cut(6, 6);
		ForceLoad = false;

		playButton = newTexture("@playButton");
		editorButton = newTexture("@editorButton");
		// get tile textures
		tileGrass = tileset.getTile(1, 0);
		tileDirt = tileset.getTile(2, 0);

		menuFont = new BitmapFont();
	}

	public static void loadAll() {
		manager.finishLoading();
	}
}
