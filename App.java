import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextComponent;
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

public class App extends JFrame {
    static JPanel ZOV;
    static Moskal SVO;

    MessageBox msgBox;
    
    App() {
        setSize(2, 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JButton B = new JButton("START");
        JButton E = new JButton("STOP");

        ZOV = new JPanel();
        ZOV.add(B);
        ZOV.add(E);
        SVO = new Moskal();
        
     
        // ((TextComponent) msgBox.textArea).setText("\n Ants warriorscreated - " + SVO.habitat.Tarakan_1 + "\n Ants workers created - " + SVO.habitat.Tarakan_2 + "\nAnts warriors died - " + SVO.habitat.Tarakan_1_Dead + "\nAnts workers died - " + SVO.habitat.Tarakan_2_Dead + "\n");

        // TextArea textArea = new TextArea();
        // textArea.setText("\n Ants warriorscreated - " + SVO.habitat.Tarakan_1 + "\n Ants workers created - " + SVO.habitat.Tarakan_2 + "\nAnts warriors died - " + SVO.habitat.Tarakan_1_Dead + "\nAnts workers died - " + SVO.habitat.Tarakan_2_Dead + "\n");


        //статистика по такраканам off
        ButtonGroup group = new ButtonGroup();
        JRadioButton visibel, invisible;
        visibel = new JRadioButton("VISIBLE TIME");
        group.add(visibel);
        ZOV.add(visibel);
        visibel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SVO.habitat.numTimer = true;
            }
        });
        invisible = new JRadioButton("INVISIBLE TIME");
        group.add(invisible);
        ZOV.add(invisible);
        invisible.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SVO.habitat.numTimer = false;
            }
        });
        //статистика по такраканам on
        
        // JList list = new JList();
        // Vector<String> data = new Vector<String>();
        // data.add("START");
        // data.add("STOP");
        // data.add("STATICK");
        // list.setListData(data);
        // list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // ZOV.add(list);

        // list.addListSelectionListener(new ListSelectionListener(){
        //     public void valueChanged(ListSelectionEvent listSelectionEvent)  {
        //     JList l = (JList)listSelectionEvent.getSource();
        //     if (l.getSelectedIndex() == 0)      {
        //         SVO.habitat.toggleSimulation();
        //     }
        //     else if (l.getSelectedIndex() == 1)    {
        //             SVO.habitat.stopSimulation();


        //     }else if (l.getSelectedIndex() == 2)    {
        //         SVO.habitat.numTimer = !SVO.habitat.numTimer;
        //         visibel.setSelected(!visibel.isSelected());// --- ???????????????????????????????????????
        //         invisible.setSelected(!invisible.isSelected());//----??????????????????????????????
        //     }
        // }
        // });


        //start "Tarakan the game"
        B.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SVO.habitat.toggleSimulation();
            }
        });
        E.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SVO.habitat.stopSimulation();
                //статистика по тараканам
                // ZOV.add(textArea);
                newWindow();

            }
        });

        //  stop "Tarakan the game"


        ZOV.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, Color.BLACK));
        
        add(ZOV, BorderLayout.WEST);
        add(SVO, BorderLayout.CENTER);
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SVO.repaint();
            }
        });
        timer.start();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_B) {
                    System.out.println("B");
                    SVO.habitat.toggleSimulation();
                }

                if (e.getKeyCode() == KeyEvent.VK_E) {
                    System.out.println("E");
                    SVO.habitat.stopSimulation();
                    newWindow();

                    msgBox.setVisible(true);


                }

                if (e.getKeyCode() == KeyEvent.VK_T) {
                    System.out.println("T");
                    SVO.habitat.numTimer = !SVO.habitat.numTimer;
                    visibel.setSelected(!visibel.isSelected());// --- ???????????????????????????????????????
                    invisible.setSelected(!invisible.isSelected());//----??????????????????????????????
                }
            }
        });


        JCheckBox lenta = new JCheckBox("It is checkbox");

        lenta.addItemListener((ItemListener) new ItemListener() {
            public void itemStateChanged(ItemEvent e )   {
                // textArea.setVisible(!textArea.isShowing());
                msgBox.setVisible(!msgBox.isVisible());

            }   
          });
          
        ZOV.add(lenta);


        setFocusable(true);
        pack();
        setVisible(true);
    }

    


    TextArea getText1() {
        TextArea textArea = new TextArea();
        textArea.setText("\n Ants warriorscreated - " + App.SVO.habitat.Tarakan_1 + "\n Ants workers created - "
                + App.SVO.habitat.Tarakan_2 + "\nAnts warriors died - " + App.SVO.habitat.Tarakan_1_Dead
                + "\nAnts workers died - " + App.SVO.habitat.Tarakan_2_Dead + "\n");

        return textArea;
    }
    
    void newWindow() {
        msgBox = new MessageBox("String of message", new JFrame(), "Message box", true, this);
    }


    public static void main(String[] args) {
        App app = new App();
    }
}

