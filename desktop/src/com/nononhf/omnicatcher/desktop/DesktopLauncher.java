package com.nononhf.omnicatcher.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nononhf.omnicatcher.OmniMain;

public class DesktopLauncher {
	
	private static double version = 0.02;
	
	public static void main (String[] arg) {
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "OmniCatcher v" + version;
		config.width = 800;
		config.height = 450;
		config.resizable = false;
		new LwjglApplication(new OmniMain(), config);
		
	}
}
