package collony.tileMap;

import collony.gamestate.test.Player;
import collony.main.Game;

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
	}
	
	
		
	public void update(float dt)
	{
		player.update(dt);
		camera.position.x += (player.getX() - camera.position.x) * 3 * dt;
		camera.position.y += (player.getY() - camera.position.y) * 3 * dt;
		
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
	public<T> T getProperty(int x , int y ,String property , Class<T> clss)
	{
		return ((TiledMapTileLayer)tiledMap.getLayers().get("Layer1"))
				.getCell(x, y).getTile().
				getProperties().get(property , clss);
	}
	public boolean isBlocked(int x , int y)
	{
		return hasProperty(x, y, "blocked") && (Integer.parseInt(getProperty(x, y, "blocked" , String.class)) == 1);
	}
	public int getTileWidth()
	{
		return tileWidth;
	}
	public int getTileHeight()
	{
		return tileHeight;
	}
	/**
	 * [Tiles]
	 **/
	public int getWidth()
	{
		return mapWidth;
	}
	/**
	 * [<b>Tiles</b>]
	 * */
	public int getHeight()
	{
		return mapHeight;
	}
}
