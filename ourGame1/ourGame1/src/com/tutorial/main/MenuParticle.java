package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject{
    private Handler handler;
     Random r = new Random();
    private Color col;
    public MenuParticle(int x , int y ,ID id, Handler handler) {
        super(x,y,id);
        this.handler = handler;
        velX=(r.nextInt(5 - -5)+ -5);
        velY=(r.nextInt(5 - -5)+ -5);
        if (velX == 0) velX=1;
        if (velY == 0) velY=1;
        col = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
    }
    public void tick() {
        x+=velX;
        y+=velY;
        handler.addObject(new Trail(x, y, ID.Trail, col, 16, 16, 0.02f, handler));
        if(y<=0 || y>= Game.HEIGHT - 70) velY*=-1;
        if(x<=0 || x>= Game.WIDTH - 45) velX*=-1;
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x,(int) y, 16, 16);
    }

    public void render(Graphics g){
//            Graphics2D g2d = (Graphics2D) g;
//            g.setColor(Color.red);
//            g2d.draw(getBounds());
        g.setColor(col);
        g.fillRect((int)x, (int)y, 16, 16);
    }
}
