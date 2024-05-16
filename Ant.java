import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

abstract public class Ant {
    protected double x;
    protected double y;
    int birthTime;
    int lifeTime;
    int id;

    boolean returning; // Добавляем поле для отслеживания направления движения муравья
    double angle; // Для муравьев-воинов, чтобы хранить текущий угол движения
    double speed; // Для муравьев-воинов, чтобы хранить скорость движения


    //protected BufferedImage icon;
    abstract void draw(Graphics g);
    abstract void move();
}
