import jig.ResourceManager;

public class LightningTurret extends Turret{
    public LightningTurret(float x, float y) {
        super(x, y);
        addImageWithBoundingBox(ResourceManager.getImage(OrkFortressGame.LIGHTNINGTURRET_IMG_RSC));
        setRange(100);
        setDamage(1);
        setFireRate(0);
    }
}
