import jig.Entity;
import jig.ResourceManager;

public class Turret extends Entity {
    int range=26;
    public Turret(final float x, final float y){
        super(x+26,y+20);
        addImageWithBoundingBox(ResourceManager
                .getImage(OrkFortressGame.TURRET_IMG_RSC));

    }
}
