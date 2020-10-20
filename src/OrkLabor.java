import jig.ResourceManager;
import jig.Vector;

public class OrkLabor extends Monster{
    private Vector velocity;
    private Monster target;
    public OrkLabor(float x, float y, float vx, float vy) {
        super(x, y,vx,vy);
        setX(x);
        setY(y);
        addImageWithBoundingBox(ResourceManager.getImage(OrkFortressGame.ORK_LABOR_WOOD_RSC));
    }
    public void setTarget(Monster t){target=t;}
    public Monster getTarget(){return target;}
    public boolean haveTarget(){
        if(getTarget()!=null){
            return true;
        }
        return false;
    }
}
