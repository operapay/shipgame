package com.opera.game;

//import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Item {
	
    private Vector2 position;
    public static final int SPEED = 3;
    public static final int SPEED2 = 4;
    //private int number = ThreadLocalRandom.current().nextInt(440,770);
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
    	position.y -= SPEED2;
        rectangle.setPosition(position.x,position.y);
    }
	public void genshark() {
    	position.x = ThreadLocalRandom.current().nextInt(440,770);
    	position.y = 600;
	}
	public void genrock() {
    	position.x = ThreadLocalRandom.current().nextInt(440,770);
    	position.y = 600;
	}
}
