package collony.items;

import java.util.Map;

import com.badlogic.gdx.graphics.Texture;

public abstract class Item 
{

	protected String name;
	protected int ID;
	protected Texture icon;
	protected Map<String, Object> properties;
	
	protected Item(String name,Map<String,Object> prop)
	{
		this.name = name;
		properties = prop;
	}
}
