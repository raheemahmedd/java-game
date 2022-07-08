package com.tutorial.main;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
		private Handler handler;
	
		public KeyInput(Handler handler) {
			this.handler=handler;
			
		}
		
		
	public void KeyPressed(KeyEvent e) {
		// show the ascii of pressed key  
		int Key = e.getKeyCode();
				
		
		System.out.println(Key);
		
		//loop on available objects in liked list
		for(int i=0; i<handler.object.size();i++) {
			//built in function for liked list to know which object we are working on
			GameObject tempObject = handler.object.get(i);
		     
			   if(tempObject.getID()==ID.Player) {
				   // key event for player 1
				   
				   if(Key==KeyEvent.VK_W) tempObject.setVelY(-5); 
				   if(Key==KeyEvent.VK_S) tempObject.setVelY(5); 
				   if(Key==KeyEvent.VK_D) tempObject.setVelY(5); 
				   if(Key==KeyEvent.VK_A) tempObject.setVelY(-5); 
			   
			   
			   
			   }
			  
		}
		if(Key==KeyEvent.VK_ESCAPE)
		System.exit(1);
	}
	public void KeyReleased(KeyEvent e) {
		// show the ascii of pressed key  
		int Key = e.getKeyCode();
		for(int i=0; i<handler.object.size();i++) {
			//built in function for liked list to know which object we are working on
			GameObject tempObject = handler.object.get(i);
		     
			   if(tempObject.getID()==ID.Player) {
				   // key event for player 1
				   
				   if(Key==KeyEvent.VK_W) tempObject.setVelY(0); 
				   if(Key==KeyEvent.VK_S) tempObject.setVelY(0); 
				   if(Key==KeyEvent.VK_D) tempObject.setVelY(0); 
				   if(Key==KeyEvent.VK_A) tempObject.setVelY(0); 
			   
			   
			   
			   }
			  
		}
		
	}
	
	
	

}
