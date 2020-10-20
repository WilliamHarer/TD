import jig.ResourceManager;
import jig.Vector;
import org.lwjgl.Sys;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;

public class OrkFortressPlayingState extends BasicGameState{
    public boolean mCheck=false;
    public Map levelMap;
    public Wave waves;
    public boolean towerDefense=true;
    ArrayList<Monster> RTSmonsters=new ArrayList<Monster>(10);
    ArrayList<OrkLabor> laborers=new ArrayList<OrkLabor>(10);
    ArrayList<OrkSoldier> soldiers=new ArrayList<OrkSoldier>(10);
    //turrets = new ArrayList<Turret>
    @Override
    public void init(GameContainer container, StateBasedGame game)
            throws SlickException{
        OrkFortressGame og=(OrkFortressGame)game;
        levelMap=new Map(og.ScreenWidth,og.ScreenHeight);
        levelMap.setEnter(0,4);
        levelMap.setExit(14,11);
        levelMap.digPath(4,0,5,4);
        levelMap.digPath(4,3,7,4);
        levelMap.digPath(7,3,8,9);
        levelMap.digPath(8,8,14,9);
        levelMap.digPath(14,8,15,11);
        levelMap.setPath(levelMap.paths);
        waves=new Wave(5,20);
        /*for(int i=0;i<20;i++) {
            og.monsters.add(new Monster(0, (4*40)+20, (float) .1, 0));
        }
        /*for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                if(levelMap.paths[i][j]!=-1) {
                    System.out.println(levelMap.paths[i][j] + ":" + i + ":" + j);
                }
            }
        }*/
    }
    @Override
    public void enter(GameContainer container,StateBasedGame game) {container.setSoundOn(true);}

