package com.opera.game;

import java.util.Random;
import com.badlogic.gdx.math.Intersector;

public class World {
	private ShipGame shipGame;
    private Charecter charecter;
	private Item garlic;
	private Item blood;
	private Warning warn;
	private Heart heart;
	private Heart heart2;
	private Heart heart0;
    private Random number = new Random();
    private int score;
    private int time;
    private int count;
    public int gameState = 0;
	
	World(ShipGame shipGame){
		this.setShipGame(shipGame);
		charecter = new Charecter(100,100);
		garlic = new Item(850,number.nextInt(500));
		blood = new Item(850,number.nextInt(500));
        warn = new Warning(0,800);
        heart0 = new Heart(500,550);
        heart = new Heart(500,550);
        heart2 = new Heart(500,550);
	}
	public void resetWorld() {
		charecter.getPosition().set(100,100);
		garlic.getPosition().set(850, number.nextInt(500));
		blood.getPosition().set(850, number.nextInt(500));
		warn.getPosition().set(0,800);
		heart.getPosition().set(500, 550);
		heart0.getPosition().set(500, 550);
		heart2.getPosition().set(500, 550);
		Charecter.SPEED = 12;
		score = 0;
		time = 0;
		count = 0;
	}
	public void resetHeart() {
		heart0.getPosition().set(500, 550);
		heart.getPosition().set(500, 550);
		heart2.getPosition().set(500, 550);
		warn.getPosition().set(0,800);
		count = 0;
	}
	public int getScore() {
		return score;
	}
    public void increaseScore() {
        score += 1;
    }
	Charecter getCharecter() {
		return charecter;
	}
	Item getGarlic() {
		return garlic;
	}
	Item getBlood() {
		return blood;
	}
	Warning getWarn() {
		return warn;
	}
	Heart getHeart0() {
		return heart0;
	}
	Heart getHeart() {
		return heart;
	}
	Heart getHeart2() {
		return heart2;
	}
	public ShipGame getshipGame() {
		return shipGame;
	}
	public void setShipGame(ShipGame shipGame) {
		this.shipGame = shipGame;
	}
	public void update(float delta) {
		time +=1;
        if(time%300 == 60 || time%300 == 100 || time%300 == 140) {
        	garlic.gengarlic();
        }
        if((time%300)>0 & (time%300)< 300) {
        	garlic.move();
        }
        if(time%200 == 40 || time%200 == 80 || time%200 == 110) {
        	blood.genblood();
        }
        if((time%200)>0 & (time%200)<200) {
        	blood.move();
        }
    	if(Intersector.overlaps(charecter.getRectangle(),garlic.getRectangle()))
    	{
    		count++;
    		if(count == 1)
    			heart2.getPosition().set(0,0);
    		if(count == 2)
    			heart.getPosition().set(0,0);
    		if(count == 3) {
    			heart0.getPosition().set(0,0);
    			warn.getPosition().set(0,250);
    		}
    		garlic.gengarlic();
    	}
    	if(Intersector.overlaps(charecter.getRectangle(),blood.getRectangle()))
    	{
    		count++;
    		if(count == 1)
    			heart2.getPosition().set(0,0);
    		if(count == 2)
    			heart.getPosition().set(0,0);
    		if(count == 3) {
    			heart0.getPosition().set(0,0);
    			warn.getPosition().set(0,250);
    		}
    		
    		blood.genblood();	
    	} 
    	if(count==4) {
    		gameState = 1;
    	}
	}
}
