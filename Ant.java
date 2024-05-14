import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

abstract public class Ant {
    protected int x;
    protected int y;
    int birthTime;
    int lifeTime;
    int id;

    boolean returning; // Добавляем поле для отслеживания направления движения муравья
    double angle; // Для муравьев-воинов, чтобы хранить текущий угол движения
    int speed; // Для муравьев-воинов, чтобы хранить скорость движения


    //protected BufferedImage icon;
    abstract void draw(Graphics g);
    abstract void move();
}
