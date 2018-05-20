package com.opera.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRender {
	private World world;
	private ShipGame ship;
    private Texture characterImg;
    private Texture backgroundImg;
    private Texture warnImg;
    private Texture sharkImg;
    private Texture rockImg;
    private Texture dropImg;
    private Texture overImg;
    private Texture oceanImg;
    private Texture goodhopeImg;
    private Texture frontImg;
    private Texture heart0Img;
    private Texture heartImg;
    private Texture heart2Img;
    private Texture heart3Img;
    private Texture warnbgImg;
    private Texture mapImg;
    private Texture pirateImg;
    private Texture subship;
    private Texture subship1;
    private Texture subgame;
    private Texture wind;
    WorldRender worldrenderer;
    
    public WorldRender(ShipGame ship, World world) {
    	this.ship = ship;
    	this.world = world;
    	
        sharkImg = new Texture("shark.png");
        rockImg = new Texture("rock.png");
        characterImg = new Texture("ship.png");
        warnImg = new Texture("warning.png");
        backgroundImg = new Texture("water.png");
        heart0Img = new Texture("red.png");
        heartImg = new Texture("orange.png");
        heart2Img = new Texture("yellow.png");
        heart3Img = new Texture("green.png");
        overImg = new Texture("gameover.png");
        dropImg = new Texture("drop.png");
        oceanImg = new Texture("ocean.png");
        goodhopeImg = new Texture("hope.png");
        frontImg = new Texture("front.png");
        warnbgImg = new Texture("warnbg.png");
        mapImg = new Texture("map.png");
        subship = new Texture("sub5.png");
        subship1 = new Texture("sub6.1.png");
        subgame = new Texture("sub6.2.png");
        pirateImg = new Texture("pirate.png");
        wind = new Texture("wind.png");
    }
	public void render (float delta) {
        SpriteBatch batch = ship.batch;
        batch.begin();
        Charecter poschar = world.getCharecter();
        Item positionshark = world.getShark();
        Item positionrock = world.getRock();
        Warning positionwarn = world.getWarn();
        Heart posheart = world.getHeart();
        Heart posheart2 = world.getHeart2();
        Heart posheart0 = world.getHeart0();
        Ship posship = world.getShip();
        if(poschar.getPosition().x<440) {
        	poschar.getPosition().x = 440;
        	poschar.getPosition().y = 100;
        }
        if(poschar.getPosition().x>770) {
        	poschar.getPosition().x = 770;
        	poschar.getPosition().y = 100;
        }
        if(posship.getPosition().y>0 || posship.getPosition().y<-20) {
        	Ship.SPEED *= -1;
        }
        if(world.gameState == -4) {
        	batch.draw(oceanImg,0,0);
        	batch.draw(frontImg,posship.getPosition().x, posship.getPosition().y,posship.width,posship.height);
        	batch.draw(subship,40,0);
        }
        if(world.gameState == -3) {
        	batch.draw(goodhopeImg,0,0);
        	batch.draw(frontImg,posship.getPosition().x, posship.getPosition().y,posship.width,posship.height);
        }
        if(world.gameState == -2) {
        	//thunder.play();
        	batch.draw(warnbgImg,0,0);
        	batch.draw(frontImg,posship.getPosition().x, posship.getPosition().y,posship.width,posship.height);
        	batch.draw(subship1,40,0);
        }
        if(world.gameState == -1) {
        	//thunder.pause();
        	//pak.play();
        	batch.draw(warnbgImg,0,0);
        	batch.draw(frontImg,posship.getPosition().x, posship.getPosition().y,posship.width,posship.height);
        	batch.draw(subgame,40,0);
        }
        if(world.gameState == 0) {
        	batch.draw(dropImg,0,0);
        	batch.draw(backgroundImg,440,60);
        	batch.draw(heart3Img,440,60);
        	batch.draw(heart0Img,posheart0.getPosition().x,posheart0.getPosition().y);
        	batch.draw(heartImg,posheart.getPosition().x,posheart.getPosition().y);
        	batch.draw(heart2Img,posheart2.getPosition().x,posheart2.getPosition().y);
	        batch.draw(sharkImg, positionshark.getPosition().x, positionshark.getPosition().y,positionshark.width,positionshark.height);
	        batch.draw(rockImg, positionrock.getPosition().x, positionrock.getPosition().y,positionrock.width,positionrock.height);
	        batch.draw(characterImg, poschar.getPosition().x, poschar.getPosition().y,poschar.width,poschar.height);
	    	batch.draw(warnImg,positionwarn.getPosition().x,positionwarn.getPosition().y,positionwarn.width,positionwarn.height);
        }
		if(world.gameState == 1) {
			batch.draw(dropImg,0,0);
			batch.draw(overImg,440,60);
		}
		if(world.gameState == 2) {
			batch.draw(oceanImg,0,0);
			batch.draw(mapImg,280,200);
        	batch.draw(frontImg,posship.getPosition().x, posship.getPosition().y,posship.width,posship.height);
		}
		if(world.gameState == 3) {
			batch.draw(wind,0,0);
		}
		if(world.gameState == 4) {
			batch.draw(oceanImg,0,0);
        	batch.draw(frontImg,posship.getPosition().x, posship.getPosition().y,posship.width,posship.height);
			//batch.draw(mapImg,280,200);
		}
		if(world.gameState == 5) {
			batch.draw(pirateImg,0,0);
        	batch.draw(frontImg,posship.getPosition().x, posship.getPosition().y,posship.width,posship.height);
		}
        batch.end();
	}
}
