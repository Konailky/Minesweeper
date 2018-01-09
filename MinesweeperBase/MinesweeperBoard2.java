
/**
 * Write a description of class Minesweeper here.
 * This class will make the board, with bombs and the numbers. WITH 2D ARRAYS NOW
 * 
 * @author (Kong) 
 * @version (10.3.17) -> (1.9.18) -> 
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MinesweeperBoard2{
    Cell[][] board;
    int rows;
    int columns;
    int bombs;

    public MinesweeperBoard2(int rows, int columns, int bombs){
        //Put the constructor here.
        this.rows = rows;
        this.columns = columns;
        this.bombs = bombs;
        board = new Cell[rows][columns];

        //These pieces are for the GUI.
        JFrame frame = new JFrame();
        frame.add(addCells());

        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        addBombs(bombs);
        addNums();
    }

    public MinesweeperBoard2(){
        //To run the program
        this(10,10,10);
    }

    public void addBombs(int bombs) {//throws Exception{
        //Generates random numbers to make random spots into bombs
        for (int i = bombs; i > 0; i--){
            int row = (int)(Math.random() * (rows) );
            int col = (int)(Math.random() * (columns)) ;
            if(board[row][col].isBomb()){
                i++;
            }
            else{
                board[row][col].setBomb();
            }
        }
    }

    public void addNums(){ // Add numbers to make the game fun
        for (int row = 0 ; row < (rows*columns); row++){
            for (int col = 0; col < (rows*columns); col++){
                int index;

                if(board[row][col].isBomb() == true ){ 
                    //The Top Left one
                    index = (row*col) - columns - 1;
                    if (index >= 0 &&  index % columns != (columns -1)   ){
                        board[row][col].addValue();
                    }

                    //The Top Right one
                    index = (row*col) - columns + 1;
                    if (index >= 0 &&  index % columns != 0  ){
                        board[row][col].addValue(); 
                    }

                    //The Bottom Left one
                    index = (row*col) + columns - 1;
                    if (index <= (rows*columns - 1) &&  index % columns != (columns -1)   ){
                        board[row][col].addValue();
                    }

                    // The Bottom Right one
                    index = (row*col) + columns + 1;
                    if (index <= (rows*columns - 1)  &&   index % columns != 0 ){
                        board[row][col].addValue();
                    }

                    //The Top one
                    index = (row*col) - columns;
                    if (index >= 0   ){
                        board[row][col].addValue();
                    }

                    //The Bottom one
                    index = (row*col) + columns;
                    if (index <= (rows*columns - 1)   ){
                        board[row][col].addValue();
                    }

                    //The Left one
                    index = (row*col) - 1;
                    if(index >= 0 &&  index % columns != columns -1   ){
                        board[row][col].addValue();
                    }

                    //The Right one
                    index = (row*col) + 1;
                    if (index <= (rows*columns - 1)  && index % columns != 0){
                        board[row][col].addValue();
                    }

                }

            }
        }
    }

    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        int i = 0;
        for (int row  = 0; row < rows; row++){
            for (int col = 0; col < columns; col++){
                if (board[row][col].isBomb()){
                    System.out.print("x" + " ");
                    i++;
                }
                else{
                    System.out.print(board[row][col].getValue() + " " );
                    i++;
                }

            }
            System.out.println();
        }
    }

    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int row = 0; row< rows; row++){
            for (int col = 0; col < columns; col++){
                board[row][col]= new Cell();
                panel.add(board[row][col].getButton());

            }

        }
        return panel;
    }
}

