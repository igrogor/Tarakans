import java.util.Random;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class AntWarrior extends Ant{
    BufferedImage icon;
    JLabel label;


    int birthTime;
    int lifeTime;
    int id;
    App MAMO4ka;

    AntWarrior(int simulationTime, App Charon_B) {
        MAMO4ka = Charon_B;
        Random rand = new Random();
        x = rand.nextInt(800);
        y = rand.nextInt(800);

        this.birthTime = simulationTime;
        this.lifeTime = MAMO4ka.HARDBASS;

        this.id = rand.nextInt( 1000);


        try {
            icon = ImageIO.read(new File("Tarakan_is_Photo_1.jpg"));
        } catch (IOException e) {
            icon = null;
        }
        label = new JLabel(new ImageIcon(icon.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
    }

    void draw(Graphics g) {
        g.drawImage(icon, x, y, 80, 60, null);
    }

    void move() {
        System.out.println("Move");
    }

    boolean isAlive(int currentTime) {
        return currentTime - birthTime < lifeTime;
    }

}


