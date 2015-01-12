package collony.util;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.InputProcessor;


/**
 * Game Input Processor
 */
public class GIP implements InputProcessor
{
	
	public static int mousex;
	public static int mouseY;
	private static Map<Integer,Void> preccedKeys = new HashMap<Integer, Void>();
	
	
	@Override
	public boolean keyDown(int keycode) 
	{
		preccedKeys.put(keycode, null);
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
	
	public static boolean isPressed(int key)
	{
		return preccedKeys.containsKey(key);
	}

}
