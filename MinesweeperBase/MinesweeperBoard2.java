
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
        this(20,10,10);
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
        for (int i = 0 ; i < (rows*columns); i++){
            int index = 0;

            if(board[i].isBomb() == true ){
                //The Top Left one*****************
                index = i - columns - 1;
                if (index > 0 &&  index % columns != 0  ){
                    board[index].addValue();
                }

                //The Top Right one
                index = i - columns + 1;
                if (index > 0 &&  index % columns != (columns -1) % columns  ){
                    board[index].addValue(); 
                }

                //The Bottom Left one
                index = i + columns - 1;
                if (index < (rows*columns - 1) &&  index % columns != (columns -1) % columns ){
                    board[index].addValue();
                }

                // The Bottom Right one*************
                index = i + columns + 1;
                if (index < (rows*columns - 1)  &&   index % columns != 0 ){
                    board[index].addValue();
                }

                //The Top one
                index = i - columns;
                if (index > 0 &&  index % columns == i % columns  ){
                    board[index].addValue();
                }

                //The Bottom one
                index = i + columns;
                if (index < (rows*columns - 1) &&  index % columns == i % columns ){
                    board[index].addValue();
                }

                //The Left one
                index = i - 1;
                if(index > 0 &&  index % columns != (columns -1) % columns ){
                    board[index].addValue();
                }

                //The Right one
                index = i + 1;
                if (index < (rows*columns - 1)  && index % columns != 0){
                    board[index].addValue();
                }

            }

        }
    }

    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        int i = 0;
        for (int j  = 0; j < rows; j++){
            for (int c = 0; c < columns; c++){
                if (board[i].isBomb()){
                    System.out.print("x" + " ");
                    i++;
                }
                else{
                    System.out.print(board[i].getValue() + " " );
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

