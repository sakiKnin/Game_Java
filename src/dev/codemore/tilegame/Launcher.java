package dev.codemore.tilegame;

import dev.codemore.tilegame.display.Display;

public class Launcher {
	
	public static void main(String[] args){
		
		Game game = new Game("Title Game!", 640, 360);
		// pozivamo start metodu u klasi Game 
		game.start();
		
		
	}

}
