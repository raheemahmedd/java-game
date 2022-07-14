package com.tutorial.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
public class BasicEnemy extends GameObject{
	private BufferedImage enemy_image;
	
	public BasicEnemy(int x , int y ,ID id) {
		super(x,y,id);
		velX=5;
		velY=5;
		spritesheet ss = new spritesheet(Game.spritesheet);
		enemy_image = ss.grabImage(1, 2, 500, 500);
	}
	public void tick() {
		x+=velX;
		y+=velY;
		if(y<=0 || y>= Game.HEIGHT - 70) velY*=-1;
		if(x<=0 || x>= Game.WIDTH - 45) velX*=-1;	
 	}
	
	public void render(Graphics g) {
		//g.setColor(Color.red);
		//g.fillRect(x, y, 16, 16);
		g.drawImage(enemy_image, (int)x, (int)y, null);
	}

}
 