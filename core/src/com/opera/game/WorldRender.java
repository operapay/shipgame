package com.opera.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRender {
	private World world;
	private ShipGame ship;
    private Texture characterImg;
    private Texture backgroundImg;
    private Texture warnImg;
    private Texture sharkImg;
    private Texture rockImg;
    private Texture overImg;
    private Texture heart0Img;
    private Texture heartImg;
    private Texture heart2Img;
    private Texture heart3Img;
    WorldRender worldrenderer;
    private BitmapFont font;
    
    public WorldRender(ShipGame ship, World world) {
    	this.ship = ship;
    	this.world = world;
    	font = new BitmapFont();
    	font.getData().setScale(2);
    	
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
        if(poschar.getPosition().x<-50 || poschar.getPosition().x>380) {
        	Charecter.SPEED *= -1;
        }
        batch.draw(backgroundImg,0,0);
        if(world.gameState == 0) {
        	batch.draw(heart3Img,0,0);
        	batch.draw(heart0Img,posheart0.getPosition().x,posheart0.getPosition().y);
        	batch.draw(heartImg,posheart.getPosition().x,posheart.getPosition().y);
        	batch.draw(heart2Img,posheart2.getPosition().x,posheart2.getPosition().y);
	        batch.draw(sharkImg, positionshark.getPosition().x, positionshark.getPosition().y,positionshark.width,positionshark.height);
	        batch.draw(rockImg, positionrock.getPosition().x, positionrock.getPosition().y,positionrock.width,positionrock.height);
	        batch.draw(characterImg, poschar.getPosition().x, poschar.getPosition().y,poschar.width,poschar.height);
	    	batch.draw(warnImg,positionwarn.getPosition().x,positionwarn.getPosition().y,positionwarn.width,positionwarn.height);
	    	//font.draw(batch, "score " + world.getScore(), 250, 70);
        }
		if(world.gameState == 1) {
			batch.draw(overImg,0,0);
			//font.draw(batch, "GAMEOVER",110,400);
			//font.draw(batch, "highscore  " + world.getScore(),100,350);
			//font.draw(batch, "Enter To Play Agian", 70,350);
		}
        batch.end();
	}
}
