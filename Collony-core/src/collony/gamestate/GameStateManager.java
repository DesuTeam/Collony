package collony.gamestate;

import java.util.HashMap;
import java.util.Map;

import collony.gamestate.mainMenu.MenuState;
import collony.gamestate.test.TestState;

public class GameStateManager 
{
	
	private Map<STATES, GameState> states;
	
	private GameState gameState;

	public enum STATES
	{
		MENU,
		PLAY,
		TEST
	};

	public GameStateManager() 
	{
		states = new HashMap<STATES, GameState>();
		states.put(STATES.MENU, new MenuState(this));
		states.put(STATES.TEST, new TestState(this));
		
		setState(STATES.TEST.ordinal());
	}
	
	public void setState(int key)
	{
		if (gameState != null)
			gameState.dispose();
		
		if(key == STATES.MENU.ordinal())
		{
			gameState = states.get(STATES.MENU);
		}
		
		if(key == STATES.PLAY.ordinal())
		{
			//gameState = states.get(STATES.PLAY);
		}
		if(key == STATES.TEST.ordinal())
		{
			gameState = states.get(STATES.TEST);
		}
	}
	
	public void update(float dt)
	{
		gameState.update(dt);
	}
	
	public void render()
	{
		gameState.render();
	}
}
