package collony.gamestate;

public abstract class GameState
{

	protected GameStateManager gsm;
	
	protected GameState(GameStateManager gsm)
	{
		this.gsm = gsm;
	}
	
	public abstract void init();
	public abstract void update(float dt);
	public abstract void render();
	public abstract void handlInput();
	public abstract void dispose();
}
