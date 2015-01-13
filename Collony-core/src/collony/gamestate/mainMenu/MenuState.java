package collony.gamestate.mainMenu;

import collony.gamestate.GameState;
import collony.gamestate.GameStateManager;
import collony.gamestate.GameStateManager.STATES;
import collony.main.Game;
import collony.util.GIP;
import collony.util.SoundBox;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class MenuState extends GameState
{
	private SpriteBatch sb;
	private OrthographicCamera cam;
	
	private BitmapFont titleFont;
	private BitmapFont font;
	
	private final String title = "COLLONY";
	private String[] menuItems;
	private int currentItem;
	
	private Texture bg;
	
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
				Gdx.files.internal("menustate/28_Days_Later_Cyr.ttf")
				);
		
		titleFont = ftfg.generateFont(64);
		titleFont.setColor(0.9f, 0.0f, 0.0f, 0.8f);
		ftfg.dispose();
		
		ftfg = new FreeTypeFontGenerator(Gdx.files.internal("menustate/a_Albionic.ttf"));
		font = ftfg.generateFont(32);
		ftfg.dispose();
		
		menuItems = new String[] {"Play", "Test","Quit"};
		currentItem = 0;
		
		sb = new SpriteBatch();
		
		cam = new OrthographicCamera(Game.WIDTH, Game.HEIGHT);
		cam.setToOrtho(false, Game.WIDTH, Game.HEIGHT);
		cam.update();
		
		bg = new Texture(Gdx.files.internal("menustate/bg.jpg"));
	}

	@Override
	public void handlInput() 
	{
		if(GIP.isPressed(Input.Keys.UP))
		{
			SoundBox.play("menubut");
			
			currentItem--;
			if(currentItem < 0)
				currentItem = menuItems.length - 1;
		}
		if(GIP.isPressed(Input.Keys.DOWN))
		{
			SoundBox.play("menubut");
			currentItem++;
			if(currentItem > menuItems.length - 1)
				currentItem = 0;
		}
		if(GIP.isPressed(Input.Keys.ENTER))
		{
			SoundBox.play("select");
			switch(currentItem)
			{
			case 0:
				//gsm.setState(STATES.PLAY);
				break;
			case 1:
				gsm.setState(STATES.TEST);
				break;
			case 2:
				Gdx.app.exit();
				break;
			}
		}	
	}
	
	@Override
	public void update(float dt)
	{
		handlInput();
	}

	@Override
	public void render() 
	{
		sb.setProjectionMatrix(cam.combined);
		
		sb.begin();
		
			sb.draw(bg, 0, 0);
			float titlewidth = titleFont.getBounds(title).width;
			titleFont.draw(sb, title, (Game.WIDTH - titlewidth)/2, Game.HEIGHT - 100);
			
			for(int i = 0; i < menuItems.length; i++)
			{
				if (i == currentItem)
					font.setColor(0.3f, 0.8f, 0.0f, 0.6f);
				else
					font.setColor(0.8f, 0.3f, 0.0f, 0.6f);
				
				font.draw(sb, menuItems[i], Game.WIDTH/2 - 200, Game.HEIGHT/2 - 40*i);
			}
			
		sb.end();
	}

	@Override
	public void dispose() 
	{
		bg.dispose();
		sb.dispose();
		titleFont.dispose();
		font.dispose();
	}

	
}
