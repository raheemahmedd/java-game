package com.tutorial.main;

import java.awt.image.BufferedImage;

public class spritesheet {
	private BufferedImage sprite;
	public spritesheet(BufferedImage ss) {
		this.sprite = ss;
	}

	public BufferedImage grabImage(int col,int row,int width,int height) {
		BufferedImage img = sprite.getSubimage((col*32)-32, (row*32)-32, width, height-100);
		return img;
	}
}
