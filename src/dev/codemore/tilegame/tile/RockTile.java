package dev.codemore.tilegame.tile;

import dev.codemore.tilegame.gfx.Assets;

public class RockTile extends Tile{
	
	public RockTile(int id){
		super(Assets.tree, id);
		}
	
	//Override
	public boolean isSolid(){
		return true;
	}
}
