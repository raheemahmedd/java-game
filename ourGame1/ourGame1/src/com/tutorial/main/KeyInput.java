package com.tutorial.main;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

import com.tutorial.main.Game.STATE;

public class KeyInput extends KeyAdapter {
	
		private Handler handler;
		private boolean [] keyDown = new boolean[4];
		Game game ;
		public KeyInput(Handler handler,Game game) {
			this.game = game;
			this.handler=handler;
			keyDown[0] = false;
			keyDown[1] = false;
			keyDown[2] = false;
			keyDown[3] = false;
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
				   
				   if(Key==KeyEvent.VK_W) { tempObject.setVelY(-5); keyDown[0] = true; }
				   if(Key==KeyEvent.VK_S) { tempObject.setVelY(5); keyDown[1] = true; }
				   if(Key==KeyEvent.VK_D) { tempObject.setVelX(5); keyDown[2] = true; }
				   if(Key==KeyEvent.VK_A) { tempObject.setVelX(-5); keyDown[3] = true; }
			   
			   
			   
			   }
			  
		}
		if (Key == KeyEvent.VK_P) {
			if(game.gameState == STATE.Game){
			if(Game.paused) Game.paused = false;
			else Game.paused = true;
		}}
		if(Key==KeyEvent.VK_ESCAPE) System.exit(1);
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
				   
				   if(Key==KeyEvent.VK_W) keyDown[0] = false;// tempObject.setVelY(0);
				   if(Key==KeyEvent.VK_S) keyDown[1] = false;//tempObject.setVelY(0);
				   if(Key==KeyEvent.VK_D) keyDown[2] = false;//tempObject.setVelX(0);
				   if(Key==KeyEvent.VK_A) keyDown[3] = false;//tempObject.setVelX(0);
			         // vertical movement
			       if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				     //horizontal movement
				   if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
			   
			   }
			  
		}
		
	}
	
	
	

}
