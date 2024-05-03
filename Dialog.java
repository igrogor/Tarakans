// объявление нового класса диалога

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class MessageBox extends JDialog {
    
    public Object textArea;

    public MessageBox(String m, JFrame p, String t, boolean modal, App parent, boolean typeMessage)   {
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
            VilkaLojka.setFocusable(false);

            setVisible(true);
    
            ok.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    App.SVO.habitat.stopSimulation();//--------------------------остановиля на реализации окошка с статитстикой и кнопками
                    setVisible(false);
                    parent.B.setEnabled(true);
                    parent.E.setEnabled(false);
                }
            });
    
            exit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    App.SVO.habitat.toggleSimulation();
                    setVisible(false);
                }
            });
        }else{
            add(parent.getText2());
            setFocusable(false);

            setVisible(true);
        }
        setFocusable(false);


     }
 }
 