    @Override
    public void render(GameContainer container, StateBasedGame game,
                       Graphics g) throws SlickException{
        OrkFortressGame og= (OrkFortressGame)game;
        Input input=container.getInput();
        if(towerDefense) {
            g.drawImage(ResourceManager.getImage(OrkFortressGame.MAP_DEBUG_IMG_RSC), 0, 0);
            g.drawImage(ResourceManager.getImage(OrkFortressGame.FROSTTURRET_IMG_RSC), 747, 40);
            g.drawImage(ResourceManager.getImage(OrkFortressGame.TOPBAR_IMG_RSC), 0, 0);
            g.drawImage(ResourceManager.getImage(OrkFortressGame.SIDEBAR_IMG_RSC), 641, 0);
            g.drawImage(ResourceManager.getImage(OrkFortressGame.BOMBTURRET_IMG_RSC), 694, 40);
            g.drawImage(ResourceManager.getImage(OrkFortressGame.LIGHTNINGTURRET_IMG_RSC), 641, 40);
            //g.drawImage(ResourceManager.getImage(OrkFortressGame.));
            for(int i=0; i<16;i++){
                int lineHeight = og.ScreenHeight - ((i) * og.ScreenHeight / 15);
                int LineWidth = og.ScreenWidth - ((i) * og.ScreenWidth / 16);
                g.drawLine(LineWidth,0, LineWidth,og.ScreenHeight);
                g.drawLine(0, lineHeight,og.ScreenWidth, lineHeight);
                if(i!=15){
                    g.drawLine(0, lineHeight,og.ScreenWidth, lineHeight);
                }
            }
            for (int i = 0; i < og.monsters.size(); i++) {
                og.monsters.get(i).render(g);
                /*for(int j=0;j<og.turrets.size();j++){
                    g.drawLine(og.monsters.get(i).getX(),og.monsters.get(i).getY(),og.turrets.get(j).getX(),og.turrets.get(j).getY());
                }*/
            }
            for (int i = 0; i < og.turrets.size(); i++) {
                if (og.turrets.get(i).target != null) {
                    g.drawLine(og.turrets.get(i).target.getX(), og.turrets.get(i).target.getY(), og.turrets.get(i).getX(), og.turrets.get(i).getY());
                }
            }
            for (int i = 0; i < og.turrets.size(); i++) {
                og.turrets.get(i).render(g);
            }
            if (mCheck) {
                g.drawImage(ResourceManager.getImage(OrkFortressGame.TURRET_IMG_RSC), 53 * ((int) (input.getMouseX()) / 53), 40 * ((int) (input.getMouseY()) / 40));
            }
        }
        else{
            g.drawImage(ResourceManager.getImage(OrkFortressGame.ORK_FORTRESS_MAP_RSC), 0, 0);
            g.drawImage(ResourceManager.getImage(OrkFortressGame.TOPBAR_IMG_RSC), 0, 0);
            g.drawImage(ResourceManager.getImage(OrkFortressGame.SIDEBAR_IMG_RSC), 641, 0);
            for (int i = 0; i < RTSmonsters.size(); i++) {
                RTSmonsters.get(i).render(g);
                /*for(int j=0;j<og.turrets.size();j++){
                    g.drawLine(og.monsters.get(i).getX(),og.monsters.get(i).getY(),og.turrets.get(j).getX(),og.turrets.get(j).getY());
                }*/
            }
            for (int i=0; i<laborers.size();i++){
                laborers.get(i).render(g);
            }
            for(int i=0; i<16;i++){
                int lineHeight = og.ScreenHeight - ((i) * og.ScreenHeight / 15);
                int LineWidth = og.ScreenWidth - ((i) * og.ScreenWidth / 16);
                g.drawLine(LineWidth,0, LineWidth,og.ScreenHeight);
                g.drawLine(0, lineHeight,og.ScreenWidth, lineHeight);
                if(i!=15){
                    g.drawLine(0, lineHeight,og.ScreenWidth, lineHeight);
                }
            }

        }
    }
    public int buttonClick(float x, float y, int ScreenHeight, int ScreenWidth){
        int yRow = (int) (y/(ScreenHeight/15));
        int xCol= (int) (x/(ScreenWidth/15));
        //buttons on row 1, and col 12/13/14
        System.out.println(yRow+":"+xCol);
        if(yRow==0&&xCol==0){
            return 10;
        }
        if(yRow==1 && xCol==12){
            return 1;
        }
        return -1;
    }
    @Override
    public void update(GameContainer container, StateBasedGame game,
                       int delta) throws SlickException {
        OrkFortressGame og = (OrkFortressGame)game;
        Input input=container.getInput();
        /*for(int i=0; i<og.turrets.size();i++){

        }*/
        //TowerDefense UI recordings
        if(towerDefense) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                if (buttonClick(input.getMouseX(), input.getMouseY(), og.ScreenHeight, og.ScreenWidth) == 10) {
                    towerDefense = !towerDefense;
                }
                if (buttonClick(input.getMouseX(), input.getMouseY(), og.ScreenHeight, og.ScreenWidth) == 1) {
                    mCheck = !mCheck;
                } else if (mCheck) {
                    og.turrets.add(new Turret(53 * ((int) (input.getMouseX()) / 53), 40 * ((int) (input.getMouseY()) / 40)));
                    mCheck = !mCheck;
                }
            }
        }
        //RTS UI recordings
        else{
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                if (buttonClick(input.getMouseX(), input.getMouseY(), og.ScreenHeight, og.ScreenWidth) == 10) {
                    towerDefense = !towerDefense;
                }
                if (buttonClick(input.getMouseX(), input.getMouseY(), og.ScreenHeight, og.ScreenWidth) == 1) {
                    laborers.add(new OrkLabor(400,300,0,0));
                }
                if (buttonClick(input.getMouseX(), input.getMouseY(), og.ScreenHeight, og.ScreenWidth) == 2) {
                    //spawn miner
                }
                if (buttonClick(input.getMouseX(), input.getMouseY(), og.ScreenHeight, og.ScreenWidth) == 3) {
                    //spawn soldier
                }

            }
        }
        if(waves.timer==0){
            //System.out.println("workin");
            if(waves.count>0){
                og.monsters.add(waves.spawn(0, (4*40)+20, (float) .1, 0));
                waves.resetTimer();
            }
        }
        /*if wave time==0:
        *   if wave count >0
        *       decrease count
        *               //use delta which is the # in ms in betweeen each update
        *       spawn Monster
        *       reset timer*/
        for(int i=0;i<og.monsters.size();i++){
            for(int j=0;j<og.turrets.size();j++){
                float y=og.turrets.get(j).getY()-og.monsters.get(i).getY();
                float x=og.turrets.get(j).getX()-og.monsters.get(i).getX();
                if(Math.sqrt((y*y)+(x*x))<og.turrets.get(j).range){
                    og.turrets.get(j).Shoot(og.monsters.get(i));
                }
                else{
                    if(og.turrets.get(j).target==og.monsters.get(i)){
                        og.turrets.get(j).Shoot(null);
                    }
                }
            }
        }
        for(int i=0;i<og.monsters.size();i++){
            int col= (int) ((og.monsters.get(i).getX())/(og.ScreenWidth/15));
            int row=(int) (og.monsters.get(i).getY()/(og.ScreenHeight/15));
            System.out.println(row+":::"+col);
            System.out.println(levelMap.exitCol+"|||"+ levelMap.exitRow);
            if(col==levelMap.exitCol&&row==levelMap.exitRow){
                //System.out.println(levelMap.exitCol+":"+ levelMap.enterCol);
                og.monsters.get(i).setX(6*(og.ScreenWidth/16));
                og.monsters.get(i).setY(3*(og.ScreenHeight/15));
                og.monsters.get(i).setVelocity(new Vector(0,(float).1));
                RTSmonsters.add(og.monsters.get(i));
                og.monsters.remove(i);
                continue;
            }
            int[][] directions=new int[4][2];
            directions[0][0]=row;
            directions[0][1]=col-1;
            directions[1][0]=row-1;
            directions[1][1]=col;
            directions[2][0]=row+1;
            directions[2][1]=col;
            directions[3][0]=row;
            directions[3][1]=col+1;
            int min=1000;
            int wall=-1;
            int direction=4;
            //System.out.println(row+":"+col);
            /*if(row==4 && col==2){
                for(int j=0;j<4;j++){
                    System.out.println(directions[j][0]+":"+directions[j][1]);
                    System.out.println(levelMap.paths[directions[j][0]][directions[j][1]]);
                }

            }*/
            for(int j=0;j<4;j++){
                if(directions[j][0]>0&&directions[j][0]< levelMap.paths.length &&
                        directions[j][1]>0 && directions[j][1]<levelMap.paths[0].length) {
                    //System.out.println(levelMap.paths[directions[j][0]][directions[j][1]]);
                    if (levelMap.paths[directions[j][0]][directions[j][1]] < min && levelMap.paths[directions[j][0]][directions[j][1]]!=wall) {
                        min = levelMap.paths[directions[j][0]][directions[j][1]];
                        //System.out.println(levelMap.paths[directions[j][0]][directions[j][1]]);
                        //System.out.println(j);
                        //System.out.println(":"+directions[j][0]+":"+directions[j][1]);
                        direction = j;
                    }
                    //System.out.println(direction);
                }
            }
            if(og.monsters.get(i).getDirection()!=direction){
                if(row>0&&col>0) {
                    og.monsters.get(i).setX(((og.ScreenWidth/15)*col)+27);
                    og.monsters.get(i).setY(((og.ScreenHeight/15)*row)+20);
                }
            }
            og.monsters.get(i).turn(direction);
            og.monsters.get(i).update(delta);
        }
        for(int i=0;i<RTSmonsters.size();i++){
            for(int j=i*(laborers.size()/RTSmonsters.size());j<((laborers.size()/RTSmonsters.size())+(i*(laborers.size()/RTSmonsters.size())));j++){
                if(laborers.get(i).haveTarget()){
                    continue;
                }
                RTSmonsters.get(i).setVelocity(new Vector(0,0));
                laborers.get(i).setTarget(RTSmonsters.get(i));
                float xDist=(RTSmonsters.get(i).getX()-laborers.get(i).getX());
                float yDist=(RTSmonsters.get(i).getY()-(laborers.get(i).getY()));
                float vx=(float).5/xDist;
                float vy=(float).5/yDist;
                if(Math.abs(xDist)<1){
                    vx=0;
                }
                if(Math.abs(yDist)<1){
                    vy=0;
                }
                laborers.get(i).setVelocity(new Vector(vx,vy));
            }
        }
        for(int i=0;i<laborers.size();i++){
            if(laborers.get(i).haveTarget()) {
                float xDist = (laborers.get(i).getTarget().getX() - laborers.get(i).getX());
                float yDist = (laborers.get(i).getTarget().getY() - (laborers.get(i).getY()));
                if((Math.abs(xDist)+Math.abs(yDist))<20){
                    laborers.get(i).getTarget().setHealth(laborers.get(i).getTarget().getHealth()-laborers.get(i).getDamage());
                }
                if(laborers.get(i).getTarget().getHealth()<=0){
                    laborers.get(i).setTarget(null);
                }
            }else{
                laborers.get(i).setVelocity(new Vector(0,0));
            }
            laborers.get(i).update(delta);
        }
        for(int i=0;i<RTSmonsters.size();i++){
            if(RTSmonsters.get(i).getHealth()<0){
                RTSmonsters.get(i).removeImage(ResourceManager.getImage(OrkFortressGame.SLIME_IMG_RSC));
                RTSmonsters.remove(i);
                continue;
            }
            RTSmonsters.get(i).update(delta);
        }
        waves.update(delta);
        //System.out.println(waves.timer);
    }
    @Override
    public int getID() {return OrkFortressGame.PLAYINGSTATE;}
}
