package dev.codenmore.tilegame;

import dev.codenmore.tilegame.dispaly.Display;

public class Launcher {
		
		public static void main (String[] args){
			
			Game game = new Game("Title Game!",640,360);
			
			game.start();
			
			
		}

}
