package com.tutorial.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public  class Player extends GameObject {
	Random  r= new Random();
	Handler handler ;
	public Player(int x, int y, ID id, Handler handler){
		super(x, y, id);
		this.handler = handler;
	}

	public Rectangle getBounds(){
		return new Rectangle((int)x,(int) y, 32, 32);
	}


	public void tick() {
		
		x+=velX;
		y+=velY;
		collision();
		x=Game.clamp(x,-5 , Game.WIDTH - 55);
		y=Game.clamp(y, -5, Game.HEIGHT - 70);
	}
	private void collision(){
		for(int i=0; i<handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);//tempObject is not BasicEnemy
			if(tempObject.getID()==ID.BasicEnemy || tempObject.getID()==ID.FastEnemy || tempObject.getID()==ID.SmartEnemy){
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 2;
				}
			}
		}
	}
	public void render(Graphics g){
//            Graphics2D g2d = (Graphics2D) g;
//            g.setColor(Color.red);
//            g2d.draw(getBounds());
		g.setColor(Color.white);
		g.fillRect((int)x,(int) y, 32, 32);
	}
	
	
	
	
	
	
}
