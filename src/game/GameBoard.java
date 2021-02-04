package game;

import tiles.*;
import message.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameBoard extends JFrame implements MouseListener{
    public static final int SQUARE_SIDE = 8;
    private static boolean isGameOver=false;

    public GameBoard(){

        this.setSize(800, 800);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);

        //gameSetup();
    }

    public void paint(Graphics g) {
        //visualize board
        super.paint(g);
        for(int row = 0; row < SQUARE_SIDE; row++) {
            for(int col = 0; col < SQUARE_SIDE; col++) {
                GameTile tile = new GameTile(row, col);
                tile.render(g);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
//private void gameSetup()
//getContentPane().add(new GameTile());
}
