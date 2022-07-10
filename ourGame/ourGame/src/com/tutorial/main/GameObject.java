package com.tutorial.main;

import java.awt.Graphics;

// enemies and players
public abstract class GameObject {

	protected int x,y;
	protected ID id;
	protected int velX,velY;
	public GameObject(int x , int y ,ID id) {
		this.x=x;
		this.y=y;
		this.id=id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
  public void setX(int x) {
	  this.x=x;
  }
  public void setY(int x) {
	  this.y=y;
  }
  public int getX(int x) {
	  return x;
  }
  public int getY(int x) {
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
  public int getVelX() {
	  return velX;
  }
  public int getVelY() {
	  return velY;
  }
  
	
	
}
