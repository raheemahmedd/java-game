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
			
			//built in function for liked list to get content of object we are working on
					
					// assign node to tempObject
			GameObject tempObject = object.get(i);
	
			// if we comment next line there will be no movement 
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
	public void clearEnemys(){
		for(int i=0 ; i<object.size();i++) {
			//built in function for liked list to know which object we are working on
			GameObject tempObject = object.get(i);

			if(tempObject.getID() == ID.Player){
				object.clear();
				if (Game.gameState != Game.STATE.End)
				addObject(new Player((int)tempObject.getX(), (int)tempObject.getY(), ID.Player, this));
			}

		}

	}
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
}
