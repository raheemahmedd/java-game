package com.tutorial.main;

import com.tutorial.main.Game.STATE;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {
    private Game game;
    private Handler handler;
    private HUD hud;
   // public int x = 0;
    private Random r =new Random();
    public Menu (Game game,Handler handler,HUD hud){
        this.game =game;
        this.handler=handler;
        this.hud = hud;
    }
    public void mousePressed(MouseEvent e){
        int mx =e.getX();
        int my=e.getY();

        if(game.gameState == STATE.Menu) {
        //here you go (play button)
        if (mouseOver(mx,my,210,150,200,64)){
             //  game.gameState=STATE.Game;
            //handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32,ID.Player, handler));
        	//handler.clearEnemys();
            //handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT) ,ID.BasicEnemy, handler));
            game.gameState = STATE.Select;
        	AudioPlayer.getSound("menu_sound").play();
        	return;
        }
        // help button
        if (mouseOver(mx,my,210,250,200,64)){
            game.gameState =STATE.Help;
            AudioPlayer.getSound("menu_sound").play();
        }

        //Quit button
        if (mouseOver(mx,my,210,350,200,64)){
           System.exit(1);
        }
        }
        if(game.gameState == STATE.Select) {
            //here you go (play button)
            System.out.println("1");
            if (mouseOver(mx,my,210,150,200,64)){
                game.gameState=STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32,ID.Player, handler));
            	handler.clearEnemys();
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT) ,ID.BasicEnemy, handler));
                game.diff = 0;
            	AudioPlayer.getSound("menu_sound").play();
            }
            // help button
            if (mouseOver(mx,my,210,250,200,64)){
            	  game.gameState=STATE.Game;
                  handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32,ID.Player, handler));
              	handler.clearEnemys();
                  handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT) ,ID.BasicEnemy, handler));
                  game.diff = 1;
                AudioPlayer.getSound("menu_sound").play();
            }

            //Quit button
            if (mouseOver(mx,my,210,350,200,64)){
                game.gameState =STATE.Menu;
                AudioPlayer.getSound("menu_sound").play();
                return;
            }
            }
        //back button for help
        if (game.gameState==STATE.Help) {
            if (mouseOver(mx,my,210,350,200,64)){
                game.gameState =STATE.Menu;
                AudioPlayer.getSound("menu_sound").play();
                return;
            }
        }
        if (game.gameState==STATE.End) {
            if (mouseOver(mx,my,210,350,200,64)){
                hud.score(0);
                hud.setLevel(1);
                game.gameState =STATE.Menu;

                AudioPlayer.getSound("menu_sound").play();
                }
        }

    }
    public void mouseReleased(MouseEvent e){

    }
    //a method to check if a mouse is over a selected button or not (traget)
    private boolean mouseOver(int mx,int my, int x,int y,int width,int height) {
        if (mx > x && mx< x+height) {
                if(my > y && my < y+ height){
                    return true;
                }else return false;
        }else return false;
    }
    //end of the method
    public void tick(){

    }

    public void render(Graphics g){
        if (game.gameState==STATE.Menu) {
            //setting a font for the menu word
            Font fnt = new Font("arial", 1, 50);
            //setting a new font for writing inside the buttons
            Font fnt2 = new Font("arial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Menu", 240, 70);
            //setting the words inside the buttons with the chosn font
            //the first button with play word
            g.setFont(fnt2);
            g.drawRect(210, 150, 200, 64);
            g.drawString("Play", 270, 190);
            //the second button
            g.drawRect(210, 250, 200, 64);
            g.drawString("help", 270, 290);
            //the third button
            g.drawRect(210, 350, 200, 64);
            g.drawString("Quit", 270, 390);
        }else if (game.gameState==STATE.Help){
            //setting a font for the menu word
            Font fnt = new Font("arial", 1, 50);
            //setting a new font for writing inside the buttons
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Help", 240, 70);

            g.setFont(fnt3);
            g.drawString("Use WASD key to move player and dodge enemies ",50,200);

            //back button
            g.setFont(fnt2);
            g.drawRect(210, 350, 200, 64);
            g.drawString("back", 270, 390);
        }else if (game.gameState==STATE.End){
            //setting a font for the menu word
            Font fnt = new Font("arial", 1, 50);
            //setting a new font for writing inside the buttons
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Game Over", 180, 70);

            g.setFont(fnt3);
            g.drawString("Better luck next time" ,175,200);

            //back button
            g.setFont(fnt2);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Try Again", 245, 390);
        }else if (game.gameState==STATE.Select) {
            //setting a font for the menu word
            Font fnt = new Font("arial", 1, 50);
            //setting a new font for writing inside the buttons
            Font fnt2 = new Font("arial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Select Difficulty", 140, 70);
            //setting the words inside the buttons with the chosn font
            //the first button with play word
            g.setFont(fnt2);
            g.drawRect(210, 150, 200, 64);
            g.drawString("Normal", 270, 190);
            //the second button
            g.drawRect(210, 250, 200, 64);
            g.drawString("Hard", 270, 290);
            //the third button
            g.drawRect(210, 350, 200, 64);
            g.drawString("Back", 270, 390);
        }

    }
}
