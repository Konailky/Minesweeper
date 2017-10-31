
/**
 * Write a description of class Cell here.
 * This class generates each of the game. 
 * 
 * Wiebe's Guide:
 * 1: Board wil be 10 x 10 grid. Buid it with one space in between each number
 * 2: Make the "printBoard" method: It should print out all zeros once this method is complete. "isBomb" method will be included here as well. 
 * 3: Make the "addBombs" method:   Bombs are represented as "-1" but will print out as an "x": Make sure there is a correct number of bombs
 * 4: Make the "addNums" method:    Do your best
 * 5: Make it look pretty 
 * 
 * 
 * @author Wiebe / Kong
 * @version 10.11.16
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cell implements ActionListener{
    //Variables you need to work with
    int value;
    
    //Variables you don't need to worry about or care about.
    private JButton button;
    /**
     * This constructor is complete and does not need modification
     */
    public Cell(){
        button = new JButton();
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(20,20));
        button.setMargin(new Insets(0,0,0,0));
        value = 0;
    }
    /** This Method tells me if the cell is a bomb.
     * 
     * @return True if it is a bomb, otherwse false.
     */
    boolean isBomb(){
        if (value == -1){
            return true;
        }
        return false;
    }
    
    
    //Additional Methods may be required. Please make them yourself.
    
    //The following methods are used for the User Inferface. These methods are fully functional and do not need to be modified.
    public void checkCell(){
        button.setEnabled(false);
        displayValue();
    }
    public void displayValue(){
        if(this.isBomb()){
            button.setText("\u2600");
            button.setBackground(Color.RED);
        }else if(value!=0){
            button.setText(String.valueOf(value));
        }
    }
    public JButton getButton() {
        return button;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        checkCell();
    }
}
