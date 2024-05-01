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

    AntWorker() {
        Random rand = new Random();
        x = rand.nextInt(800);
        y = rand.nextInt(800);
        try {
            icon = ImageIO.read(new File("C:\\Users\\Егор\\Downloads\\Telegram Desktop\\Lab_V\\Lab_2\\Tarakans\\src\\Tarakan_is_Photo_1.jpg"));
        } catch (IOException e) {
            icon = null;
        }
        label = new JLabel(new ImageIcon(icon.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
    }

    void draw(Graphics g) {
        g.drawImage(icon, x, y, 60, 80, null);
    }

    void move() {
        System.out.println("Move");
    }



}