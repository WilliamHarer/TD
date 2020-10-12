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
        for(int i=0; i<15;i++){
            g.drawLine(0,og.ScreenHeight-((i)* og.ScreenHeight/15),og.ScreenWidth,og.ScreenHeight-((i)* og.ScreenHeight/15));
            g.drawLine(og.ScreenWidth-((i)* og.ScreenWidth/15),0,og.ScreenWidth-((i)* og.ScreenWidth/15),og.ScreenHeight);
        }
    }
    @Override
    public void update(GameContainer container, StateBasedGame game,
                       int delta) throws SlickException {

    }
    @Override
    public int getID() {return OrkFortressGame.STARTSTATE;}
}
