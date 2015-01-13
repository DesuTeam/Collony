package collony.gamestate.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import collony.gamestate.*;
import collony.gamestate.GameStateManager.STATES;
import collony.tileMap.OrthogonalTileMap;
import collony.util.GIP;

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
		if(GIP.isPressed(Input.Keys.ESCAPE))
			gsm.setState(STATES.MENU);
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

	@Override
	public void handlInput() 
	{
				
	}

}
