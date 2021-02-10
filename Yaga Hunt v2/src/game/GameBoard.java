package game;

import message.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard  extends JFrame implements ActionListener{
    public static final int SQUARE_SIDE = 8;
    private static boolean isGameOver=false;
    JButton resetButton;

    public static void main(String[] args) {
        new GameBoard();
    }

    public GameBoard(){
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        resetButton=new JButton();
        resetButton.setText("Reset");
        resetButton.setSize(100,50);
        resetButton.setLocation(20,420);
        resetButton.addActionListener(this);

        this.add(resetButton);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        //visualize board
        super.paint(g);
        for (int row = 0; row < SQUARE_SIDE; row++) {
            for (int col = 0; col < SQUARE_SIDE; col++) {
                    GameTile tile = new GameTile(row, col);
                    tile.render(g);
            }
        }

    }

    //private boolean isTheGameOver(){
    //        if (){
    //            isGameOver=true;
    //            Message.render(this,"Congraats!","You win!");
    //        }
    //    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==resetButton){
            new GameBoard();
        }
    }
}
