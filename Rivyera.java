import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;



public class Rivyera extends JPanel {

    Habitat habitat;

    Image a;
    

    Rivyera(App R2D2) {
        setPreferredSize(new Dimension(800, 800));
        habitat = new Habitat(R2D2);
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        a = createImage(getSize().width, getSize().height);
        Graphics g2 = a.getGraphics();

        g2.clearRect(0, 0, getSize().width, getSize().height);
        for (int i = 0; i < habitat.Ants1.size(); i++) {
            habitat.Ants1.get(i).draw(g2);
        }
        for (int i = 0; i < habitat.Ants2.size(); i++) {
            habitat.Ants2.get(i).draw(g2);
        }
        if (habitat.num) {
            habitat.window = new String(
                    "Ants warriorscreated - " + habitat.Tarakan_1 + " Ants workers created - " + habitat.Tarakan_2);
            habitat.Deats_warrior = new String("Ants warriors died - " + habitat.Tarakan_1_Dead);
            habitat.Deats_worker = new String(" Ants workers died - " + habitat.Tarakan_2_Dead);

            g2.setColor(Color.blue);
            setFont(new Font("Papyrus", Font.ITALIC, 40));
            g2.drawString(habitat.window, 100, 300);

            g2.setColor(Color.red);
            setFont(new Font("Papyrus", Font.ITALIC, 40));
            g2.drawString(habitat.Deats_warrior, 200, 400);

            g2.setColor(Color.green);
            setFont(new Font("Papyrus", Font.ITALIC, 40));
            g2.drawString(habitat.Deats_worker, 600, 600);

           
        }
        g.drawImage(a, 0, 0, null);
    }
}
