import jig.Entity;
import jig.ResourceManager;
import jig.Vector;

public class Monster extends Entity {
    private Vector velocity;
    private int health;
    public Monster(final float x, final float y, final float vx, final float vy){
        super(x,y);
        addImageWithBoundingBox(ResourceManager.getImage(OrkFortressGame.SLIME_IMG_RSC));
        velocity = new Vector(vx,vy);
    }
    public void setHealth(int hp){ health=hp; }
    public int getHealth(){return health;}
    public void setVelocity(final Vector v){ velocity=v;}
    public Vector getVelocity(){return velocity;}
    public void update(final int delta) {
        translate(velocity.scale(delta));
    }

}
