package com.tutorial.main;

import java.awt.Graphics;
import java.awt.Rectangle;

// enemies and players
public abstract class GameObject {

	protected float x,y;
	protected ID id;
	protected float velX,velY;
	public GameObject(float x , float y ,ID id) {
		this.x=x;
		this.y=y;
		this.id=id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
	
  public void setX(int x) {
	  this.x=x;
  }
  public void setY(int y) {
	  this.y=y;
  }
  public float getX() {
	  return x;
  }
  public float getY() {
	  return y;
  }
  public void setID(ID id) {
	  this.id=id;
  }
  public ID getID() {
	  return id;
  }
  public void setVelX(int velx) {
	  this.velX=velx;
  }
  public void setVelY(int vely) {
	  this.velY=vely;
  }
  public float getVelX() {
	  return velX;
  }
  public float getVelY() {
	  return velY;
  }
  
	
	
}
