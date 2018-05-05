package com.opera.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRender {
	private World world;
	private ShipGame ship;
    private Texture characterImg;
    private Texture warnImg;
    private Texture garlicImg;
    private Texture bloodImg;
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
    	
        garlicImg = new Texture("garlic.png");
        bloodImg = new Texture("blood.png");
        characterImg = new Texture("vampire.png");
        warnImg = new Texture("warning.png");
        //backgroundImg = new Texture("2.jpg");
        heart0Img = new Texture("red.png");
        heartImg = new Texture("orange.png");
        heart2Img = new Texture("yellow.png");
        heart3Img = new Texture("green.png");
    }
	public void render (float delta) {
        SpriteBatch batch = ship.batch;
        batch.begin();
        Charecter poschar = world.getCharecter();
        Item positiongarlic = world.getGarlic();
        Item positionblood = world.getBlood();
        Warning positionwarn = world.getWarn();
        Heart posheart = world.getHeart();
        Heart posheart2 = world.getHeart2();
        Heart posheart0 = world.getHeart0();
        if(poschar.getPosition().x<-50 || poschar.getPosition().x>380) {
        	Charecter.SPEED *= -1;
        }
        //batch.draw(backgroundImg, 0, 100);
        if(world.gameState == 0) {
        	batch.draw(heart3Img,0,0);
        	batch.draw(heart0Img,posheart0.getPosition().x,posheart0.getPosition().y);
        	batch.draw(heartImg,posheart.getPosition().x,posheart.getPosition().y);
        	batch.draw(heart2Img,posheart2.getPosition().x,posheart2.getPosition().y);
	        batch.draw(garlicImg, positiongarlic.getPosition().x, positiongarlic.getPosition().y,positiongarlic.width,positiongarlic.height);
	        batch.draw(bloodImg, positionblood.getPosition().x, positionblood.getPosition().y,positionblood.width,positionblood.height);
	        batch.draw(characterImg, poschar.getPosition().x, poschar.getPosition().y,poschar.width,poschar.height);
	    	batch.draw(warnImg,positionwarn.getPosition().x,positionwarn.getPosition().y,positionwarn.width,positionwarn.height);
	    	//font.draw(batch, "score " + world.getScore(), 250, 70);
        }
		if(world.gameState == 1) {
			font.draw(batch, "GAMEOVER",110,400);
			//font.draw(batch, "highscore  " + world.getScore(),100,350);
			font.draw(batch, "Enter To Play Agian", 70,350);
		}
        batch.end();
	}
}
