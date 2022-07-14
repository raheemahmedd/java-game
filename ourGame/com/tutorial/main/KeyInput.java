package com.tutorial.main;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

import com.tutorial.main.Game.STATE;

public class KeyInput extends KeyAdapter {
	
		private Handler handler;
		 Game game;
		public KeyInput(Handler handler, Game game) {
			this.handler=handler;
			this.game = game;
		}
		
		@Override
	public void keyPressed(KeyEvent e) {
		// show the ascii of pressed key  
		int Key = e.getKeyCode();
				
		
		System.out.println("key pressed code" +Key);
		
		//loop on available objects in liked list
		for(int i=0; i<handler.object.size();i++) {
			//built in function for liked list to know which object we are working on
			GameObject tempObject = handler.object.get(i);
		     
			   if(tempObject.getID()==ID.Player) {
				   // key event for player 1
				   
				   if(Key==KeyEvent.VK_W) tempObject.setVelY(-5); 
				   if(Key==KeyEvent.VK_S) tempObject.setVelY(5); 
				   if(Key==KeyEvent.VK_D) tempObject.setVelX(5); 
				   if(Key==KeyEvent.VK_A) tempObject.setVelX(-5); 
			   
			   
			   
			   }
			  
		}
		if(Key == KeyEvent.VK_P) {
			if(game.gameState == STATE.Game) {
			if(Game.paused) {Game.paused = false;}
			else Game.paused = true;
		}
			}
		if(Key==KeyEvent.VK_ESCAPE)
		System.exit(1);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// show the ascii of pressed key  
		int Key = e.getKeyCode();
		System.out.println("key released code" +Key);
		for(int i=0; i<handler.object.size();i++) {
			//built in function for liked list to know which object we are working on
			GameObject tempObject = handler.object.get(i);
		     
			   if(tempObject.getID()==ID.Player) {
				   // key event for player 1
				   
				   if(Key==KeyEvent.VK_W) tempObject.setVelY(0); 
				   if(Key==KeyEvent.VK_S) tempObject.setVelY(0); 
				   if(Key==KeyEvent.VK_D) tempObject.setVelX(0); 
				   if(Key==KeyEvent.VK_A) tempObject.setVelX(0); 
			   
			   
			   
			   }
			  
		}
		
	}
	
	

}
