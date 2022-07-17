package com.tutorial.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject{
    private float alpha = 1;
    private float life;
    private Handler handler;
    private Color color;
    private int  WIDTH, HIGHT;
    public Trail(float x, float y, ID id, Color color, int WIDTH, int HIGHT, float life, Handler handler){
        super(x, y, id);
        this.color = color;
        this.WIDTH = WIDTH;
        this.HIGHT = HIGHT;
        this.life = life;
        this.handler = handler;
    }

    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);
    }

    @Override
    public void tick() {
        if(alpha>life){
            alpha -= (life-0.001f);
        }else{
            handler.removeObject(this);
        }
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.fillRect((int)x,(int)y, WIDTH, HIGHT);

        g2d.setComposite(makeTransparent(1));

    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
