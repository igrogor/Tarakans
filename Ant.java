import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

abstract public class Ant {
    protected int x;
    protected int y;
    int birthTime;
    int lifeTime;
    int id;
    //protected BufferedImage icon;
    abstract void draw(Graphics g);
    abstract void move();
}
