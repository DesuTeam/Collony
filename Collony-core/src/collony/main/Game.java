package collony.main;

import collony.gamestate.GameStateManager;
import collony.util.GIP;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class Game implements ApplicationListener
{

	public static int WIDTH;
	public static int HEIGHT;
	
	private GameStateManager gsm;
	@Override
	public void create() 
	{
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		
		gsm = new GameStateManager();
		Gdx.input.setInputProcessor(new GIP());
	}

	@Override
	public void resize(int width, int height) 
	{
	
	}

	@Override
	public void render() 
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render();
	}

	@Override
	public void pause() 
	{
		
	}

	@Override
	public void resume()
	{
	
	}

	@Override
	public void dispose()
	{
			
	}

}
