package com.nononhf.omniclicker.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nononhf.omniclicker.OmniMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "OmniCatcher v0.01";
		config.width = 800;
		config.height = 450;
		config.resizable = false;
		new LwjglApplication(new OmniMain(), config);
	}
}
