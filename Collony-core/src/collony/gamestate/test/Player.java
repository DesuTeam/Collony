package collony.gamestate.test;

import collony.tileMap.OrthogonalTileMap;
import collony.util.GIP;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends GameObject
{

	private Texture tex;
	private Inventory invent;
	public Player(OrthogonalTileMap map) 
	{
		super(map);
		tex = new Texture(Gdx.files.internal("maps/map1/player.jpg"));
		invent = new Inventory();
		
		width = 32;
		height = 32;
		collusionHeight = 32;
		collusionWidth = 32;
		y = 250;
		x = 30;
		maxSpeed = 3;
	}
	
	@Override
	public void update(float dt) 
	{
		if (!invent.update(dt))
		{	
			if (GIP.isPressed(Input.Keys.E))
			{
				invent.visible = true;
				GIP.toggle(Input.Keys.E);
			}
			
			if(GIP.isDown(Input.Keys.UP))
				ddy = 100;
			else if(GIP.isDown(Input.Keys.DOWN))
				ddy = -100;
			else
			{
				ddy = 0;
				dy *= 0.8F;
			}
			
			if(GIP.isDown(Input.Keys.LEFT))
				ddx = -100;
			else if(GIP.isDown(Input.Keys.RIGHT))
				ddx = 100;
			else 
			{
				ddx = 0;
				dx *= 0.8F;
			}
			super.update(dt);
		}
		
	}

	@Override
	public void render(SpriteBatch sb) 
	{
		sb.begin();
		sb.draw(tex, x, y,width,height);
		sb.end();
		
		if(invent.visible)
			invent.render(sb);
	}
	
	
	
	
}
