package com.jbs.ninja.game.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class LevelParser {

	public static TileMap parseLevel(String path) {
		TileMap map = null;
		
		FileHandle file = Gdx.files.internal(path);
		String content = file.readString();

		int width = content.charAt(1), height = content.charAt(3);

		char tileContent[] = new char[content.length() - 4];
		content.getChars(4, content.length(), tileContent, 0);
		
		byte[][] tiles = new byte[width][height];
		
		for(int i = 0; i < tileContent.length; i++) {
			
		}
		
		return map;
	}
}
