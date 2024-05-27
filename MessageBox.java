import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MessageBox extends JDialog {

    public Object textArea;

    public MessageBox(String m, JFrame p, String t, boolean modal, App parent, boolean typeMessage) {
        setSize(400, 200);
        JPanel VilkaLojka = new JPanel(new GridLayout(1, 2));

        setLayout(new BorderLayout());

        if (typeMessage == true) {
            add(parent.getText1());

            JButton exit = new JButton("exit");
            JButton ok = new JButton("ok");
            VilkaLojka.add(ok);
            VilkaLojka.add(exit);
            exit.setFocusable(false);
            ok.setFocusable(false);

            add(VilkaLojka, BorderLayout.SOUTH);
            setModal(modal);

            ok.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    App.Magnit.habitat.stopSimulation();
                    setVisible(false);

                    parent.B.setEnabled(true);
                    parent.E.setEnabled(false);

                    parent.B_2.setEnabled(true);
                    parent.E_2.setEnabled(false);
                }
            });

            exit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    App.Magnit.habitat.toggleSimulation();
                    setVisible(false);
                }
            });

        } else {
            add(parent.getText2());
            setFocusable(false);

            setVisible(true);
        }

        setVisible(true);

    }
}