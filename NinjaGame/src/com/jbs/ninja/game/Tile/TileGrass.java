package com.jbs.ninja.game.Tile;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jbs.ninja.Debug;
import com.jbs.ninja.asset.Assets;
import com.jbs.ninja.collision.BoxCollider;

public class TileGrass extends Tile {

	BoxCollider collider;
	public BoxCollider getCollider( float x, float y ) { 
		collider.setPosition(x,y); 
		return collider;
	}
	
	public TileGrass() {
		super(Assets.tileGrass); 
		collider = new BoxCollider(0,0, TILESIZE,TILESIZE);
	}

	@Override
	public byte getID() {
		return 1;
	}
	
	@Override
	public void render(SpriteBatch batch, float x, float y) {
		super.render(batch, x, y);
		Debug.drawRect(x, y, TILESIZE, TILESIZE);
		
	}
}
