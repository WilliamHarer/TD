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
    public static final int PLAYINGSTATE=1;
    public static final int GAMEOVERSTATE=2;

    public static final String TURRET_IMG_RSC = "resources/FrostTower.png";
    public static final String FROSTTURRET_IMG_RSC="resources/FrostPlaceholder.png";
    public static final String BOMBTURRET_IMG_RSC="resources/BombPlaceholder.png";
    public static final String LIGHTNINGTURRET_IMG_RSC="resources/LightningPlaceHolder.png";
    public static final String SIDEBAR_IMG_RSC="resources/SideBarPlaceholder.png";
    public static final String TOPBAR_IMG_RSC="resources/TopBarPlaceHolder.png";
    ArrayList<Turret> turrets;

    public OrkFortressGame(String title, int width, int height) {
        super(title);
        ScreenHeight=height;
        ScreenWidth=width;
        Entity.setCoarseGrainedCollisionBoundary(Entity.AABB);
        turrets=new ArrayList<Turret>(10);
    }
    @Override
    public void initStatesList(GameContainer container) {
        addState(new OrkFortressStartUp());
        addState(new OrkFortressPlayingState());
        addState(new OrkFortressGameOverState());

    }
    public static void main(String[] args) {
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
