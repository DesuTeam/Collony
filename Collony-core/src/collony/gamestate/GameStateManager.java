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
		
		gameState = states.get(STATES.TEST);
	}
}
