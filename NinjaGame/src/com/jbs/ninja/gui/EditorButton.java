package com.jbs.ninja.gui;

import com.jbs.ninja.Main;
import com.jbs.ninja.asset.Assets;

public class EditorButton extends Button {

	public EditorButton() {
		super(Assets.editorButton, Main.centered.x - (Assets.playButton.getTexture().getWidth() / 2), Main.centered.y - Assets.editorButton.getHeight() - (Assets.editorButton.getHeight() / 4), Assets.playButton.getTexture().getWidth(), Assets.playButton.getTexture().getHeight());
	}

	@Override
	public void onClick() {
	}
}
