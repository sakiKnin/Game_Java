package dev.codemore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static final int width = 32, height = 32;
	
	public static BufferedImage player, dirt, grass, stone, tree;
	
	public static void init(){
		 
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		
		tree = sheet.crop(0, 0, width, height);
		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(2*width, 0, width, height);
		stone = sheet.crop(3*width, 0, width, height);
		player = sheet.crop(4*width, 0, width, height);
	}

}
