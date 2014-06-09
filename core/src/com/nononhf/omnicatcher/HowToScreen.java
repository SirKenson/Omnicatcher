package com.nononhf.omnicatcher;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HowToScreen implements Screen {
	
	final OmniMain game;
	
	
	/* Camera */
	OrthographicCamera camera;
	
	public HowToScreen(final OmniMain gam) {
		
		this.game = gam;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 450);
		
		
		
		
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0.45f, 0, 0.55f, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		
		game.batch.begin();
		game.font.draw(game.batch, "How to play:", 1, 450);
		game.font.draw(game.batch, "LEFT and RIGHT Arrow Keys to move left and right. ESC to return to the main menu.", 1, 430);
		game.font.draw(game.batch, "I will be implementing mouse controls soon for the android version to work and be compatible.", 1, 410);
		game.batch.end();
		
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			
			
			game.setScreen(new MainMenuScreen(game));
			MainMenuScreen.howToScreen = false;
			
			
		}

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {

		game.batch.dispose();
		game.font.dispose();

	}

}
