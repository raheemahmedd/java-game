package com.tutorial.main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;
// our main class where we drag screens
public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 155;
	public static final int WIDTH = 640 , HEIGHT = WIDTH/ 12*9;
	private Thread thread;
	private boolean running =false;
	private Handler handler;
	private Random r;
	private HUD hud;
	private Menu menu;
	public enum STATE{
		Menu,
		Help,
		Game
	};
	public STATE gameState= STATE.Menu;

	public Game() {
	   handler= new Handler();
		menu =new Menu(this,handler);
	   this.addKeyListener(new KeyInput(handler));
	   this.addMouseListener(menu);

	   new Window(WIDTH,HEIGHT,"let's Build a Game!",this);
	   r= new Random();
		//intialze new menu
		menu =new Menu(this,handler);
	   //we can use it here also (handler)
		if(gameState==STATE.Game){
			handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32,ID.Player));
			handler.addObject(new BasicEnemy(r.nextInt(WIDTH),r.nextInt(HEIGHT) ,ID.BasicEnemy));
		}
	 hud = new HUD();
	//	handler.addObject(new Player(r.nextInt(WIDTH), r.nextInt(HEIGHT),ID.Player));
	   // player at middle of screen
	  // handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32,ID.Player));
		// basicEnemy in random places 
	   handler.addObject(new BasicEnemy(r.nextInt(WIDTH),r.nextInt(HEIGHT) ,ID.BasicEnemy));
	
	}
	public synchronized void start() {
		
		thread = new Thread(this);
		thread.start();
		running=true;
	}
	public synchronized void stop() {
		
		try {
			thread.join();
			running=false;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void run() {
		// game loop
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTickets = 60.0;
		double ns = 1000000000/amountOfTickets;
		double delta =0;
		long timer = System.currentTimeMillis();
		int frames=0;
		while(running) {
			long now = System.nanoTime();
			delta+=(now - lastTime)/ns;
			lastTime = now;
			while(delta>=1) {
				tick();
				delta--;
				
			}
			if(running) 
				render();
				frames++;
			if(System.currentTimeMillis()- timer >1000) {
				timer+=1000;
				//System.out.println("FPS "+ frames);
				frames=0;
			}
		}
		stop();
		
	}
	private void tick() {
		//update objects
		handler.tick();
		//update health
		//hud.tick();
		//using the enum we just made STATE
		if(gameState==STATE.Game){
          hud.tick();
		}
		else if (gameState==STATE.Menu || gameState==STATE.Help){
			menu.tick();
		}
	}
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
	     if(bs == null) {
	    	 this.createBufferStrategy(3);
	    	 return;
	     }
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0,0,WIDTH,HEIGHT);
		
		handler.render(g);
		//here we can also use the same way as in tick one
		if(gameState==STATE.Game){
			hud.render(g);
		}
			else if (gameState==STATE.Menu){
				menu.render(g);
			}

		g.dispose();
		bs.show();
		}
	// prevent the character to escape out of screen  (x/y , min edge of screen , max edge of screen)
	public static int clamp(int var , int min , int max) {
			
				if(var>=max)
					return var=max;
				else if(var<=min)
					return var=min;
				else
					return var;
		
	}
	
	public static void main(String[] args) {
		new Game();
		
	}

}