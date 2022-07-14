package com.tutorial.main;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
public class Player extends GameObject {
	Random  r= new Random();
	private BufferedImage player_image;
	public Player(int x , int y ,ID id) {
		super(x,y,id);
		spritesheet ss = new spritesheet(Game.spritesheet);
		player_image = ss.grabImage(1, 1, 347, 300);
	   //velX=1;
		// variables of moving
		//velX=r.nextInt(5)+1;
		//velY=5;
	}
	

	public void tick() {
		
		x+=velX;
		y+=velY;
		x=Game.clamp(x,-5 , Game.WIDTH - 55);
		y=Game.clamp(y, -5, Game.HEIGHT - 70);
	}

	public void render(Graphics g) {
	/*
		g.setColor(Color.white);
		
		
		g.fillRect(x, y, 32, 32);
	*/
		g.drawImage(player_image,(int)x,(int)y,null);
	}
	
	
	
	
	
	
}
