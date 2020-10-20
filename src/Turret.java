import jig.Entity;
import jig.ResourceManager;

public class Turret extends Entity {
    //TowerType is a constant representing the type of turret it is, 0 for default, 1 for lightning, 2 for frost, 3 for aoe
    int range=79;
    Monster target;
    int damage=10;
    int fireRate=(int) 1.2*1000;
    int timeToFire=0;
    int towerType=0;
    public Turret(final float x, final float y) {
        super(x + 26, y + 20);
        addImageWithBoundingBox(ResourceManager
                .getImage(OrkFortressGame.TURRET_IMG_RSC));

    }
    public int getFireRate(){return fireRate;}
    public int getTimeToFire(){return timeToFire;}
    public void setFireRate(int f){fireRate=f;}
    public void setTimeToFire(int delta){
        timeToFire = timeToFire - delta;
    }
    public void reload(){
        timeToFire=fireRate;
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
