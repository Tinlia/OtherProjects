// Evan Kimpton - COSC 1P03 Assign 1
// Desc.: A console-based version of Conway's Game of Life played on a complete "sphere" depicted as a 15x15 grid

import java.util.*; // Needed for scanners

public class GameOfLife {

    private final char[][] board = new char[15][15];  // Init. the first board
    private final char[][] board2 = new char[15][15]; // Init. the second board to copy from

    // Generates new, empty boards
    private void newBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '.';
                board2[i][j] = '.';
            }
        }
    }

    // Displays the first board
    public void showBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    // Provides a 10% chance for each cell to be populated with an 'O'
    public void populate(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int rand = (int)(Math.random()*10+1);
                if(rand==1){
                    board[i][j]='O';
                    board2[i][j]='O';
                }
            }
        }
    }

    // Generates a new board based on the previous one
    public void runBoard(){
        for(int i = 0; i< board.length; i++) {
            for(int j = 0; j< board[i].length; j++) {
                int count = 0; // Count is the number of surrounding populated cells

                for (int x = i -1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if(!(i==x && j==y)) { // Not the center cell [x][y]
                            int cx = x;
                            int cy = y;

                            if (cx >= board.length) {cx = 0;} // If outside the boundary, loop back in
                            if (cx < 0) {cx = 14;}            // If outside the boundary, loop back in
                            if (cy >= board.length) {cy = 0;} // If outside the boundary, loop back in
                            if (cy < 0) {cy = 14;}            // If outside the boundary, loop back in

                            final char character = board[cx][cy]; // Checks if the cell is populated
                            if (character == 'O') { // If so, increase the count
                                count++;
                            }
                        }
                    }
                }
                // Commented out, but below is used to check the count for each individual cell
                // System.out.println("Count of X: " + i + " Y: " + j + " is " + count);
                if(count==0 || count == 1 || count>=4){board2[i][j]='.';} // If under- or over-populated, Die
                if(count==3){board2[i][j]='O';}                          // If surrounded by 3, Live
                if(count==2){board2[i][j]=board[i][j];}                  // If surrounded by 2, Stay the Same
            }
        }

        for(int i = 0; i < board.length; i++){ // Saves the second board to the first
            for(int j = 0; j < board[i].length; j++){
                board[i][j]=board2[i][j];
            }
        }
    }

    // Main Class
    public static void main(String[] args) {
        GameOfLife g = new GameOfLife();
        g.newBoard(); // Creates a new board
        g.populate(); // Populates it
        g.showBoard(); // Displays it
        String input;
        Scanner in = new Scanner(System.in); // Collects an input for the Next Phase or to Quit
        for(;;){
            System.out.print("Type 'N' for next, 'L' to loop 10 times, or 'Q' to Quit");
            System.out.println();
            input = in.nextLine();
            if(input.equalsIgnoreCase("N")){ // If "N," displays the next phase
                g.runBoard();
                g.showBoard();
            }
            else if(input.equalsIgnoreCase("L")){ // If "L," Loops 10 times
                for(int l = 0;l<10;l++){
                    g.runBoard();
                    g.showBoard();
                }
            }
            else if(input.equalsIgnoreCase("Q")){ // If "Q," Exits the program
                break;
            }
            else { // If anything else in inputted, states it is invalid and requests another
                System.out.println("Invalid input.");
                System.out.println();
            }
        }
    }
}
