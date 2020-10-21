import jig.ResourceManager;

import java.util.ArrayList;

public class AoeTurret extends Turret{
    public ArrayList<Monster> targets=new ArrayList<Monster>(10);
    public int range=50;
    public AoeTurret(float x, float y) {
        super(x, y);
        addImageWithBoundingBox(ResourceManager.getImage(OrkFortressGame.BOMBTURRET_IMG_RSC));
        setRange(26);
        setDamage(10);
        setFireRate(1200);
    }
    @Override
    public void Shoot(Monster t){
        targets.add(t);
    }
    public ArrayList<Monster> getTargets(){
        return targets;
    }
}
