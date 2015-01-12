package collony.gamestate.test;

import com.badlogic.gdx.Gdx;

import collony.gamestate.*;
import collony.tileMap.OrthogonalTileMap;

public class TestState extends GameState
{
	
	private OrthogonalTileMap tileMap;
	
	public TestState(GameStateManager gsm)
	{
		super(gsm);
		init();
		tileMap = new OrthogonalTileMap(Gdx.files.internal("maps/map1/map.tmx"));
	}

	@Override
	public void init() 
	{
		
	}

	@Override
	public void update(float dt)
	{
		tileMap.update(dt);
	}

	@Override
	public void render()
	{
		tileMap.render();
	}

	@Override
	public void dispose() 
	{
		tileMap.dispose();	
	}

}
