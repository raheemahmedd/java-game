package com.tutorial.main;

import java.awt.Graphics;
import java.util.LinkedList;

// maintain and update objects
public class Handler {
  
	// cause we don't know how many objects we will have so we should use dynamic DS
	LinkedList<GameObject> object = new LinkedList<GameObject>();

	
	public void tick() {
		//loop on objects
		for(int i=0 ; i<object.size();i++) {
			//built in function for liked list to know which object we are working on
			GameObject tempObject = object.get(i);
		   
			tempObject.tick();
		
		}
		
	}
	public void render(Graphics g) {
		//loop on objects
		for(int i=0 ; i<object.size();i++) {
			//built in function for liked list to know which object we are working on
			GameObject tempObject = object.get(i);
		   
			tempObject.render(g);
		
		}
		
	}
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
}
