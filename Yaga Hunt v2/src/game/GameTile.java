package game;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameTile implements MouseListener {
    public static final int TILE_SIZE = 50;
    public static int random =(int)(Math.random()* 4+1);
    private int row;
    private int col;
    private Color unexporedColor = Color.PINK;

    public GameTile(int row,int col){
        this.row = row;
        this.col = col;
    }

    public void render(Graphics g){
        tilePainter(g);
        startPosition(g);
        boardGrid(g);
    }
    //draw border between different squares
    private void boardGrid(Graphics g){
        g.setColor(Color.BLACK);
        for(int i = 0; i <=350; i+= 50){
            for (int j = 20; j<= 380; j += 50){
                g.drawRect(i,j,50,50);
            }
        }
    }
    //draw tiles
    public void tilePainter(Graphics g){
        for (int x = 0; x<8;x++){
            for (int y = 0; y<8;y++){
                g.fillRect(x*TILE_SIZE,(y*TILE_SIZE)+20,TILE_SIZE,TILE_SIZE);
                tileSeter(g,x,y);
            }
        }
    }
    public void tileSeter(Graphics g, int row, int col){
        if (isUnavailable(row,col)) {
            g.setColor(Color.BLUE);
        }
        else if (isExploredCoord(row,col)){
                    g.setColor(Color.YELLOW);
                }
        else if (isBabaYaga(row,col)){
            g.setColor(Color.PINK);
        }
        else unexploredTile(g);
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
    //make unexplored tile
    protected void unexploredTile(Graphics g){
        setBackColor(Color.PINK);
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
        if (blocked==3){
            return ((row == 5 && col == 0) ||
                    (row == 7 && col == 3) ||
                    (row == 4 && col == 0) ||
                    (row == 5 && col == 1)||
                    (row == 5 && col == 3));
        }
        if (blocked==2) {
            return ((row == 5 && col == 6) ||
                    (row == 7 && col == 1) ||
                    (row == 4 && col == 2) ||
                    (row == 2 && col == 7) ||
                    (row == 5 && col == 7));
        }
        else return ((row == 6 && col == 6) ||
                (row == 5 && col == 2) ||
                (row == 4 && col == 0) ||
                (row == 5 && col == 6)||
                (row == 0 && col == 5));
    }
    //start tile
    private void startPosition(Graphics g) {
        int startPos = random;
        g.setColor(Color.ORANGE);
        if (startPos == 1) {
            g.fillRect(0, 20, 50, 50);
        }
        if (startPos == 2) {
            g.fillRect(0, 370, 50, 50);
        }
        if (startPos == 3) {
            g.fillRect(350, 20, 50, 50);
        }
        if (startPos == 4) {
            g.fillRect(350, 370, 50, 50);
        }
    }
    protected void setBackColor(Color c){
        this.unexporedColor=c;
    }
    public void showBlue(){
        setBackColor(Color.BLUE);
    }
    public void showYellow(){
        setBackColor(Color.YELLOW);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int chanceTile =(int)(Math.random()*5+1);
                if (chanceTile==5){
                    showBlue();
                }
                if (chanceTile!=5){
                    showYellow();
                }
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
}
