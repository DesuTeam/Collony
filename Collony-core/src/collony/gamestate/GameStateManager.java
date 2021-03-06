package collony.gamestate;

import java.util.HashMap;
import java.util.Map;

import collony.gamestate.mainMenu.MenuState;
import collony.gamestate.test.Intro;
import collony.gamestate.test.TestState;

public class GameStateManager 
{
	
	private Map<STATES, GameState> states;
	
	private GameState gameState;

	public enum STATES
	{
		MENU,
		TEST,
		INTRO
	};

	public GameStateManager() 
	{
		states = new HashMap<STATES, GameState>();
		states.put(STATES.MENU, new MenuState(this));
		states.put(STATES.INTRO, new Intro(this));
		states.put(STATES.TEST, new TestState(this));
		
		setState(STATES.INTRO);
	}
	
	public void setState(STATES state)
	{
		gameState = states.get(state);
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
