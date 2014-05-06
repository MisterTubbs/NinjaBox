package com.jbs.ninja.game.scenes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jbs.ninja.GameObject;
import com.jbs.ninja.asset.TextureAsset;

public class Scene implements GameObject {

	private TextureAsset background, middleground, foreground;

	public Scene(TextureAsset background, TextureAsset middleground, TextureAsset foreground) {
		this.background = background;
		this.middleground = middleground;
		this.foreground = foreground;
	}

	public TextureAsset getBackground() {
		return background;
	}

	public void setBackground(TextureAsset background) {
		this.background = background;
	}

	public TextureAsset getMiddleground() {
		return middleground;
	}

	public void setMiddleground(TextureAsset middleground) {
		this.middleground = middleground;
	}

	public TextureAsset getForeground() {
		return foreground;
	}

	public void setForeground(TextureAsset foreground) {
		this.foreground = foreground;
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(SpriteBatch batch) {
	}
}
