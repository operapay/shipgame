package com.opera.game;

import java.util.Random;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Item {
	
    private Vector2 position;
    public static final int SPEED = 5;
    public static final int SPEED2 = 7;
    private Random number = new Random();
    public int width;
    public int height;
    private Rectangle rectangle;
    
    public Item(int x, int y) {
        position = new Vector2(x,y);
        width = 80;
        height = 80;
        rectangle = new Rectangle(x,y,width,height);
    }    
 
    public Vector2 getPosition() {
        return position;    
    }
    
    public Rectangle getRectangle() {
    	return rectangle;
    }
    public void move() { 
        //position.x -= SPEED;
    	position.y -= SPEED;
        rectangle.setPosition(position.x,position.y);
    }
    public void move2() { 
        //position.x -= SPEED2;
    	position.y -= SPEED;
        rectangle.setPosition(position.x,position.y);
    }
	public void genshark() {
    	position.x = number.nextInt(300);
    	position.y = 800;
	}
	public void genrock() {
    	position.x = number.nextInt(300);
    	position.y = 800;
	}
}
