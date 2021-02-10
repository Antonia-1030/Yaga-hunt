package game;

import message.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame implements ActionListener {
    public static final int SQUARE_SIDE = 8;
    public static boolean isGameOver=false;
    private int score=0;

    JButton resetButton;
    JButton yagaButton;

    public GameBoard(){
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        resetButton=new JButton();
        yagaButton=new JButton();
        yagaButton.setText("Cheat");
        resetButton.setText("Reset");
        resetButton.setSize(100,30);
        yagaButton.setSize(80,30);
        resetButton.setLocation(20,420);
        yagaButton.setLocation(180,420);
        resetButton.addActionListener(this);
        yagaButton.addActionListener(this);

        this.add(resetButton);
        this.add(yagaButton);
        this.setVisible(true);

        isTheGameOver();
    }

    public void paint(Graphics g) {
        //visualize board
        super.paint(g);
        for (int row = 0; row < SQUARE_SIDE; row++) {
            for (int col = 0; col < SQUARE_SIDE; col++) {
                GameTile tile = new GameTile();
                tile.render(g);
            }
        }

    }

    public boolean isTheGameOver(){
        if(score==100){
            isGameOver=true;
            Message.render(this,"Congrats!","You win!");
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==resetButton){
            this.repaint();
            new GameBoard();
        }
        if (e.getSource()==yagaButton){
            Message.render(this,"Congrats!","You win!");
        }
    }
}
