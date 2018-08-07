package gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int WIDTH = 32, HEIGHT = 32;
	
	public static BufferedImage player, poop;
	
	public static void load() {
		Sheet sheet = new Sheet(GraphicsLoader.loadImage("/textures/sheet.png"));
		
		//player = sheet.cropImage(0, 0, WIDTH, HEIGHT);
		player = GraphicsLoader.loadImage("/textures/studniak.png");
		poop = GraphicsLoader.loadImage("/textures/poop.png");
		
	}

}
