package collony.gamestate.test;

import collony.gamestate.*;

public class TestState extends GameState
{
	
	public TestState(GameStateManager gsm)
	{
		super(gsm);
		init();
	}

	@Override
	public void init() 
	{
		
	}

	@Override
	public void update(float dt)
	{
		System.out.println("TEST UPDATE");
	}

	@Override
	public void render()
	{
		System.out.println("TEST RENDER");
	}

	@Override
	public void dispose() 
	{
			
	}

}
