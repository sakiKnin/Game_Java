package dev.codemore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static final int width = 32, height = 32;
	
	public static BufferedImage player, dirt, grass, cartman, tree;
	
	public static void init(){
		 
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		
		player = sheet.crop(0, 0, width, height);
		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(2*width, 0, width, height);
		cartman = sheet.crop(3*width, 0, width, height);
		tree = sheet.crop(0, height, width, height);
	}

}
