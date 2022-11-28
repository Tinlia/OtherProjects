// Evan Kimpton
// ID: 7194996
// COSC 1P03

package partA;
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
        showMap(maze,row,col);
        findPath(maze, row, col, findStarty(maze, row, col), findStartx(maze, row, col));
        System.out.println("Done");
        showMap(maze, row, col);
    }

    public void showMap(char[][] maze, int row, int col){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(maze[i][j]);
            }
            System.out.println("");
        }
    }

    public boolean findPath(char[][] maze, int row, int col, int y, int x){
        // If Crush, keep letter
        if(maze[y][x] == 'E'){
            return true;
        }

        // If dead end, return the letter back one
        if(maze[y][x+1] == '#'){
            maze[y][x]='.';
            return false;
        }

        // If not the crush, pass the letter to the next person
        if(maze[y][x] != 'E' && maze[y][x] != '#' ){
            maze[y][x] = '>';
            if(findPath(maze, row, col, y, x+1)){
                return true;
            }
            // If returned to you after the last step, return the letter to prev person
            else{
                if(maze[y][x]!='S'){maze[y][x]='.';}
            }
        }
        return false;
    }

    public int findStartx(char[][] maze, int row, int col){
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(maze[i][j]=='S'){return j;}
            }
        }
        return 0;
    }

    public int findStarty(char[][] maze, int row, int col){
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(maze[i][j]=='S'){return i;}
            }
        }
        return 0;
    }

    public static void main(String[] args) {Hallway h = new Hallway();}
}