import jig.Entity;
import jig.ResourceManager;

public class Turret extends Entity {
    int range=79;
    Monster target;
    int damage=10;
    public Turret(final float x, final float y) {
        super(x + 26, y + 20);
        addImageWithBoundingBox(ResourceManager
                .getImage(OrkFortressGame.TURRET_IMG_RSC));

    }
    public int getDamage(){return damage;}
    public void setDamage(int d){damage=d;}
    public Monster getTarget(){return target;}
    public void setRange(int r){range=r;}
    public int getRange(){return range;}
    public void  Shoot(Monster t){
        target=t;
    }
}
