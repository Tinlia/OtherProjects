// Evan "Tinlia" Kimpton

package partB;
import BasicIO.ASCIIDataFile;

public class Hallway {

    //Constructor
    public Hallway(){
        ASCIIDataFile map = new ASCIIDataFile();
        int row = map.readInt();
        int col = map.readInt();
        char[][] maze = new char[row][col];

        for(int i = 0; i<=row-1;i++){ // Generates the maze from the txt file
            maze[i] = map.readString().toCharArray();
        }
        maze = placePoints(maze,row,col); // Generate the S and E points
        showMap(maze,row,col,false);  // Displays the map
        findPath(maze, row, col, findStarty(maze, row, col), findStartx(maze, row, col)); // Finds a path through the maze
        System.out.println("Final path:");
        showMap(maze, row, col,true); // "fin" is true in this which means all the dots will be hidden. 
                                          // This makes it easier to follow the program's final path
    }

    // Generates a random start and finish point for the maze
    public char[][] placePoints(char[][] maze, int row, int col){
        for(;;) { // Loops until an empty spot is found
            int ranx = (int) (Math.random() * col); // Random x coord
            int rany = (int) (Math.random() * row); // Random y coord
            if(maze[rany][ranx]==' '){ // If the coordinate is empty, place the start
                maze[rany][ranx] = 'S'; // Start
                break;
            }
        }
        for(;;) { // Loops until an empty spot is found
            int ranx = (int) (Math.random() * col);
            int rany = (int) (Math.random() * row);
            if(maze[rany][ranx]==' '){ // If the coordinate is empty, place the end
                maze[rany][ranx] = 'E'; // End
                break; 
            }
        }
        return maze; // Return the new maze
    }

    // Displays the full map
    public void showMap(char[][] maze, int row, int col, boolean fin){
        if(fin) { // If it's the final board display, show only the path that worked
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if(maze[i][j]=='.'){System.out.print(' ');}
                    else{System.out.print(maze[i][j]);}
                }
                System.out.println("");
            }
        }
        else{ // Otherwise, display the dots
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print(maze[i][j]);
                }
                System.out.println("");
            }
        }
    }

    /* Finds the path necessary to take to get from S to E
        I used a boolean function here to allow the recursive function to "break" when the end is found.
        This stops the entire path from turning into dots :) */
    public boolean findPath(char[][] maze, int row, int col, int y, int x){
        showMap(maze,row,col,false); // Shows each step

        // If your crush, keep the letter
        if(maze[y][x]=='E'){
            System.out.println("Crush Found!");
            return true; // Ends all the recursive functions in waiting
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
        return false; // If crush not found, venture onwards
    }

    // Finds the x coord for the start
    public int findStartx(char[][] maze, int row, int col){
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(maze[i][j]=='S'){return j;}
            }
        }
        return 0;
    }

    // Finds the y coord for the start
    public int findStarty(char[][] maze, int row, int col){
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(maze[i][j]=='S'){return i;}
            }
        }
        return 0;
    }

    // Almighty main method
    public static void main(String[] args) {Hallway h = new Hallway();}
}
