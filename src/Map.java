import java.sql.Array;
import java.util.ArrayList;

public class Map {
    int[][] paths=new int[15][15];
    private final int maxDist=1000;
    int exitCol;
    int exitRow;
    int enterCol;
    int enterRow;
    public Map(int ScreenWidth,int ScreenHeight){
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++) {
                paths[i][j] = maxDist;
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
                paths[i][j]=1;
            }
        }
        //call to clear out path
    }
    public void setPath(int[][] paths){
        ArrayList<Integer[]> queue=new ArrayList<Integer[]>();
        int[][] directions=new int[4][2];
        queue.add(new Integer[]{enterRow, enterCol});
        while(!queue.isEmpty()) {
            for(int i=0;i<4;i++){
                directions[0][0]=queue.get(0)[0]+1;
                directions[0][1]=queue.get(0)[1];
                directions[1][0]=queue.get(0)[0]-1;
                directions[1][1]=queue.get(0)[1];
                directions[2][0]=queue.get(0)[0];
                directions[2][1]=queue.get(0)[1]+1;
                directions[3][0]=queue.get(0)[0];
                directions[3][1]=queue.get(0)[1]-1;
                //Look into refactoring the above code Doesnt seem to need done 4 times
                int row=directions[i][0];
                int col=directions[i][1];
                if(row<0||row>= paths.length||col<0||col>=paths[0].length|| paths[row][col]==maxDist){
                    continue;
                }
                queue.add(new Integer[]{row,col});
                paths[row][col]=paths[queue.get(0)[0]][queue.get(0)[1]]+1;
            }
            queue.remove(0);
        }
        //add dijkstras here

    }
}
