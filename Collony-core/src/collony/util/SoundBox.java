package collony.util;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.audio.Sound;

public class SoundBox 
{
	private static Map<String, Sound>sounds;
	
	static
	{
		sounds = new HashMap<String,Sound>();
	}
	
	/** Put sound into SoundBox*/
	public static void put(String key , Sound sound)
	{
		if(sound == null)
			throw new IllegalArgumentException("Sound is null");
		if(key == null)
			throw new IllegalArgumentException("Key is null");
		if(sounds.containsKey(key))
			throw new IllegalArgumentException("Key \""+key+"\" already added!");
		sounds.put(key, sound);
	}
	
	public static void play(String key)
	{
		if(!sounds.containsKey(key))
			throw new IllegalArgumentException("Key \""+ key +"\" not found!");
		sounds.get(key).play();
	}
	public static void stop(String key)
	{
		if(!sounds.containsKey(key))
			throw new IllegalArgumentException("Key \""+ key +"\" not found!");
		sounds.get(key).stop();
	}
	
}
