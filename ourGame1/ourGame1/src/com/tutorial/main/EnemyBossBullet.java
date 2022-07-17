package com.tutorial.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject {
    Handler handler;
    Random r = new Random();
    public EnemyBossBullet(int x , int y ,ID id, Handler handler) {
        super(x,y,id);
        this.handler = handler;
        velX=(r.nextInt(5 - -5)+ -5);
        velY=5;
    }
    public void tick() {
        x+=velX;
        y+=velY;
       
        //if(y<=0 || y>= Game.HEIGHT - 70) velY*=-1;
        //if(x<=0 || x>= Game.WIDTH - 45) velX*=-1;
        if(y>Game.HEIGHT) handler.removeObject(this);
         handler.addObject(new Trail(x, y, ID.Trail, Color.yellow, 16, 16, 0.02f, handler));
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x,(int) y, 16, 16);
    }

    public void render(Graphics g){
//            Graphics2D g2d = (Graphics2D) g;
//            g.setColor(Color.red);
//            g2d.draw(getBounds());
        g.setColor(Color.yellow);
        g.fillRect((int)x,(int) y, 16, 16);
    }
}
