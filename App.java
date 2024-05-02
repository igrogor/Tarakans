// Говнокод off
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
    MessageBox Error;
    
    App() {
        setSize(2, 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JButton B = new JButton("START");
        JButton E = new JButton("STOP");
        ZOV = new JPanel();
        ZOV.setBackground(new Color(201, 139, 91));
        ZOV.add(B);
        ZOV.add(E);
        SVO = new Moskal();
        JLabel timer1 = new JLabel(String.valueOf(SVO.habitat.timer));
        timer1.setVisible(SVO.habitat.numTimer);
        
//статистика по такраканам off -------------------------------------------------------
        ButtonGroup group = new ButtonGroup();
        JRadioButton visibel, invisible;
        visibel = new JRadioButton("VISIBLE TIME");
        group.add(visibel);
        ZOV.add(visibel);
        visibel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SVO.habitat.numTimer = true;
                timer1.setVisible(SVO.habitat.numTimer);
            }
        });

        invisible = new JRadioButton("INVISIBLE TIME");
        group.add(invisible);
        ZOV.add(invisible);
        invisible.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SVO.habitat.numTimer = false;
                timer1.setVisible(SVO.habitat.numTimer);
            }
        });
//on------------------------------------------------------------------------------------
    

//menuBar off -------------------------------------------------------------------
          JMenuBar mainMenu = new JMenuBar(); 
          JMenu fileMenu = new JMenu("main"); 
          JMenu helpMenu = new JMenu("Help"); 
          
  
       
          fileMenu.add(new JMenuItem("start")); 
          fileMenu.addSeparator();  	
          fileMenu.add(new JMenuItem("stop")); 
          fileMenu.addSeparator();  	
          fileMenu.add(new JMenuItem("Exit")); 
          helpMenu.add(new JMenuItem("Content")); 
          mainMenu.add(fileMenu); 
          mainMenu.add(helpMenu); 
          setJMenuBar(mainMenu); 	
  
  
          fileMenu.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                 String str = e.getActionCommand();
                 if ( str.equals("start") )   {  
                      SVO.habitat.toggleSimulation();
                  }
                  if ( str == "stop")   {    
                      SVO.habitat.stopSimulation();
                      newWindow();
                      msgBox.setVisible(true);
                  }
                 if ( str == "Exit")   {   
                     dispose();
                 }
              }
          });
//menuBar on ----------------------------------------------------------------
  
        fail();
//start "Tarakan the game" -------------------------------------------------------------------
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

//  stop "Tarakan the game" ------------------------------------------------------------------


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
                    visibel.setSelected(SVO.habitat.numTimer);// --- ???????????????????????????????????????
                    invisible.setSelected(!SVO.habitat.numTimer);//----??????????????????????????????
                    timer1.setVisible(SVO.habitat.numTimer);


                }
            }
        });

        JCheckBox lenta = new JCheckBox("It is checkbox");

        lenta.addItemListener((ItemListener) new ItemListener() {
            public void itemStateChanged(ItemEvent e )   {
                msgBox.setVisible(!msgBox.isVisible());
            }   
        });
// spawn off
        JComboBox spawnChanse = new JComboBox();
        spawnChanse.addItem("10%");
        spawnChanse.addItem("20%");
        spawnChanse.addItem("30%");
        spawnChanse.addItem("40%");
        spawnChanse.addItem("50%");
        spawnChanse.addItem("60%");  
        spawnChanse.addItem("70%");
        spawnChanse.addItem("80%");
        spawnChanse.addItem("90%");
        spawnChanse.addItem("100%");           
        ZOV.add(spawnChanse);

        spawnChanse.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e )   {
                switch (spawnChanse.getSelectedIndex()) {
                    case 1:
                        SVO.habitat.nuclearBomb = 9;
                        break;
                    case 2:
                        SVO.habitat.nuclearBomb = 8;
                        break;
                    case 3:
                        SVO.habitat.nuclearBomb = 7;
                        break;
                    case 4:
                        SVO.habitat.nuclearBomb = 6;
                        break;  
                    case 5:
                        SVO.habitat.nuclearBomb = 5;
                        break;
                    case 6:
                        SVO.habitat.nuclearBomb = 4;
                        break;
                    case 7:
                        SVO.habitat.nuclearBomb = 3;
                        break;
                    case 8:
                        SVO.habitat.nuclearBomb = 2;
                        break;   
                    case 9:
                        SVO.habitat.nuclearBomb = 1;
                        break;    
                    case 10:
                        SVO.habitat.nuclearBomb = 0;
                        break;                       
                    default:
                    SVO.habitat.nuclearBomb = 9;
                        break;
                }
            }
          });
// spawn on          

        ZOV.add(lenta);
        ZOV.add(timer1, BorderLayout.EAST);
        setFocusable(true);
        pack();
        setVisible(true);
    }

    TextArea getText1() {
        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setText("\n Ants warriorscreated - " + App.SVO.habitat.Tarakan_1 + "\n Ants workers created - "
                + App.SVO.habitat.Tarakan_2 + "\nAnts warriors died - " + App.SVO.habitat.Tarakan_1_Dead
                + "\nAnts workers died - " + App.SVO.habitat.Tarakan_2_Dead + "\n");
        return textArea;
    }

    TextArea getText2() {
        TextArea textArea = new TextArea();
        textArea.setEditable(true);
        textArea.setEditable(false);
        textArea.setText("Ошибка, вы совершили ошибку ввода");
        return textArea;
    }
    
    void newWindow() {
        msgBox = new MessageBox("String of message", new JFrame(), "Message box", true, this, true);
    }

    void fail(){
        Error = new MessageBox("String of message", new JFrame(), "Message box", true, this, false);
        setVisible(true);
    }

    public static void main(String[] args) {
        App app = new App();
    }
}

// Говнокод on