
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
        this(10,10,99);
    }

    public void addBombs(int bombs) {//throws Exception{
        for (int i = bombs; i > 0; i--){
            int index = (int)(Math.random() * (rows * columns) );
            if(board[index].isBomb()){
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
            int num = 0;

            if(board[index].isBomb() == false){

                if (index - 1 >= 0 && board[index - 1].isBomb() ){
                    //Checks the left one
                    num ++;
                    index++;
                }

                if (index + 1 < (rows*columns) && board[index + 1].isBomb()){
                    //checks the right one
                    num ++;
                    index++;
                }

                if (index - rows > 0 && board[index - rows].isBomb()){
                    //Checks the one above
                    num ++;
                    index++;
                }

                if (index + rows < (rows*columns) && board[index + rows].isBomb()){
                    //Chcks the bottom one
                    num ++;
                    index++;
                }

                if (index - rows - 1 > 0 && board[index - rows - 1].isBomb()){
                    //Checks the up, left diagnol
                    num ++;
                    index++;
                }

                if (index - rows + 1 > 0  && board[index - rows + 1].isBomb()){
                    //Checks the up, right diagnol
                    num ++;
                    index++;
                }

                if (index + rows -1 < (rows*columns) && board[index - + rows - 1].isBomb() ){
                    //Checks the down, left diagnol
                    num ++;
                    index++;
                }

                if (index + rows + 1 < (rows*columns) && board[index + rows + 1].isBomb()){
                    //Checks the down, right diagnol
                    num ++;
                    index++;
                }
                board[index].setValue(num); //Put the value into the cell

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
                if (board[i].isBomb()){
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

