package com.tutorial.main;

import java.awt.*;

public class SmartEnemy extends GameObject{
    Handler handler;
    private GameObject player;
    public SmartEnemy(int x , int y ,ID id, Handler handler) {
        super(x,y,id);
        this.handler = handler;
        for (int i = 0; i<handler.object.size(); i++){
            if(handler.object.get(i).getID() == ID.Player)
                player = handler.object.get(i);
        }
    }
    public void tick() {
        x+=velX;
        y+=velY;
        float diffx = x-player.getX()-8;
        float diffy = y-player.getY()-8;
        float distance = (float)Math.sqrt((x-player.getX())*(x-player.getX())+( y-player.getY())* (y-player.getY()));
        velX = (int)((-1.0/distance)*diffx);
        velY = (int)((-1.0/distance)*diffy);

        if(y<0 || y>=Game.HEIGHT - 32) velY *= -1;
        if(x<0 || x>=Game.WIDTH - 16) velX *= -1;


        handler.addObject(new Trail(x, y, ID.Trail, Color.green, 16, 16, 0.02f, handler));

    }
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void render(Graphics g){
//            Graphics2D g2d = (Graphics2D) g;
//            g.setColor(Color.red);
//            g2d.draw(getBounds());
        g.setColor(Color.green);
        g.fillRect((int)x,(int) y, 16, 16);
    }
}
