import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

abstract public class Ant implements java.io.Serializable {
    protected double x;
    protected double y;
    int birthTime;
    int lifeTime;
    int id;

    boolean returning; 
    double angle; 
    static double speed;

    // protected BufferedImage icon;
    abstract void draw(Graphics g);

    abstract void move();
}
