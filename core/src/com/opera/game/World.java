package com.opera.game;

import java.util.Random;
import com.badlogic.gdx.math.Intersector;

public class World {
	private ShipGame shipGame;
    private Charecter charecter;
	private Item shark;
	private Item rock;
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
		shark = new Item(850,number.nextInt(500));
		rock = new Item(850,number.nextInt(500));
        warn = new Warning(0,800);
        heart0 = new Heart(500,550);
        heart = new Heart(500,550);
        heart2 = new Heart(500,550);
	}
	public void resetWorld() {
		charecter.getPosition().set(100,100);
		shark.getPosition().set(850, number.nextInt(500));
		rock.getPosition().set(850, number.nextInt(500));
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
	Item getShark() {
		return shark;
	}
	Item getRock() {
		return rock;
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
        if(time%300 == 100) {
        	shark.genshark();
        }
        if((time%300)>0 & (time%300)< 300) {
        	shark.move();
        }
        if(time%200 == 90) {
        	rock.genrock();
        }
        if((time%200)>0 & (time%200)<200) {
        	rock.move();
        }
        if(time%150 == 120) {
        	shark.genshark();
        }
        if((time%150)>0 & (time%150)< 150) {
        	shark.move();
        }
        if( time%330 == 160) {
        	rock.genrock();
        }
        if((time%330)>0 & (time%330)<330) {
        	rock.move();
        }
    	if(Intersector.overlaps(charecter.getRectangle(),shark.getRectangle()))
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
    		shark.genshark();
    	}
    	if(Intersector.overlaps(charecter.getRectangle(),rock.getRectangle()))
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
    		
    		rock.genrock();	
    	} 
    	if(count==4) {
    		gameState = 1;
    	}
	}
}
