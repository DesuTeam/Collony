package collony.items;

import com.badlogic.gdx.graphics.Texture;

public abstract class Item 
{
	protected String name;
	protected int ID;
	protected Texture icon;
	protected Item instance;
	
	protected Item(){}
	
	public String getName() 
	{
		return name;
	}

	public int getID() 
	{
		return ID;
	}

	public Texture getIcon() 
	{
		return icon;
	}

	public abstract Item getInstance();
	
}
