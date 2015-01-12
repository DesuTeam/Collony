package collony.gamestate.mainMenu;

import collony.gamestate.GameState;
import collony.gamestate.GameStateManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.*;

public class MenuState extends GameState{

	private BitmapFont titleFont;
	private BitmapFont font;
	private SpriteBatch sb;
	
	private final String name = "11 SEPTEMBER";
	private String[] menuItems;
	
	private int currentItem;
	
	public MenuState(GameStateManager gsm)
	{
		super(gsm);
		init();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void init()
	{
		FreeTypeFontGenerator ftfg = new FreeTypeFontGenerator(
				Gdx.files.internal("fonts/28_Days_Later_Cyr.ttf")
				);
		
		titleFont = ftfg.generateFont(64);
		titleFont.setColor(0.5f, 0.0f, 0.1f, 0.5f);
		
		
		font = ftfg.generateFont(32);
		font.setColor(0.5f, 0.0f, 0.5f, 0.3f);
		
		menuItems = new String[] {"Play", "Test","Quit"};
		currentItem = 0;
		
		sb = new SpriteBatch();
	}

	@Override
	public void update(float dt)
	{
		
	}

	@Override
	public void render() 
	{
		
	}

	@Override
	public void dispose() 
	{
		
	}
}
