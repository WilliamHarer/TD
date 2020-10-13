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
    public void setPath(){
        //add dijkstras here
    }
}
