import jig.ResourceManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import javax.swing.plaf.nimbus.State;

public class OrkFortressStartUp extends BasicGameState{
    @Override
    public void init(GameContainer container, StateBasedGame game)
        throws SlickException{

    }
    @Override
    public void enter(GameContainer container,StateBasedGame game) {container.setSoundOn(false);}

    @Override
    public void render(GameContainer container, StateBasedGame game,
                       Graphics g) throws SlickException{
        OrkFortressGame og= (OrkFortressGame)game;
        for(int i=0; i<16;i++){
            int lineHeight = og.ScreenHeight - ((i) * og.ScreenHeight / 15);
            int LineWidth = og.ScreenWidth - ((i) * og.ScreenWidth / 16);
            g.drawLine(LineWidth,0, LineWidth,og.ScreenHeight);
            g.drawLine(0, lineHeight,og.ScreenWidth, lineHeight);
            if(i!=15){
                g.drawLine(0, lineHeight,og.ScreenWidth, lineHeight);
            }
        }
    }
    @Override
    public void update(GameContainer container, StateBasedGame game,
                       int delta) throws SlickException {
        Input input = container.getInput();
        OrkFortressGame og=(OrkFortressGame)game;
        if(input.isKeyDown(Input.KEY_ENTER)){
            og.enterState(OrkFortressGame.PLAYINGSTATE);
        }

    }
    @Override
    public int getID() {return OrkFortressGame.STARTSTATE;}
}
