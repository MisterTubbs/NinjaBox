package com.jbs.ninja.game.Tile;

import com.jbs.ninja.asset.Assets;

public class TileDirt extends Tile {

	public TileDirt() {
		super(Assets.tileDirt);
	}

	@Override
	public byte getID() {
		return 2;
	}
}
