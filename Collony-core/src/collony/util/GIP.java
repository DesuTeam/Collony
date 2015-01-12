package collony.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.badlogic.gdx.InputProcessor;


/**
 * Game Input Processor
 */
public class GIP implements InputProcessor
{
	
	public static int mousex;
	public static int mouseY;
	private static Map<Integer,Boolean> preccedKeys = 
			new HashMap<Integer, Boolean>();//int -keycode , boolean - just pressed
	
	
	
	@Override
	public boolean keyDown(int keycode) 
	{
		preccedKeys.put(keycode, true);
		return true;
	}

	@Override
	public boolean keyUp(int keycode) 
	{
		preccedKeys.remove(keycode);
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void update()
	{
		Set<Integer>codes = preccedKeys.keySet();
		for(int code : codes)
			preccedKeys.replace(code, false);
	}
	
	public static boolean isPressed(int key)
	{
		return isDown(key) && preccedKeys.get(key);
	}
	public static boolean isDown(int key)
	{
		return preccedKeys.containsKey(key);
	}

}
