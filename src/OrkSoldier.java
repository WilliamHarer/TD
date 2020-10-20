import jig.ResourceManager;

public class OrkSoldier extends Monster{
    public OrkSoldier(float x, float y, float vx, float vy) {
        super(x, y, vx, vy);
        addImageWithBoundingBox(ResourceManager.getImage(OrkFortressGame.ORK_LABOR_WOOD_RSC));
    }
}
