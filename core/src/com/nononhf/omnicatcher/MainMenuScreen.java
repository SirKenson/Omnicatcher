package com.nononhf.omnicatcher;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenuScreen implements Screen {
	
	/* references the main class */
	final OmniMain game;
	
	/* for the camera */
	OrthographicCamera camera;
	
	/* Main Menu Images */
	Texture logo;
	Texture play;
	Texture howToPlay;
	Texture about;
	Texture exit;
	
	/* Screen booleans for switching screens */
	static boolean playGame;
	static boolean howToScreen;
	static boolean aboutScreen;
	
	public MainMenuScreen(final OmniMain gam) {
		
		/* I think this initializes the class */
		game = gam;
		
		/* Camera settings */
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 450);
		
		/* Main Menu Image calling */
		logo = new Texture("textures/logo.png");
		play = new Texture("textures/play.png");
		howToPlay = new Texture("textures/how to play.png");
		about = new Texture("textures/about.png");
		exit = new Texture("textures/exit.png");
			
	}
	
	@Override
	public void render(float delta) {
		
		/* Background color settings */
		Gdx.gl.glClearColor(0.45f, 0, 0.55f, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		/* Camera settings */
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		
		/* Begins to render the onscreen items, items are rendered in the order of line #, lower # = higher priority */
		game.batch.begin();
		clickButton(); /* Click the buttons */ 
		mouseDebug(); /* For dev purposes only */ 
		game.batch.draw(logo, 280, 240);
		game.batch.draw(play, 0, 230);
		game.batch.draw(howToPlay, 0, 170);
		game.batch.draw(about, 0, 110);
		game.batch.draw(exit, 0, 50);
		game.font.draw(game.batch, "Created by Nonon Jakuzure, media used credited to their respective owners.", 310, 14);
		game.batch.end();
	
		/* Screen Switching */
		switchScreen();

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

	/* Disposes of resources when needed */ 
	@Override
	public void dispose() {
		logo.dispose();
		play.dispose();
		howToPlay.dispose();
		exit.dispose();
		game.batch.dispose();
		game.font.dispose();

	}
	
	/** This method is for clicking the buttons on the main menu. May contain snippets of debugging code */
	private void clickButton() {
		
		if (Gdx.input.isTouched() && Gdx.input.getX() >= 0 && Gdx.input.getX() <= 241 && Gdx.input.getY() >= 170 && Gdx.input.getY() <= 220) {
			
			/* This output is used for debugging purposes only. Has no actual function besides debugging */
			System.out.println("Clicked play.");
			playGame = true;
			
		}
		
		if (Gdx.input.isTouched() && Gdx.input.getX() >= 0 && Gdx.input.getX() <= 241 && Gdx.input.getY() >= 230 && Gdx.input.getY() <= 280) {
			
			/* This output is used for debugging purposes only. Has no actual function besides debugging */
			System.out.println("Clicked how to play.");
			howToScreen = true;
			
		}
		
		if (Gdx.input.isTouched() && Gdx.input.getX() >= 0 && Gdx.input.getX() <= 241 && Gdx.input.getY() >= 291 && Gdx.input.getY() <= 339) {
			
			/* This output is used for debugging purposes only. Has no actual function besides debugging */
			System.out.println("Clicked about.");
			aboutScreen = true;
			
		}
		
		if (Gdx.input.isTouched() && Gdx.input.getX() >= 0 && Gdx.input.getX() <= 241 && Gdx.input.getY() >= 350 && Gdx.input.getY() <= 400) {
			
			/* This output is used for debugging purposes only. Has no actual function besides debugging */
			System.out.println("Clicked exit.");
			
			/* Exits the game. Duh!*/
			System.exit(0);
			
		}
		
	}
	
	/** This method is to simply debug where the mouse has been clicked. */
	private void mouseDebug() {
		
		if (Gdx.input.isTouched()) {
			
			/* Prints to the console where the mouse was clicked at the X & Y coords. */
			System.out.println("X: " + Gdx.input.getX() + " Y: " + Gdx.input.getY());
			
		}
		
	}
		
	/* Method that handles screen switching. Much cleaner than having it in the render() method. */ 
	private void switchScreen() {
		
		if (playGame) {
			
			game.setScreen(new GameScreen(game));
			
			
		}
		
		if (aboutScreen) {
			
			game.setScreen(new AboutScreen(game));
			
			
		}
		
		if (howToScreen) {
			
			game.setScreen(new HowToScreen(game));
			
			
		}
		
	}
	
}
