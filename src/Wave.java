public class Wave {
    public int timer=0;
    public int count=0;
    public Wave(int time,int numberOfMonsters){
        timer=time;
        count=numberOfMonsters;
    }
    public Monster spawn(float x,float y,float vx, float vy){
        Monster newMonster=new Monster(x,y,vx,vy);

        return newMonster;
    }
    //Update????
}
