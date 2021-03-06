package com.opera.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ShipGame extends Game {
	public SpriteBatch batch;
	
    @Override
    public void create () {
        batch = new SpriteBatch();
        setScreen(new GameScreen(this));
    }
    
    @Override
    public void render () {
        super.render();
    }
 
    @Override
    public void dispose () {
        batch.dispose();
    }
}
