package collony.tileMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TileMap 
{
	
	/*
	 * Blocks ID's
	 * 
	 * 0 - Ground
	 * 1 - Stone (Block)
	 */
	
	public enum Block
	{
		GROUND(0 , false, "Ground"),
		STONE(1 , true, "Stone"),
		;
		public final int id;
		public final boolean isBlock;
		public final String name;
		
		private Block(int id , boolean isBlock , String name) 
		{
			this.id = id;
			this.isBlock = isBlock;
			this.name = name;
		}
		public static Block getBlock(int id)
		{
			for(Block b : Block.values())
				if(b.id == id)
					return b;
			return null;
		}
	}
	
	private static boolean textureLoaded;
	private static Map<Block, Texture>textures;
	
	private Block[][] map;
	
	private int tileSize;
	private int offsetX;//[Pixels]
	private int offsetY;//[Pixels]
	private int width;//[Tiles]
	private int height;//[Tiles]
	
	
	public TileMap(FileHandle mapFile , int tileSize) 
	{
		load(mapFile);
		this.tileSize = tileSize;
		offsetX = 0;
		offsetY = 0;
	}
	
	private boolean load(FileHandle file)
	{
		try 
		{
		    BufferedReader r = file.reader(1024);
			width = Integer.parseInt(r.readLine());
			height = Integer.parseInt(r.readLine());
			
			String[] indexs;
			for(int y = 0;y < height;y++)
			{
				indexs = r.readLine().split(" ");
				for(int x = 0;x < width;x++)
					map[x][y] = Block.getBlock(Integer.parseInt(indexs[x]));
			}
			
			return true;
		} catch (NumberFormatException | IOException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public void update(float dt)
	{
		
	}
	public void render(SpriteBatch sb)
	{
		sb.begin();
		for(int x = 0;x < width;x++)
			for(int y = 0;y < height;y++)
				sb.draw(textures.get(map[x][y]) ,x * tileSize - offsetX , y * tileSize - offsetY , tileSize , tileSize);
		sb.end();
	}
	
	public static void loadTextures()
	{
		if(textureLoaded)
			return;
	
	}
	public static void disposeTextures()
	{
		if(!textureLoaded)
			return;
		Set<Block>keys = textures.keySet();
		for(Block b : keys)
		{
			textures.get(b).dispose();
			textures.remove(b);
		}
		
	}
}
