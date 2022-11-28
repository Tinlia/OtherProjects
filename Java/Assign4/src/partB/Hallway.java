// Evan Kimpton
// ID: 7194996
// COSC 1P03

package partB;
import BasicIO.ASCIIDataFile;

public class Hallway {

    //Constructor
    public Hallway(){
        ASCIIDataFile map = new ASCIIDataFile();
        int row = map.readInt();
        int col = map.readInt();
        char[][] maze = new char[row][col];

        for(int i = 0; i<=row-1;i++){
            maze[i] = map.readString().toCharArray();
        }
        maze = placePoints(maze,row,col);
        showMap(maze,row,col,false);
        findPath(maze, row, col, findStarty(maze, row, col), findStartx(maze, row, col));
        System.out.println("Final path:");
        showMap(maze, row, col,false);
    }

    public char[][] placePoints(char[][] maze, int row, int col){
        for(;;) {
            int ranx = (int) (Math.random() * col);
            int rany = (int) (Math.random() * row);
            if(maze[rany][ranx]==' '){
                maze[rany][ranx] = 'S';
                break;
            }
        }
        for(;;) {
            int ranx = (int) (Math.random() * col);
            int rany = (int) (Math.random() * row);
            if(maze[rany][ranx]==' '){
                maze[rany][ranx] = 'E';
                break;
            }
        }
        return maze;
    }

    public void showMap(char[][] maze, int row, int col, boolean fin){
        if(fin) { // If it's the final board display
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if(maze[i][j]=='.'){System.out.print(' ');}
                    else{System.out.print(maze[i][j]);}
                }
                System.out.println("");
            }
        }
        else{
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print(maze[i][j]);
                }
                System.out.println("");
            }
        }
    }

    public boolean findPath(char[][] maze, int row, int col, int y, int x){
        showMap(maze,row,col,false); // Shows each step

        // If your crush, keep the letter
        if(maze[y][x]=='E'){
            System.out.println("Crush Found!");
            return true;
        }
        // Check/Pass up
        if(maze[y-1][x]==' ' || maze[y-1][x]=='S' || maze[y-1][x]=='E'){
            if(maze[y][x]!='S'){maze[y][x] = '^';}
            if(findPath(maze, row, col, y-1, x)){return true;}
            else{maze[y][x] = '.';} // If none, go back a step
        }
        // Check/Pass right
        if(maze[y][x+1]==' ' || maze[y][x+1]=='S' || maze[y][x+1]=='E'){
            if(maze[y][x]!='S'){maze[y][x] = '>';}
            if(findPath(maze, row, col, y, x+1)){return true;}
            else{maze[y][x] = '.';} // If none, go back a step
        }
        // Check/Pass down
        if(maze[y+1][x]==' ' || maze[y+1][x]=='S' || maze[y+1][x]=='E' ){
            if(maze[y][x]!='S'){maze[y][x] = 'V';}
            if(findPath(maze, row, col, y+1, x)){return true;}
            else{maze[y][x] = '.';} // If none, go back a step
        }
        // Check/Pass left
        if(maze[y][x-1]==' ' || maze[y][x-1]=='S' || maze[y][x-1]=='E' ){
            if(maze[y][x]!='S'){maze[y][x] = '<';}
            if(findPath(maze, row, col, y, x-1)){return true;}
            else{maze[y][x] = '.';} // If none, go back a step
        }
        return false;
    }

    public int findStartx(char[][] maze, int row, int col){
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(maze[i][j]=='S'){return j;}
            }
        }
        System.out.println("No start x found");
        return 0;
    }

    public int findStarty(char[][] maze, int row, int col){
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(maze[i][j]=='S'){return i;}
            }
        }
        System.out.println("No start y found");
        return 0;
    }

    public static void main(String[] args) {Hallway h = new Hallway();}
}
