package collony.gamestate;

import java.util.HashMap;
import java.util.Map;

import collony.gamestate.mainMenu.MenuState;

public class GameStateManager 
{
	
	private Map<STATES, GameState> states;
	
	private GameState gameState;

	public enum STATES
	{
		MENU,
		PLAY,
	};

	public GameStateManager() 
	{
		states = new HashMap<STATES, GameState>();
		states.put(STATES.MENU, new MenuState(this));
		
		gameState = states.get(STATES.MENU);
	}
}
