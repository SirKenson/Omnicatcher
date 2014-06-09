package com.nononhf.omnicatcher;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class OmniMain extends Game {
	
	SpriteBatch batch;
	BitmapFont font;
	
	@Override
	public void create() {
		
		batch = new SpriteBatch();
		
		//Use libgdx's default font
		font = new BitmapFont();
		this.setScreen(new MainMenuScreen(this));
		
	}
	
	/* Basically acts as the main method to render so instances don't need to use the create() method in each class, I think*/ 
	@Override
	public void render() {
		
		super.render();
		
	}
	
	/* Disposes of resources when called on */ 
	public void dispose() {
		
		batch.dispose();
		font.dispose();
		
	}
}
