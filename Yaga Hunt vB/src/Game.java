import javax.swing.*;

import modal.Message;
import tile.GameTile;

import java.awt.*;

public class Game extends JFrame {

    public static void main(String[] args){
        new Game();
    }

    public Game(){
        setSize(400,400);
        setTitle("Hunt for Baba Yaga");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameSetup();
        setVisible(true);
    }

    private void gameSetup(){
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(new GameTile(Color.PINK));
        getContentPane().add(new GameTile(Color.YELLOW));
        getContentPane().add(new GameTile(Color.BLUE));
        getContentPane().add(new GameTile(Color.GREEN));
    }
}
