import jig.ResourceManager;

public class AoeTurret extends Turret{
    public AoeTurret(float x, float y) {
        super(x, y);
        addImageWithBoundingBox(ResourceManager.getImage(OrkFortressGame.BOMBTURRET_IMG_RSC));
        setRange(26);
        setDamage(10);
        setFireRate(1200);
    }
}
