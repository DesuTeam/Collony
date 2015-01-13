package collony.tileMap;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface TileMap 
{
	void update();
	void render();
	OrthographicCamera getCamera();
	SpriteBatch getSpriteBatch();
	boolean tileHasProperty(int x , int y , String property);
}
