
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
    int nums;
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
    }

    public MinesweeperBoard2(){
        this(10,10,10);
    }

    public void addBombs(int bombs) {//throws Exception{
        for (int i = bombs; i >= 0; i--){
            int index = (int)(Math.random() * (rows * columns));
            board[index].value = -1;
        }
    }

    public void addNums(){
        for (int i = bombs; i>= 0; i--){
            if (board[i - 1].value == -1) {
                
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
                System.out.print(board[i].value + "   " );
                i++;
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
