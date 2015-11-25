package dev.codemore.tilegame.states;

import java.awt.Graphics;

import dev.codemore.tilegame.Game;
import dev.codemore.tilegame.entities.creatures.Player;
import dev.codemore.tilegame.gfx.Assets;
import dev.codemore.tilegame.tile.Tile;
import dev.codemore.tilegame.worlds.World;

public class GameState extends State {

	private Player player;
	private World world;
	
	public GameState(Game game){
		super(game);
		player = new Player(game,100,100);
		world = new World("res/worlds/world1.txt");
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
		  Tile.tiles[0].render(g,0,0);
	}

}
