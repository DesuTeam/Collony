package collony.tileMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import collony.main.Game;
import collony.util.GIP;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class TileMap 
{
	
	private TiledMap tileMap;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	
	private int offsetX;//[Pixels]
	private int offsetY;//[Pixels]
	private int width;//  [Tiles]
	private int height;// [Tiles]
	
	
	public TileMap(FileHandle txmFile) 
	{
		tileMap = new 
				com.badlogic.gdx.maps.tiled.
				TmxMapLoader().load(txmFile.path());
		renderer = new OrthogonalTiledMapRenderer(tileMap,0.9F);
		camera = new OrthographicCamera(Game.WIDTH, Game.HEIGHT);
		renderer.setView(camera);
	}
	
	
		
	public void update(float dt)
	{
		if(GIP.isPressed(Input.Keys.W))
		{
			camera.position.y+=2;
		}
		if(GIP.isPressed(Input.Keys.S))
		{
			camera.position.y-=2;
		}
		if(GIP.isPressed(Input.Keys.A))
		{
			camera.position.x-=2;
		}
		if(GIP.isPressed(Input.Keys.D))
		{
			camera.position.x+=2;
		}
		camera.update();
		renderer.setView(camera);
	}
	public void render()
	{
		renderer.render();
	}
	
	public void dispose()
	{
		renderer.dispose();
		tileMap.dispose();
	}
}
