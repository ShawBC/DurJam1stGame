package dev.shaw.gimmelife.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import dev.shaw.gimmelife.Player;
import dev.shaw.gimmelife.rougelike;
import dev.shaw.gimmelife.screens.PlayScreen;

/** Launches the desktop (LWJGL3) application. */
public class Lwjgl3Launcher {
	public static void main(String[] args) {
		createApplication();
	}

	private static Lwjgl3Application createApplication() {
		return new Lwjgl3Application(new rougelike(), getDefaultConfiguration());
	}

	private static Lwjgl3ApplicationConfiguration getDefaultConfiguration() {
		Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
		configuration.setTitle("gimmelife");
		configuration.setResizable(true);
		configuration.setWindowedMode(640, 480);
		configuration.setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png");

/*		//Pack all of our textures into a texture atlas
		//TODO: REMOVE BEFORE RELEASING

		TexturePacker.Settings sets = new TexturePacker.Settings();

		//https://github.com/libgdx/libgdx/wiki/Texture-packer
		sets.pot = true;
		sets.fast = true;
		sets.combineSubdirectories = true;
		sets.paddingX = 1;
		sets.paddingY = 1;
		sets.edgePadding = true;
		TexturePacker.process(sets, "raw_textures" , "./", "textures");*/



		return configuration;

	}
}