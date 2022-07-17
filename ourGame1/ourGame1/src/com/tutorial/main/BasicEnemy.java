package com.tutorial.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject{
	 Handler handler;
	public BasicEnemy(int x , int y ,ID id, Handler handler) {
		super(x,y,id);
		this.handler = handler;
		velX=5;
		velY=5;
	}
	public void tick() {
		x+=velX;
		y+=velY;
		handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
		if(y<=0 || y>= Game.HEIGHT - 70) velY*=-1;
		if(x<=0 || x>= Game.WIDTH - 45) velX*=-1;	
 	}
	public Rectangle getBounds(){
		return new Rectangle((int)x,(int) y, 16, 16);
	}

	public void render(Graphics g){
//            Graphics2D g2d = (Graphics2D) g;
//            g.setColor(Color.red);
//            g2d.draw(getBounds());
		g.setColor(Color.red);
		g.fillRect((int)x,(int) y, 16, 16);
	}

}
