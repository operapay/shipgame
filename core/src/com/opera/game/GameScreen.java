package com.opera.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends ScreenAdapter {
    World world;
    WorldRender worldRenderer;
    private ShipGame shipGame;
    private Charecter charecter;
    private int count;
    
    public GameScreen(ShipGame shipGame) {
        this.setShipGame(shipGame);
        world = new World(shipGame);
        worldRenderer = new WorldRender(shipGame, world);
        charecter = world.getCharecter();
    }    
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	update(delta);
    	worldRenderer.render(delta);
    	world.update(delta);
    	if(world.gameState == 0) {
    		world.increaseScore();
    	}
    }
    
    private void update(float delta) {
        /*if(Gdx.input.isKeyPressed(Keys.DOWN)) {
        	charecter.move(Charecter.DIRECTION_DOWN);
        }
        if(Gdx.input.isKeyPressed(Keys.UP)) {
        	charecter.move(Charecter.DIRECTION_UP);
        }*/
        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
        	charecter.move(Charecter.DIRECTION_LEFT);
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
        	charecter.move(Charecter.DIRECTION_RIGHT);
        }
        if(Gdx.input.isKeyPressed(Keys.ENTER) && world.gameState == 1) {
        	world.gameState = 0;
        	world.resetWorld();
        } 
        if(Gdx.input.isKeyPressed(Keys.SPACE)) {
        	count++;
        	if(count%50 == 0) {
        		world.resetHeart();
        		count = 0;
        		//world.gameState = 0;
        	}
        	//world.resetWorld();
        } 
    }
	public ShipGame getShipGame() {
		return shipGame;
	}
	public void setShipGame(ShipGame shipGame) {
		this.shipGame = shipGame;
	}
}