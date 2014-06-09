package com.nononhf.omnicatcher;

import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class GameScreen implements Screen {

	final OmniMain game;
	
	BitmapFont font2;
	Texture coinrain;
	Texture walletImg;
	
	/* Audio clip */
	Sound coindrop;
	
	/* Camera */
	OrthographicCamera camera;
	
	/* Deals with raining coins */
	Array<Rectangle> raincoins;
		
	/* Variables and such, self explanatory */
	static int wallet;
	Rectangle wallet1;
	long lastRainTime;
	long fallSpeed = 555555555;

	public GameScreen(final OmniMain gam) {
		
		/* Initializes the class */
		this.game = gam;
		
		/* Camera stuff */
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 450);
		
		
		/* Image handling */
		coinrain = new Texture("textures/omnicoin.png");
		walletImg = new Texture("textures/wallet.png");
		raincoins = new Array<Rectangle>();
	
		/* Sound Handling */
		 coindrop = Gdx.audio.newSound(Gdx.files.internal("coindrop.wav"));
		
		/* Image methods */
		raincoin();
		wallet();
	
	}
	
	@Override
	public void render(float delta) {

		/* Background coloring stuff */ 
		Gdx.gl.glClearColor(0.45f, 0, 0.55f, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		/* Updates the camera */ 
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		/* Controls when the rendering happens */ 
		game.batch.begin();
		
		/* Player controls */ 
		walletControls();
		
		/* Make it rain omnicoins */ 
		for(Rectangle raincoin: raincoins) {
			
			game.batch.draw(coinrain, raincoin.x, raincoin.y);
			
		}
		
		/* Draw the wallet */ 
		game.batch.draw(walletImg, wallet1.x, wallet1.y);
		
		/* Displays the wallet balance.*/ 
		game.font.draw(game.batch, "Wallet: " + wallet, 1, 450);
		
		/* Ends the rendering processes */ 
		game.batch.end();
		
		/* Spawns the OmniCoins, I'm not much of a good person at explaining math though. */ 
		 if(TimeUtils.nanoTime() - lastRainTime > fallSpeed) raincoin();

		Iterator<Rectangle> iter = raincoins.iterator();
		
		while(iter.hasNext()) {
			
			Rectangle raincoin = iter.next();
			raincoin.y -= 250 * Gdx.graphics.getDeltaTime();
			if(raincoin.y + 64 < 0) iter.remove();
			if(raincoin.overlaps(wallet1)) {
				
				wallet+= 1;
				coindrop.play();
				iter.remove();
				
			}
			
		}
		
		/* Returns you to the main menu */ 
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			
			
			game.setScreen(new MainMenuScreen(game));
			MainMenuScreen.playGame = false; /* sets the screen boolean to false. Game over screen will utilize a similar function. */ 
			
		}	

	}
	
	/* Method for raining the coins */ 
	private void raincoin(){
		
		Rectangle raincoin = new Rectangle();
		raincoin.x = MathUtils.random(0, 800-64);
		raincoin.y = 450;
		raincoin.width = 64;
		raincoin.height = 64;
		raincoins.add(raincoin);
		lastRainTime = TimeUtils.nanoTime();
		
	}
	
	/* Method for the wallet itself */ 
	private void wallet() {
		
		wallet1 = new Rectangle();
		wallet1.width = 64;
		wallet1.height = 24;
		wallet1.x = 800 / 2 - 64  / 2;
		wallet1.y = 0;
		
	}
	
	/* Player Controls */ 
	private void walletControls() {
		
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			
			wallet1.x -= 600 * Gdx.graphics.getDeltaTime();
			
			
			
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			
			wallet1.x += 600 * Gdx.graphics.getDeltaTime();
			
		}
		
		/* Keeps the wallet in bounds*/ 
		if (wallet1.x < 0) wallet1.x = 0;
		if (wallet1.x > 800 - 64) wallet1.x = 800 - 64;
 		
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
	
	/* Calls to dispose of the resources when needed. */ 
	
	@Override
	public void dispose() {

		walletImg.dispose();
		coinrain.dispose();
		coindrop.dispose();
		game.font.dispose();
		game.batch.dispose();		

	}

}
