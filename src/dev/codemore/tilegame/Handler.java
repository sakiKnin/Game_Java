package dev.codemore.tilegame;

import dev.codemore.tilegame.gfx.GameCamera;
import dev.codemore.tilegame.input.KeyManager;
import dev.codemore.tilegame.worlds.World;

public class Handler{

		private Game game;
		private World world;
		
		public Handler(Game game){
			this.setGame(game);
			}
		
		public GameCamera getGameCamera(){
			return game.getGameCamere();
		}
		
		public KeyManager getKeyManager(){
			return game.getKeyManager();
		}
		
		public int getWidth(){
			return game.getWidth();
		}
		
		public int getHeight(){
			return game.getHeight();
		}

		public Game getGame() {
			return game;
		}

		public void setGame(Game game) {
			this.game = game;
		}

		public World getWorld() {
			return world;
		}

		public void setWorld(World world) {
			this.world = world;
		}
}
