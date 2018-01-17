
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
        for (int row = 0 ; row < (rows); row++){
            for (int col = 0; col < (columns); col++){
                
                if (board[row][col].isBomb()){
                    //If the index is a bomb, then add values to the surrounding indicies
                   
                    //Top Left
                    if(row - 1 >= 0 && col - 1 >= 0  ){ 
                        board[row-1][col-1].addValue();
                    }
                    //Top right
                    if (row - 1 >= 0 && col + 1 < columns){
                        board[row-1][col+1].addValue();
                    }
                    //Top
                    if (row - 1 >= 0 ){
                        board[row-1][col].addValue();
                    }
                    //Bottom
                    if (row + 1 < rows ){
                        board[row+1][col].addValue();
                    }
                    //Bottom left
                    if (row + 1 < rows && col - 1 >= 0 ){
                        board[row+1][col-1].addValue();
                    }
                    //Bottom right
                    if(row +1 < rows && col + 1 < columns  ){
                        board[row+1][col+1].addValue();
                    }
                    //Left
                    if( col -1 >= 0  ){
                        board[row][col-1].addValue();
                    }
                    //Right
                    if( col + 1 < columns  ){
                        board[row][col+1].addValue();
                    }

                }            
            }
        }
    }

    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        System.out.println("Minesweeper!");
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

