package game;
import message.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameTile extends JFrame implements MouseListener{
    public static final int TILE_SIZE = 50;
    public static int random =(int)(Math.random()* 4+1);
    //public static int startCoordinates;
    private static boolean isWalkable=true;
    private int row;
    private int col;
    private Color faceColor= Color.PINK;

    public GameTile(){
        this.row=row;
        this.col=col;
        addMouseListener(this);
        //showColor(Color.PINK);
    }

    public void render(Graphics g){
        tilesPainter(g);
        startTile(g);
        boardGrid(g);
    }

    public boolean isTileWalkable(){
        if (!isWalkable){
            Message.render(this,"ERROR!","Try again!");
        }
        return true;
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
    public void tilesPainter(Graphics g){
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
    //make unexplored tile
    protected void unexploredTile(Graphics g){
        isWalkable=true;
        g.setColor(faceColor);
    }
    //Baba Yaga house
    private boolean isBabaYaga(int row,int col){
        int adress=random;
        isWalkable=true;
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
        isWalkable=false;
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
    //explored coord position
    private boolean isExploredCoord(int row, int col){
        int explored =random;
        isWalkable=true;
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
    //start tile
    private void startTile(Graphics g) {
        int startPos = random;
        isWalkable=true;
        g.setColor(Color.GREEN);
        if (startPos == 1) {
            //startCoordinates=1;
            g.fillRect(0, 20, 50, 50);
        }
        if (startPos == 2) {
            //startCoordinates=2;
            g.fillRect(350, 20, 50, 50);
        }
        if (startPos == 3) {
            //startCoordinates=4;
            g.fillRect(350, 370, 50, 50);
        }
        if(startPos==4){
            //startCoordinates=4;
            g.fillRect(0, 370, 50, 50);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = this.getBoardDimention(e.getY());
        int col = this.getBoardDimention(e.getX());
        isTileWalkable();
        int flipRandomizer = (int) (Math.random() * 5 + 1);

        if (flipRandomizer==5){
            //showBlue();
            faceColor=Color.BLUE;
            isWalkable=false;
            Message.render(this, "!!!", "Tile is unwalkable");
        }
        //showYellow();
        faceColor=Color.YELLOW;
        this.repaint();
        return;

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
    private int getBoardDimention(int coordinates) {
        return coordinates / GameTile.TILE_SIZE;
    }

    //protected void showColor(Color c){
    //            this.faceColor=c;
    //        }
}