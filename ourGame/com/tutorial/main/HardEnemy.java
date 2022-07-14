package com.tutorial.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
public class HardEnemy extends GameObject{
	private Handler handler; 
	private BufferedImage enemy_image;
	private Random r = new Random();
	public HardEnemy(int x , int y ,ID id,Handler handler) {
		super(x,y,id);
		velX=5;
		velY=5;
		spritesheet ss = new spritesheet(Game.spritesheet);
		enemy_image = ss.grabImage(1, 3, 164, 162);
	}
	public void tick() {
		x+=velX;
		y+=velY;
		if(y<=0 || y>= Game.HEIGHT - 70) {
			if(velY<0) 
		     	velY = -(r.nextInt(7)+1)*-1;
			else 
				velY = (r.nextInt(7)+1)*-1;}
		if(x<=0 || x>= Game.WIDTH - 45) {
		if(velX<0) 
	     	velX = -(r.nextInt(7)+1)*-1;
		else 
			velX = (r.nextInt(7)+1)*-1;}	
		
 	}
	
	public void render(Graphics g) {
	//	g.setColor(Color.yellow);
//		g.fillRect(x, y, 16, 16);
		g.drawImage(enemy_image, (int)x, (int)y, null);

	}

}
