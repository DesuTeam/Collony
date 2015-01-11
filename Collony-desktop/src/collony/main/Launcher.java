package collony.main;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Launcher 
{
	public static void main(String[] args) 
	{
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		
		cfg.width = 800;
		cfg.height = 600;
		cfg.useGL30 = false;
		cfg.title = "Collony";
		cfg.resizable = false;
		new LwjglApplication(null,cfg);
		
	}
}
