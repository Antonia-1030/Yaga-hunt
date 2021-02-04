package tiles;

import java.awt.*;
import javax.swing.*;

public class GameTile extends JFrame{
    public static final int TILE_SIZE = 100;
    private static int random =(int)(Math.random()* 4+1);
    private int row;
    private int col;
    //private Color unexporedColor = Color.PINK;

    public GameTile(int row,int col){
        this.row = row;
        this.col = col;
    }

    public void render(Graphics g){
        tilePainter(g);
        boardGrid(g);
    }
//draw border between different squares
    private void boardGrid(Graphics g){
        g.setColor(Color.black);
        for(int i = 0; i <=700; i+= 100){
            for (int j = 20; j<= 720; j += 100){
                g.drawRect(i,j,100,100);
            }
        }
    }
    public void tilePainter(Graphics g){
        for (int x = 0; x<8;x++){
            for (int y = 0; y<8;y++){
                g.fillRect(x*TILE_SIZE,(y*TILE_SIZE)+20,TILE_SIZE,TILE_SIZE);
                tileSeter(g,x,y);
            }
        }
    }

    public void tileSeter(Graphics g, int row, int col){
        if (isStartPosition(row,col)) {
            g.setColor(Color.ORANGE);
        }
        else if (isUnavailable(row,col)) {
            g.setColor(Color.BLUE);
        }
        else if (isExploredCoord(row,col)){
            g.setColor(Color.cyan);
        }
        else if (isBabaYaga(row,col)){
            g.setColor(Color.PINK);
        }
        else unexploredTile(g);
    }
//make unexplored tile
    protected void unexploredTile(Graphics g){
        g.setColor(Color.PINK);
        //int chance = (int)(Math.random()*5+1);
        //        if (chance ==5){
        //            g.setColor(Color.BLUE);
        //        }
        //        g.setColor(Color.YELLOW);
    }

    private boolean isBabaYaga(int row,int col){
        int adress=random;
        if (adress==1){
            return (row==3 && col==0);
        }
        if (adress==2){
            return (row==6 && col==3);
        }
        if (adress==3){
            return (row==3 && col==4);
        }
        else return (row==2 && col==5);
    }
//unexplorable tiles
    private boolean isUnavailable(int row, int col){
        int blocked =random;
        if (blocked==1){
            return ((row == 0 && col == 1) ||
                    (row == 1 && col == 2) ||
                    (row == 1 && col == 1) ||
                    (row == 6 && col == 5)||
                    (row == 7 && col == 5));
        }
        if (blocked==2){
            return ((row == 5 && col == 6) ||
                    (row == 7 && col == 1) ||
                    (row == 4 && col == 2) ||
                    (row == 2 && col == 7)||
                    (row == 5 && col == 7));
        }
        if (blocked==3){
            return ((row == 5 && col == 0) ||
                    (row == 7 && col == 3) ||
                    (row == 4 && col == 0) ||
                    (row == 5 && col == 1)||
                    (row == 5 && col == 3));
        }
        else return ((row == 6 && col == 6) ||
                (row == 5 && col == 2) ||
                (row == 4 && col == 0) ||
                (row == 5 && col == 6)||
                (row == 0 && col == 5));
    }
//explored coord position
    private boolean isExploredCoord(int row, int col){
        int explored =random;
        if (explored==1){
            return ((row == 5 && col == 0) ||
                    (row == 7 && col == 3) ||
                    (row == 4 && col == 0) ||
                    (row == 5 && col == 1)||
                    (row == 5 && col == 3) ||
                    (row == 4 && col == 5) ||
                    (row == 3 && col == 1)||
                    (row==6 && col == 4));
        }
        if (explored==2){
            return ((row == 6 && col == 0) ||
                    (row == 7 && col == 2) ||
                    (row == 4 && col == 6) ||
                    (row == 5 && col == 3)||
                    (row == 5 && col == 4) ||
                    (row == 4 && col == 4) ||
                    (row == 3 && col == 2)||
                    (row==7 && col == 4));
        }
        if (explored==3){
            return((row == 1 && col == 0) ||
                    (row == 0 && col == 2) ||
                    (row == 4 && col == 6) ||
                    (row == 7 && col == 3)||
                    (row == 5 && col == 4) ||
                    (row == 4 && col == 7) ||
                    (row == 3 && col == 2)||
                    (row==7 && col == 6));
        }
        else return((row == 1 && col == 0) ||
                (row == 0 && col == 2) ||
                (row == 4 && col == 6) ||
                (row == 4 && col == 3)||
                (row == 0 && col == 4) ||
                (row == 4 && col == 1) ||
                (row == 4 && col == 5)||
                (row==7 && col == 6));

    }
//random position of starting point
    private boolean isStartPosition(int row, int col){
        int startPos = random;
        if (startPos==1){
            return (row==0 && col==0);
        }
        if (startPos==2){
            return (row==7 && col==0);
        }
        if (startPos==3){
            return (row==0 && col==7);
        }
        else return (row==7 && col==7);
    }
}
