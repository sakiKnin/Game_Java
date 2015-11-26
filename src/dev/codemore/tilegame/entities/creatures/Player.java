package dev.codemore.tilegame.entities.creatures;

import java.awt.Graphics;

import dev.codemore.tilegame.Game;
import dev.codemore.tilegame.Handler;
import dev.codemore.tilegame.gfx.Assets;
import dev.codemore.tilegame.gfx.GameCamera;

public class Player extends Creature {

 public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HIGHT);
		  
	}

	@Override
	public void tick() {
		 getInput();
		 move();
		 handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput(){
			xMove = 0;
			yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.cartman, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}

}