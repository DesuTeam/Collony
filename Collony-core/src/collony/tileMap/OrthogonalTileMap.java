package collony.tileMap;

import collony.gamestate.test.Player;
import collony.main.Game;
import collony.util.GIP;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class OrthogonalTileMap 
{
	
	private TiledMap tiledMap;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	private Player player;
	
	private int mapWidth;
	private int mapHeight;
	private int tileWidth;
	private int tileHeight;
	
	
	public OrthogonalTileMap(FileHandle txmFile) 
	{
		tiledMap = new 
				com.badlogic.gdx.maps.tiled.
				TmxMapLoader().load(txmFile.path());
		MapProperties prop = tiledMap.getProperties();

		mapWidth = prop.get("width", Integer.class);
		mapHeight = prop.get("height", Integer.class);
		tileWidth = prop.get("tilewidth", Integer.class);
		tileHeight = prop.get("tileheight", Integer.class);
		renderer = new OrthogonalTiledMapRenderer(tiledMap);
		
		
		
		camera = new OrthographicCamera(Game.WIDTH, Game.HEIGHT);
		camera.setToOrtho(false, Game.WIDTH, Game.HEIGHT);
		camera.update();
		player = new Player(this);
		
		renderer.setView(camera);
		
		System.out.println(isBlocked(7, 0));
	}
	
	
		
	public void update(float dt)
	{
		player.update(dt);
		//camera.position.x = player.getX() - Game.WIDTH / 2;
		//camera.position.y = player.getY() - Game.HEIGHT / 2;
		
		camera.update();
		renderer.setView(camera);
	}
	public void render()
	{
		renderer.render();
		player.render((SpriteBatch)renderer.getBatch());
	}
	
	public void dispose()
	{
		renderer.dispose();
		tiledMap.dispose();
	}
	public TiledMap getTiledMap()
	{
		return tiledMap;
	}
	public boolean hasProperty(int x , int y ,String property)
	{
		Cell cell = ((TiledMapTileLayer)tiledMap.getLayers().get("Layer1")).getCell(x, y);
		if(cell == null)
			return false;
		return cell.getTile().
				getProperties().containsKey(property);
	}
	public Object getProperty(int x , int y ,String property)
	{
		Cell cell = ((TiledMapTileLayer)tiledMap.getLayers().get("Layer1")).getCell(x, y);
		if(cell == null)
			return false;
		return cell.getTile().
				getProperties().get(property);
	}
	public boolean isBlocked(int x , int y)
	{
		return hasProperty(x, y, "blocked") && ((Integer)getProperty(x, y, "blocked") == 1);
	}
	public int getTileWidth()
	{
		return tileWidth;
	}
	public int getTileHeight()
	{
		return tileHeight;
	}
}
