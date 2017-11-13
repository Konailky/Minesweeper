
/**
 * Write a description of class Minesweeper here.
 * This class will make the board, with bombs and the numbers.
 * 
 * @author (Kong) 
 * @version (10.3.17)
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MinesweeperBoard2{
    Cell[] board;
    int rows;
    int columns;
    int bombs;

    public MinesweeperBoard2(int rows, int columns, int bombs){
        //Put the constructor here.
        this.rows = rows;
        this.columns = columns;
        this.bombs = bombs;
        board = new Cell[rows*columns];

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
        this(10,10,10);
    }

    public void addBombs(int bombs) {//throws Exception{
        for (int i = bombs; i > 0; i--){
            int index = (int)(Math.random() * (rows * columns) );
            if(board[index].getValue() == -1){
                i++;
            }
            else{
                board[index].setBomb();
            }
        }
    }

    public void addNums(){
        for (int i = 0 ; i <= rows*columns; i++){
            int index = 0;

            if(board[index].getValue() != -1){

                if (board[index - 1].getValue() >= 0 && board[index - 1].getValue() == -1) {
                    //Checks the left one
                    board[index].addValue();
                    index++;
                }

                if (board[index + 1].getValue() <= (rows*columns) && board[index + 1].getValue() == -1 ){
                    //checks the right one
                    board[index].addValue();
                    index++;
                }

                if (board[index - rows].getValue() > 0 && board[index - rows].getValue() == -1){
                    //Checks the one above
                    board[index].addValue();
                    index++;
                }

                if (board[index + rows].getValue() < (rows*columns)){
                    //Chcks the bottom one
                    board[index].addValue();
                    index++;
                }

                if (board[index - rows - 1].getValue() > 0 ){
                    //Checks the up, left diagnol
                    board[index].addValue();
                    index++;
                }

                if (board[index - rows + 1].getValue() > 0){
                    //Checks the up, right diagnol
                    board[index].addValue();
                    index++;
                }

                if (board[index + rows -1].getValue() < (rows*columns)){
                    //Checks the down, left diagnol
                    board[index].addValue();
                    index++;
                }

                if (board[index + rows + 1].getValue() < (rows*columns)){
                    //Checks the down, right diagnol
                    board[index].addValue();
                    index++;
                }

            }

            else{
                //If the index is a bomb, do nothing
            }
        }
    }

    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        int i = 0;
        for (rows  = 0; rows < 10; rows++){
            for (columns = 0; columns < 10; columns++){
                if (board[i].getValue() == -1){
                    System.out.print("x" + "   ");
                    i++;
                }
                else{
                    System.out.print(board[i].getValue() + "   " );
                    i++;
                }

            }
            System.out.println();
        }
    }

    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int i = 0; i< rows*columns; i++){
            board[i]= new Cell();
            panel.add(board[i].getButton());
        }
        return panel;
    }

}

