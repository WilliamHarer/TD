import jig.Entity;
import jig.ResourceManager;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import java.util.ArrayList;


public class OrkFortressGame extends StateBasedGame {
    public final int ScreenWidth;
    public final int ScreenHeight;
    public static final int STARTSTATE=0;

    public OrkFortressGame(String title, int width, int height) {
        super(title);
        ScreenHeight=height;
        ScreenWidth=width;
        Entity.setCoarseGrainedCollisionBoundary(Entity.AABB);
    }
    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        addState(new OrkFortressStartUp());

    }
    public static void main(String[] arges) {
        AppGameContainer app;
        try {
            app = new AppGameContainer(new OrkFortressGame("Ork Fortress", 800,600));
            app.setDisplayMode(800,600,false);
            app.setVSync(true);
            app.start();

        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
