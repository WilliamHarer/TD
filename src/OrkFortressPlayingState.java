import jig.ResourceManager;
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
        for(int i=0;i<20;i++) {
            og.monsters.add(new Monster(0, (4*40)+20, (float) .1, 0));
        }
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                //System.out.println(levelMap.paths[i][j]+":"+i+":"+j);
            }
        }
    }
    @Override
    public void enter(GameContainer container,StateBasedGame game) {container.setSoundOn(true);}

    @Override
    public void render(GameContainer container, StateBasedGame game,
                       Graphics g) throws SlickException{
        OrkFortressGame og= (OrkFortressGame)game;
        Input input=container.getInput();
        g.drawImage(ResourceManager.getImage(OrkFortressGame.MAP_DEBUG_IMG_RSC),0,0);
        g.drawImage(ResourceManager.getImage(OrkFortressGame.TOPBAR_IMG_RSC),0,0);
        g.drawImage(ResourceManager.getImage(OrkFortressGame.SIDEBAR_IMG_RSC),641,0);
        g.drawImage(ResourceManager.getImage(OrkFortressGame.FROSTTURRET_IMG_RSC),747,40);
        g.drawImage(ResourceManager.getImage(OrkFortressGame.BOMBTURRET_IMG_RSC),694,40);
        g.drawImage(ResourceManager.getImage(OrkFortressGame.LIGHTNINGTURRET_IMG_RSC),641,40);
        //g.drawImage(ResourceManager.getImage(OrkFortressGame.));
        for(int i=0; i<15;i++){
            int lineHeight = og.ScreenHeight - ((i) * og.ScreenHeight / 15);
            int LineWidth = og.ScreenWidth - ((i) * og.ScreenWidth / 15);
            g.drawLine(0, lineHeight,og.ScreenWidth, lineHeight);
            g.drawLine(LineWidth,0, LineWidth,og.ScreenHeight);
        }
        for(int i=0;i<og.monsters.size();i++){
            og.monsters.get(i).render(g);
        }
        for(int i =0; i<og.turrets.size();i++){
            og.turrets.get(i).render(g);
        }
        if(mCheck){
            g.drawImage(ResourceManager.getImage(OrkFortressGame.TURRET_IMG_RSC),53*((int)(input.getMouseX())/53), 40*((int)(input.getMouseY())/40));
        }
    }
    @Override
    public void update(GameContainer container, StateBasedGame game,
                       int delta) throws SlickException {
        OrkFortressGame og = (OrkFortressGame)game;
        Input input=container.getInput();
        if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
            if(mCheck){
                og.turrets.add(new Turret(53*((int)(input.getMouseX())/53),40*((int)(input.getMouseY())/40)));
            }
            mCheck= !mCheck;
        }
        for(int i=0;i<og.monsters.size();i++){
            int row= (int) (og.monsters.get(i).getX()/(og.ScreenWidth/15));
            int col=(int) (og.monsters.get(i).getY()/(og.ScreenHeight/15));
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
            for(int j=0;j<4;j++){
                if(directions[j][0]>0&&directions[j][0]< levelMap.paths.length &&
                        directions[j][1]>0 && directions[j][1]<levelMap.paths[0].length) {
                    //System.out.println(levelMap.paths[directions[j][0]][directions[j][1]]);
                    if (levelMap.paths[directions[j][0]][directions[j][1]] < min && levelMap.paths[directions[j][0]][directions[j][1]]!=wall) {
                        min = levelMap.paths[directions[j][0]][directions[j][1]];
                        System.out.println(levelMap.paths[directions[j][0]][directions[j][1]]);
                        System.out.println(j);
                        System.out.println(":"+directions[j][0]+":"+directions[j][1]);
                        direction = j;
                    }
                    //System.out.println(direction);
                }
            }
            og.monsters.get(i).turn(direction);
            og.monsters.get(i).update(delta);
        }
    }
    @Override
    public int getID() {return OrkFortressGame.PLAYINGSTATE;}
}
