package collony.gamestate.test;

import collony.items.ItemStack;
import collony.main.Game;
import collony.util.GIP;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Inventory 
{
	private ItemStack[][] invent;
	private int curItem_X;
	private int curItem_Y;
	private int max_X;
	private int max_Y;
	private int size;
	private int padding;
	private ShapeRenderer shr;
	public boolean visible;
	
	public Inventory()
	{
		max_X = 11;
		max_Y = 4;
		invent = new ItemStack[max_X][max_Y];
		curItem_X = 0;
		curItem_Y = 0;
		size = 32;
		padding = size;
		shr = new ShapeRenderer();
		visible = false;
	}
	
	public void render(SpriteBatch sb)
	{
		Gdx.gl.glEnable(GL20.GL_BLEND);
		
		shr.begin(ShapeType.Filled);
		shr.setColor(0.0f, 0.0f, 0.0f, 0.7f);
		shr.rect(Game.WIDTH/2.0f, 0.0f, Game.WIDTH/2.0f, Game.HEIGHT);
		
		shr.setColor(0.8f, 0.4f, 0.0f, 0.7f);
		shr.rect(Game.WIDTH/2.0f +  padding + curItem_X * size, 
				Game.HEIGHT/5.0f +  padding + (max_Y - curItem_Y - 1)* size, 
				size, 
				size);
		shr.end();
		
		shr.begin(ShapeType.Line);
		shr.setColor(1.0f, 1.0f, 1.0f, 0.5f);
		for (int y = 0; y < max_Y; y++)
		{
			for (int x = 0; x < max_X; x++)
			{
				shr.rect(Game.WIDTH/2.0f + padding + x * size, 
						Game.HEIGHT/5.0f + + padding + (max_Y - y - 1) * size, 
						size, 
						size);
			}
		}
		shr.end();
		
		Gdx.gl.glDisable(GL20.GL_BLEND);
	}
	
	public boolean update(float dt)
	{
		if(visible)
		{
			if(GIP.isPressed(Input.Keys.UP))
			{
				curItem_Y--;
				
				if (curItem_Y < 0)
					curItem_Y = max_Y - 1;
			}
			if(GIP.isPressed(Input.Keys.DOWN))
			{
				curItem_Y++;
				
				if (curItem_Y > max_Y - 1)
					curItem_Y = 0;
			}
			if(GIP.isPressed(Input.Keys.LEFT))
			{
				curItem_X--;
			
				if (curItem_X < 0)
					curItem_X = max_X - 1;
			}
			if(GIP.isPressed(Input.Keys.RIGHT))
			{
				curItem_X++;
				
				if (curItem_X > max_X - 1)
					curItem_X = 0;
			}
			
			if(GIP.isPressed(Input.Keys.E))
			{
				System.out.println("HERE");
				visible = false;
				GIP.updateKey(Input.Keys.E);
			}
		}
		return visible;
	}
	
	
}
