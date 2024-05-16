import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AntWorker extends Ant{
    BufferedImage icon;
    JLabel label;

    Random random = new Random();

    
    int birthTime;
    int lifeTime;

    int id;
    App PAPO4Ka;

    boolean derection;

    double homeX; // Начальная координата X
    double homeY; // Начальная координата Y

    int pre_direction = 5;
    int direction = random.nextInt(4);

    AntWorker(int simulationTime, App Prima) {







        derection = random.nextBoolean();


        PAPO4Ka = Prima;
        Random rand = new Random();
        x = rand.nextInt(800);
        y = rand.nextInt(800);

        homeX = x;
        homeY = y;

        this.birthTime = simulationTime;
        this.lifeTime = PAPO4Ka.HARDBASS;

        this.id = rand.nextInt( 1000);


        try {
            icon = ImageIO.read(new File("Tarakan_is_Photo_2.png"));
        } catch (IOException e) {
            icon = null;
        }
        label = new JLabel(new ImageIcon(icon.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
    }

    void draw(Graphics g) {
        g.drawImage(icon, (int)x, (int)y, 60, 80, null);
    }

    void move() {
        System.out.println("Move");
    }

    boolean isAlive(int currentTime) {
        return currentTime - birthTime < lifeTime;
    }


}