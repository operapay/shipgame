package com.opera.game;

//import java.util.concurrent.ThreadLocalRandom;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Ship {
    private Vector2 position;
    public static int SPEED = 1;
   // private int number = ThreadLocalRandom.current().nextInt(440,770);
    public int width;
    public int height;
    private Rectangle rectangle;
    
    public Ship(int x, int y) {
        position = new Vector2(x,y);
        width = 554;
        height = 191;
        rectangle = new Rectangle(x,y,width,height);
    }    
 
    public Vector2 getPosition() {
        return position;    
    }
    
    public Rectangle getRectangle() {
    	return rectangle;
    }
    public void up() { 
    	position.y += SPEED;
        rectangle.setPosition(position.x,position.y);
    }
}

