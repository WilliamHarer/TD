import jig.Entity;
import jig.ResourceManager;
import jig.Vector;

public class Monster extends Entity {
    private Vector velocity;
    private int health;
    private int direction;
    public Monster(final float x, final float y, final float vx, final float vy){
        super(x,y);
        addImageWithBoundingBox(ResourceManager.getImage(OrkFortressGame.SLIME_IMG_RSC));
        velocity = new Vector(vx,vy);
    }
    public void setHealth(int hp){ health=hp;}
    public int getHealth(){return health;}
    public void setVelocity(final Vector v){ velocity=v;}
    public Vector getVelocity(){return velocity;}
    public void update(final int delta) {
        translate(velocity.scale(delta));
    }
    public void setDirection(int dir){
        direction=dir;
    }
    public int getDirection(){return direction;}
    public void turn(int direction){
        setDirection(direction);
        if(direction==0){
            turnLeft();
        }
        if(direction==1){
            turnUp();
        }
        if(direction==2){
            turnDown();
        }
        if(direction==3){
            turnRight();
        }
    }
    public void turnLeft(){
        velocity=new Vector((float) -.1,0);
    }
    public void turnRight(){
        velocity=new Vector((float) .1,0);
    }
    public void turnDown(){
        velocity=new Vector(0,(float).1);
    }
    public void turnUp(){
        velocity=new Vector(0,(float)-.1);

    }

}
