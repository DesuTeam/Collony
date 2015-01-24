/**
 * Intro.java
 */
package collony.gamestate.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import collony.gamestate.GameState;
import collony.gamestate.GameStateManager;
import collony.gamestate.GameStateManager.STATES;
import collony.main.Game;
import collony.util.GIP;

/**
 * @author maximser
 * @version 1.0
 * @since 1.5
 */
public class Intro extends GameState {
	private long time = 5;//On screen in seconds
	private SpriteBatch sb;
	private OrthographicCamera cam;
	private BitmapFont font;
	private int fontSize = 25;
	long curr;
	boolean work = false;
	private int i=1; 
	private String text [ ]= {"Once upon a time","in darkness of space",
			"the man challenged himself..."};
	/**
	 * @param gsm
	 */
	public Intro(GameStateManager gsm) {
		super(gsm);
		init();

	}

	/**
	 * Start
	 */
	public void init() {
		time*=1000;
		FreeTypeFontGenerator ftfg = new FreeTypeFontGenerator(Gdx.files.internal("menustate/a_Albionic.ttf"));
		font = ftfg.generateFont(this.fontSize);
		font.setColor(Color.YELLOW);
		ftfg.dispose();
		font.setColor(Color.YELLOW);
		sb = new SpriteBatch();
		cam = new OrthographicCamera(Game.WIDTH, Game.HEIGHT);
		cam.setToOrtho(false, Game.WIDTH, Game.HEIGHT);
		cam.update();		
		gsm.setState(STATES.MENU);
		
	}
	
	@Override
	public void update(float dt) {
		if(!work) {curr = System.currentTimeMillis();work = true;}
		if((System.currentTimeMillis() - curr)>time) gsm.setState(STATES.MENU);
		try {
				Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(GIP.isPressed(Input.Keys.ENTER)) gsm.setState(STATES.MENU);
		
		
		i+=2;
		
		
	}

	@Override
	public void render() {
		sb.setProjectionMatrix(cam.combined);
		sb.begin();
		for(int j = 0 ;j<this.text.length;j++){
			font.setScale((float) (1./(i/800.+1)*(j+1)));
			font.draw(sb, this.text[j],Game.WIDTH/4-j*this.fontSize, i/2-j*this.fontSize);	
		}
		
		sb.end();
		
	}

	@Override
	public void dispose() {
		i=1;
		work = false;
	}

	@Override
	public void handlInput() {
		// TODO Auto-generated method stub
		
	}

}
