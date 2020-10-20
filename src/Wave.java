public class Wave {
    public int timer=0;
    public int spawnRate=0;
    public int count=0;
    public float enterX=0;
    public float enterY=0;
    public float speedX=0;
    public float speedY=0;
    public Wave(int time,int numberOfMonsters){
        timer=time*1000;
        spawnRate=time*1000;
        count=numberOfMonsters;
    }
    public Monster spawn(float x,float y,float vx, float vy){
        Monster newMonster=new Monster(x,y,vx,vy);
        newMonster.setDirection(1);
        return newMonster;
    }
    public void update(int delta){
        timer=timer-delta;
        //System.out.println(timer);
        if(timer<0){
            timer=0;
        }
    }
    public void resetTimer(){
        timer=spawnRate;
    }
    //Update????
}
