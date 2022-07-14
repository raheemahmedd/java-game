package com.tutorial.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.tutorial.main.Game.STATE;

public class Menu extends MouseAdapter {
    private Game game;
    private Handler handler;
    private Random r =new Random();
    public Menu (Game game,Handler handler){
        this.game =game;
        this.handler=handler;
    }
    public void mousePressed(MouseEvent e){
        int mx =e.getX();
        int my=e.getY();
if(game.gameState== STATE.Menu) {
        //here you go (play button)
        if (mouseOver(mx,my,210,150,200,64)){
          //      game.gameState=Game.STATE.Game;
            //handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32,ID.Player));
            //handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT) ,ID.BasicEnemy));
          game.gameState = STATE.Select;
          
          
        AudioPlayer.getSound("/menu_sound").play();
        return;
        }
        // help button
        if (mouseOver(mx,my,210,250,200,64)){
            game.gameState =Game.STATE.Help;
            AudioPlayer.getSound("/menu_sound").play();
        }

        //Quit button
        if (mouseOver(mx,my,210,350,200,64)){
           System.exit(1);
        }
}
if(game.gameState== STATE.Select) {
    //here you go (normal button)
    if (mouseOver(mx,my,210,150,200,64)){
        game.gameState=Game.STATE.Game;
        handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32,ID.Player));
        handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT) ,ID.BasicEnemy));
        game.diff = 0;
      
      
    AudioPlayer.getSound("menu_sound").play();
    }
    // hard button
    if (mouseOver(mx,my,210,250,200,64)){
    	game.gameState=Game.STATE.Game;
        handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32,ID.Player));
        handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT) ,ID.BasicEnemy, handler));
        game.diff = 1;
        AudioPlayer.getSound("menu_sound").play();
    }

    //back button
    if (mouseOver(mx,my,210,350,200,64)){
    	game.gameState =Game.STATE.Menu;
        AudioPlayer.getSound("menu_sound").play();
        return;
    }
}
        //back button for help
        if (game.gameState==Game.STATE.End) {
            if (mouseOver(mx,my,210,350,200,64)){
                game.gameState =Game.STATE.Menu;
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
        if (game.gameState==Game.STATE.Menu) {
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
        }else if (game.gameState==Game.STATE.Help){
            //setting a font for the menu word
            Font fnt = new Font("arial", 1, 50);
            //setting a new font for writing inside the buttons
            //Font fnt2 = new Font("arial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Help", 240, 70);

            Font fnt3 = new Font("arial", 1, 20);
            g.setFont(fnt3);
            g.drawString("Use WASD key to move player and dodge enemies ",40,200);

            //back button
            Font fnt2 = new Font("arial", 1, 30);
            g.setFont(fnt2);
            g.drawRect(210, 350, 200, 64);
            g.drawString("back", 270, 390);
        }else if (game.gameState==Game.STATE.Select) {
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
