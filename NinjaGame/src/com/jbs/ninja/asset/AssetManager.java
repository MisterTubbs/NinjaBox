package com.jbs.ninja.asset;

public class AssetManager {
	
	public static TextureAsset playButton;
	public static TextureAsset tileGrass, tileDirt;
	
	public static void load() {
		playButton = new TextureAsset("gui/play.png");
		tileDirt = new TextureAsset("sprites/tiles.png", 0, 0, 16);
		tileGrass = new TextureAsset("sprites/tiles.png", 16, 0, 16);
	}
}
