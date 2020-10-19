import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Map {
    int[][] paths=new int[15][15];
    private final int maxDist=1000;
    private final int wall=-1;
    int exitCol;
    int exitRow;
    int enterCol;
    int enterRow;
    public Map(int ScreenWidth,int ScreenHeight){
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++) {
                paths[i][j] = -1;
            }
        }
    }
    public void digCell(int row, int col){
        paths[row][col]=1;
        //clear out a single cell
    }
    public void setExit(int row,int col){
        exitRow=row;
        exitCol=col;
        paths[row][col]=0;
    }
    public void setEnter(int row, int col){
        enterCol=col;
        enterRow=col;
    }
    public void digPath(int rowStart,int colsTart,int rowEnd,int colEnd){
        for(int i=rowStart;i<rowEnd;i++){
            for(int j=colsTart;j<colEnd;j++){
                paths[i][j]=maxDist;
                //System.out.println(paths[i][j]);
            }
        }
        //call to clear out path
    }
    public void setPath(int[][] paths){
        Queue<Integer[]> queue=new LinkedList<>();
        int[][] directions=new int[4][2];
        queue.add(new Integer[]{exitRow, exitCol});
        while(!queue.isEmpty()) {
            for(int i=0;i<4;i++){
                directions[0][0]=queue.peek()[0]+1;
                directions[0][1]=queue.peek()[1];
                directions[1][0]=queue.peek()[0]-1;
                directions[1][1]=queue.peek()[1];
                directions[2][0]=queue.peek()[0];
                directions[2][1]=queue.peek()[1]+1;
                directions[3][0]=queue.peek()[0];
                directions[3][1]=queue.peek()[1]-1;
                //Look into refactoring the above code Doesnt seem to need done 4 times
                int row=directions[i][0];
                int col=directions[i][1];
                if(row<0||row>= paths.length||col<0||col>=paths[0].length|| paths[row][col]!=maxDist){
                    continue;
                }
                queue.add(new Integer[]{row,col});
                //System.out.println(queue.peek()[1]);
                paths[row][col]=paths[queue.peek()[0]][queue.peek()[1]]+1;
            }
            queue.remove();
            //System.out.println(queue.peek().toString());
        }
        //add dijkstras here

    }
}
