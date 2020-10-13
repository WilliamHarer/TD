import jig.ResourceManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;

public class OrkFortressPlayingState extends BasicGameState{
    public boolean mCheck=false;
    //turrets = new ArrayList<Turret>
    @Override
    public void init(GameContainer container, StateBasedGame game)
            throws SlickException{

    }
    @Override
    public void enter(GameContainer container,StateBasedGame game) {container.setSoundOn(true);}

    @Override
    public void render(GameContainer container, StateBasedGame game,
                       Graphics g) throws SlickException{
        OrkFortressGame og= (OrkFortressGame)game;
        Input input=container.getInput();
        g.drawImage(ResourceManager.getImage(OrkFortressGame.TOPBAR_IMG_RSC),0,0);
        g.drawImage(ResourceManager.getImage(OrkFortressGame.SIDEBAR_IMG_RSC),641,0);
        g.drawImage(ResourceManager.getImage(OrkFortressGame.FROSTTURRET_IMG_RSC),747,40);
        g.drawImage(ResourceManager.getImage(OrkFortressGame.BOMBTURRET_IMG_RSC),694,40);
        g.drawImage(ResourceManager.getImage(OrkFortressGame.LIGHTNINGTURRET_IMG_RSC),641,40);
        //g.drawImage(ResourceManager.getImage(OrkFortressGame.));
        for(int i=0; i<15;i++){
            int lineHeight = og.ScreenHeight - ((i) * og.ScreenHeight / 15);
            int LineWidth = og.ScreenWidth - ((i) * og.ScreenWidth / 15);
            g.drawLine(0, lineHeight,og.ScreenWidth, lineHeight);
            g.drawLine(LineWidth,0, LineWidth,og.ScreenHeight);
        }
        for(int i =0; i<og.turrets.size();i++){
            og.turrets.get(i).render(g);
        }
        if(mCheck){
            g.drawImage(ResourceManager.getImage(OrkFortressGame.TURRET_IMG_RSC),53*((int)(input.getMouseX())/53), 40*((int)(input.getMouseY())/40));
        }
    }
    @Override
    public void update(GameContainer container, StateBasedGame game,
                       int delta) throws SlickException {
        OrkFortressGame og = (OrkFortressGame)game;
        Input input=container.getInput();
        if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
            if(mCheck){
                og.turrets.add(new Turret(53*((int)(input.getMouseX())/53),40*((int)(input.getMouseY())/40)));
            }
            mCheck= !mCheck;
        }
    }
    @Override
    public int getID() {return OrkFortressGame.PLAYINGSTATE;}
}
