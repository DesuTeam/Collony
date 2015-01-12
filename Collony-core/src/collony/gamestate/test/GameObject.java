package collony.gamestate.test;

import collony.tileMap.OrthogonalTileMap;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject 
{
	protected OrthogonalTileMap map;
	protected TiledMap tiledMap;
	
	public GameObject(OrthogonalTileMap map) 
	{
		if(map == null)
			throw new IllegalArgumentException("Map is null");
		this.map = map;
		if(map.getTiledMap() == null)
			throw new IllegalArgumentException("Map.TilesMap is null");
		tiledMap = map.getTiledMap();
	}
	
	//Position
	protected float x;
	protected float y;
	
	//Dimensions
	protected float width;
	protected float height;
	// Collision box
	protected float collusionWidth;
	protected float collusionHeight;

	//Velocity
	protected float dx;
	protected float dy;
	//Acceleration
	protected float ddx;
	protected float ddy;
	//position in tiles
	protected int currentRow;
	protected int currentColl;
	
	//next position
	protected float nextX;
	protected float nextY;
	protected float tempX;
	protected float tempY;
	protected boolean topLeft;
	protected boolean topRight;
	protected boolean bottomLeft;
	protected boolean bottomRight;
	
	//movement
	protected boolean left;
	protected boolean right;
	protected boolean up;
	protected boolean down;
	

	protected float moveSpeed;
	protected float maxSpeed;
	protected float stopSpeed;
	
	public abstract void render(SpriteBatch sb);
	public void update(float dt)
	{
		dx += ddx * dt;
		dy += ddy * dt;
		if(dx > maxSpeed)
			dx = maxSpeed;
		else if(dx < -maxSpeed)
			dx = -maxSpeed;
		if(dy > maxSpeed)
			dy = maxSpeed;
		else if(dy < -maxSpeed)
			dy = -maxSpeed;
		
		
		nextX = x + dx * dt;
		nextY = y + dy * dt;
		checkTileMapCollision();
		x = tempX;
		y = tempY;
	}
	private void checkTileMapCollision() 
	{
		currentColl = (int)x /  map.getTileWidth();
		currentRow  = (int)y / map.getTileHeight();
		
		tempX = x;
		tempY = y;
		
		calculateCorners(x , nextY);
		
		if(dy < 0)
			if(topLeft || topRight)
			{
				dy = 0;
				tempY = currentRow * map.getTileHeight() + collusionHeight / 2;
			}
			else
				tempY += dy;
		if(dy > 0)
			if(bottomLeft || bottomRight)
			{
				dy = 0;
				tempY = (currentRow + 1) * map.getTileHeight() - collusionHeight / 2;
			}
			else
				tempY += dy;
		
		calculateCorners(nextX, y);
		
		if(dx < 0)
			if(topLeft || bottomLeft)
			{
				dx = 0;
				ddx = 0;
				tempX = currentColl * map.getTileWidth() + collusionWidth / 2;
			}
			else
				tempX += dx;
		if(dx > 0)
			if(topRight || bottomRight)
			{
				dx = 0;
				ddx = 0;
				tempX = (currentColl + 1) * map.getTileWidth() - (collusionWidth / 2);
			}
			else
				tempX += dx;
		
		x = tempX;
		y = tempY;
		
	} 
	
	private void calculateCorners(float x, float y) 
	{
		int leftTile  = (int) (x - collusionWidth / 2) / map.getTileWidth();
		int rightTile = (int) (x + collusionWidth / 2 - 1) / map.getTileWidth();
		int topTile = (int)(y - collusionHeight / 2) / map.getTileHeight();
		int bottomTile = (int)(y + collusionHeight / 2 - 1) / map.getTileHeight();
		
		topLeft = map.isBlocked(leftTile, topTile);
		topRight = map.isBlocked(rightTile, topTile);
		bottomLeft = map.isBlocked(leftTile, bottomTile);
		bottomRight = map.isBlocked(rightTile, bottomTile);
		
	}
	public Rectangle getRectangle()
	{
		return new Rectangle(x , y , 
				collusionWidth,
				collusionHeight);
	}
	public float getX() 
	{
		return x;
	}
	public float getY() 
	{
		return y;
	}
	public float getWidth() 
	{
		return width;
	}
	public float getHeight() 
	{
		return height;
	}
	public float getCollusionWidth() 
	{
		return collusionWidth;
	}
	public float getCollusionHeight() 
	{
		return collusionHeight;
	}
	public float getDX() 
	{
		return dx;
	}
	public float getDY() 
	{
		return dy;
	}
	public float getMoveSpeed() 
	{
		return moveSpeed;
	}
	public float getMaxSpeed() 
	{
		return maxSpeed;
	}
	public float getStopSpeed() 
	{
		return stopSpeed;
	}
	
	
	
}
