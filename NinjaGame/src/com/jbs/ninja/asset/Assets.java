package com.jbs.ninja.asset;



public class Assets extends ResourceHash {
	public static TextureAsset playButton;
	public static TextureAsset tileGrass, tileDirt;
	
	public static void update() {
		if(!manager.update()) {
		}
	}
	
	public static void load() {		
		ForceLoad = true;
		newTexture( "gui/play.png", 		"playButton" );
		newTexture( "sprites/tiles.png", 	"tileset" );
		ForceLoad = false;
		
		
		playButton = newTexture("@playButton");
		(tileGrass = newTexture( "@tileset", 	"sprite2" )).setRegion(0,0,16,16);
		(tileDirt = newTexture( "@tileset", 	"sprite1" )).setRegion(16,0,16,16);
	}
	
	public static void loadAll() {
		manager.finishLoading();
	}
	
	
}
