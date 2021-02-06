package tile;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

public class GameTile extends JLabel implements MouseListener {
    private Color unexploredColor = Color.PINK;
    private final static Dimension size = new Dimension(50,50);

    public GameTile(Color c){
        setMaximumSize(size);
        setMinimumSize(size);
        setPreferredSize(size);
        setOpaque(true);
        addMouseListener(this);
        setBackColor(unexploredColor);
    }

    protected void setBackColor(Color c){
        this.unexploredColor=c;
    }

    public void showFaceColor(){
        setBackColor(Color.BLUE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        showFaceColor();
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
