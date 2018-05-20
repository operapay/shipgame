package com.opera.game;

//import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Intersector;

public class World {
	private ShipGame shipGame;
    private Charecter charecter;
	private Item shark;
	private Item rock;
	private Ship ship;
	private Warning warn;
	private Heart heart;
	private Heart heart2;
	private Heart heart0;
    private int number = ThreadLocalRandom.current().nextInt(440,770);
    private int time;
    private int timeship;
    private int count;
    public int gameState = -4;
    Sound thunder;
    Sound pak;
    Music map,pirate;
	
	World(ShipGame shipGame){
		this.setShipGame(shipGame);
		charecter = new Charecter(540,100);
		shark = new Item(number,600);
		rock = new Item(number,600);
        warn = new Warning(440,850);
        heart0 = new Heart(500,850);
        heart = new Heart(500,850);
        heart2 = new Heart(500,850);
        ship = new Ship(380,0);
        thunder = Gdx.audio.newSound(Gdx.files.internal("thunder.mp3"));
        pak = Gdx.audio.newSound(Gdx.files.internal("pak.mp3"));
        map = Gdx.audio.newMusic(Gdx.files.internal("map.mp3"));
        pirate = Gdx.audio.newMusic(Gdx.files.internal("pirate.mp3"));
        //System.out.println(number);
	}
	public void resetWorld() {
		charecter.getPosition().set(540,100);
		shark.getPosition().set(number, 600);
		rock.getPosition().set(number, 600);
		warn.getPosition().set(440,850);
		heart.getPosition().set(500, 850);
		heart0.getPosition().set(500, 850);
		heart2.getPosition().set(500, 850);
		Charecter.SPEED = 12;
		time = 0;
		count = 0;
	}
	public void resetHeart() {
		heart0.getPosition().set(500, 850);
		heart.getPosition().set(500, 850);
		heart2.getPosition().set(500, 850);
		warn.getPosition().set(440,850);
		count = 0;
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
	Ship getShip() {
		return ship;
	}
	public ShipGame getshipGame() {
		return shipGame;
	}
	public void setShipGame(ShipGame shipGame) {
		this.shipGame = shipGame;
	}
	public void update(float delta) {
		timeship +=1;
		if(timeship>0) {
			ship.up();
		}
		if(gameState == -4) {
			if(timeship>300) {
				thunder.play();
				gameState = -3;
			}
		}
		if(gameState == -3) {
			if(timeship>500) {
				thunder.play(2);
				pak.play();
				gameState = -2;
			}
		}
		if(gameState == -2) {
			if(timeship>800) {
				gameState = -1;
			}
		}
		if(gameState == -1) {
			if(timeship>1200) {
				gameState = 0;
			}
		}
		if(gameState == 0 && timeship>1200) {
			//timeship = 1400;
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
	        	rock.move2();
	        }
	        if(time%150 == 70) {
	        	shark.genshark();
	        }
	        if((time%150)>0 & (time%150)< 150) {
	        	shark.move();
	        }
	        if( time%330 == 180) {
	        	rock.genrock();
	        }
	        if((time%330)>0 & (time%330)<330) {
	        	rock.move2();
	        }
	    	if(Intersector.overlaps(charecter.getRectangle(),shark.getRectangle()))
	    	{
	    		count++;
	    		if(count == 1)
	    			heart2.getPosition().set(440,60);
	    		if(count == 2)
	    			heart.getPosition().set(440,60);
	    		if(count == 3) {
	    			heart0.getPosition().set(440,60);
	    			warn.getPosition().set(440,310);
	    		}
	    		shark.genshark();
	    	}
	    	if(Intersector.overlaps(charecter.getRectangle(),rock.getRectangle()))
	    	{
	    		count++;
	    		if(count == 1)
	    			heart2.getPosition().set(440,60);
	    		if(count == 2)
	    			heart.getPosition().set(440,60);
	    		if(count == 3) {
	    			heart0.getPosition().set(440,60);
	    			warn.getPosition().set(440,310);
	    		}
	    		rock.genrock();	
	    	} 
	    	if(count==4) {
	    		gameState = 1;
	    		timeship = 1200;
	    	}
	    	if(timeship > 2100) {
	    		map.play();
	    		gameState = 2;
	    	}
		}
		/*if(gameState == 2 && (timeship > 2200 && timeship < 2220)) {
			map.play();
		}*/
		if(gameState == 2 && timeship > 2900) {
			if(timeship > 2900) {
				gameState = 3;
			}
		}
		if(gameState == 3 && timeship > 3500) {
			if(timeship > 3500) {
				gameState = 4;
			}
		}
		if(gameState == 4 && timeship > 3700) {
			if(timeship > 3700) {
				pirate.play();
				gameState = 5;
			}
		}
	}
}
