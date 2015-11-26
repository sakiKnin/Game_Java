package dev.codemore.tilegame.states;

import java.awt.Graphics;

import dev.codemore.tilegame.Game;
import dev.codemore.tilegame.Handler;
import dev.codemore.tilegame.entities.creatures.Player;
import dev.codemore.tilegame.gfx.Assets;
import dev.codemore.tilegame.tile.Tile;
import dev.codemore.tilegame.worlds.World;

public class GameState extends State {

	private Player player;
	private World world;
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		player = new Player(handler, 100, 100);
	 
	}
	
	@Override
	public void tick() {
		 world.tick();
		 player.tick();
		 
	}

	@Override
	public void render(Graphics g) {
		  world.render(g);
		  player.render(g);
		  //Tile.tiles[0].render(g,0,0);
	}

}
