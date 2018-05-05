package com.opera.game;

//import java.util.Random;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Warning {
    private Vector2 position;
    public static final int SPEED = 5;
    //private Random number = new Random();
    public int width;
    public int height;
    private Rectangle rectangle;
    
    public Warning(int x, int y) {
        position = new Vector2(x,y);
        width = 400;
        height = 200;
        rectangle = new Rectangle(x,y,width,height);
    }    
 
    public Vector2 getPosition() {
        return position;    
    }
    
    public Rectangle getRectangle() {
    	return rectangle;
    }

}
