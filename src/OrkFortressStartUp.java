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

    }
    @Override
    public void update(GameContainer container, StateBasedGame game,
                       int delta) throws SlickException {

    }
    @Override
    public int getID() {return OrkFortressGame.STARTSTATE;}
}
