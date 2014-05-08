package com.jbs.ninja.asset;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureAsset extends TextureRegion {
	public String texturePath;
	public String textureID;
	public boolean loaded = false;
	boolean regionDefined = false;
	
	/**Updates any changes to the texture reference for this instance.
	 * Useful if you want to do a skin swap for instance by calling {@link Assets#setAlias()}
	 * @return Convenience for when you want to update a texture while passing it to a method
	 */
	public TextureAsset update() {
		this.texturePath = Assets.getAlias( textureID );
		this.setTexture( Assets.loadTexture( texturePath ) );
		if(!regionDefined) this.setRegion( getTexture() );
		return this;
	}
	
	@Override
	public void setRegion( int x, int y, int w, int h ) {
		regionDefined = true;
		super.setRegion(x, y, w, h);
	}
	
	//wrapper methods
	public float getWidth() { 
		return getTexture().getWidth();
	}
	public float getHeight() {
		return getTexture().getHeight();
	}
}
