package collony.gamestate.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import collony.tileMap.OrthogonalTileMap;
import collony.util.GIP;

public class Player extends GameObject
{

	private Texture tex;
	public Player(OrthogonalTileMap map) 
	{
		super(map);
		tex = new Texture(Gdx.files.internal("maps/map1/redball.png"));
		width = 32;
		height = 32;
		collusionHeight = 32;
		collusionWidth = 32;
		y = 250;
		x = 30;
	}
	
	@Override
	public void update(float dt) 
	{
		if(GIP.isDown(Input.Keys.W))
			dy = 2;
		else
			dy = 0;
		if(GIP.isDown(Input.Keys.S))
			dy = -2;
		else
			dy = 0;
		if(GIP.isDown(Input.Keys.A))
			dx = -2;
		else
			dx = 0;
		if(GIP.isDown(Input.Keys.D))
			dx = 2;
		else 
			dx = 0;
			
		
		super.update(dt);
	}

	@Override
	public void render(SpriteBatch sb) 
	{
		sb.begin();
		sb.draw(tex, x, y,width,height);
		sb.end();
	}
	
	
	
	
}
