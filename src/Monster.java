import jig.Entity;
import jig.Vector;

public class Monster extends Entity {
    private Vector velocity;
    public Monster(final float x, final float y, final float vx, final float vy){
        super(x,y);
        velocity = new Vector(vx,vy);
    }

    public void setVelocity(final Vector v){ velocity=v;}

    public Vector getVelocity(){return velocity;}
    
}
