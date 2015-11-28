package dev.codemore.tilegame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.codemore.tilegame.Game;
import dev.codemore.tilegame.Handler;
import dev.codemore.tilegame.gfx.Animation;
import dev.codemore.tilegame.gfx.Assets;
import dev.codemore.tilegame.gfx.GameCamera;

public class Player extends Creature {
	
	private Animation anim_down, anim_up, anim_left, anim_right;
	
	

 public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HIGHT);
		  
		bounds.x = 24;
		bounds.y = 32;
		bounds.width = 16;
		bounds.height = 32;
		
		//Animations
		
		anim_down = new Animation(500, Assets.player_down);
		anim_up = new Animation(500, Assets.player_up);
		anim_right = new Animation(500, Assets.player_right);
		anim_left = new Animation(500, Assets.player_left);
	}

	@Override
	public void tick() {
		if(yMove > 0)
			 	anim_down.tick();
		else if(yMove < 0)
			 	anim_up.tick();
		else if(xMove < 0)
			 	anim_left.tick();
		else 
			 	anim_right.tick();
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
		 
			g.drawImage(getCurrentAnimationFrame() , (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		 
 		//g.setColor(Color.RED);
		//g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()), (int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		if(xMove < 0)
			return anim_left.getCurrentFrame();
		else if(xMove > 0)
			return anim_right.getCurrentFrame();
		else if(yMove < 0)
			return anim_up.getCurrentFrame();
		else  
			return anim_down.getCurrentFrame();
		 
		}

}