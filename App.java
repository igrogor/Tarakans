// Говнокод ON
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextComponent;
import java.awt.TextField;
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
    static JPanel BAR;
    static JPanel TOOL;
    static Moskal SVO;
    MessageBox msgBox;
    MessageBox Error;
    JLabel timer1;
    int period = 1000;
    TextField ZaycevNET;
    int a = 1000;
    JButton B;
    JButton E;
    JButton B_2;
    JButton E_2;
    
    App() {
        setSize(2, 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        B = new JButton("START");
        E = new JButton("STOP");
        ZOV = new JPanel();
        ZOV.setBackground(new Color(201, 139, 91));
        ZOV.add(B);
        ZOV.add(E);
        SVO = new Moskal(this);
        timer1 = new JLabel(String.valueOf(SVO.habitat.timer_1));
        timer1.setVisible(SVO.habitat.numTimer);
        B.setFocusable(false);
        E.setFocusable(false);
//статистика по такраканам ON -------------------------------------------------------
        ButtonGroup group = new ButtonGroup();
        JRadioButton visibel, invisible;
        visibel = new JRadioButton("VISIBLE TIME");
        group.add(visibel);
        ZOV.add(visibel);
        ZOV.setFocusable(false);
        visibel.setFocusable(false);
        


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
        timer1.setFocusable(false);

        invisible.setFocusable(false);
//OFF------------------------------------------------------------------------------------
    


  

//start "Tarakan the game" -------------------------------------------------------------------
        B.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SVO.habitat.toggleSimulation();
                B.setEnabled(false);
                E.setEnabled(true);
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

        ZOV.setFocusable(false);
        SVO.setFocusable(false);

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

        JCheckBox lenta = new JCheckBox("statistick");
        lenta.setFocusable(false);

        lenta.addItemListener((ItemListener) new ItemListener() {
            public void itemStateChanged(ItemEvent e )   {
                msgBox.setVisible(!msgBox.isVisible());
            }   
        });

        
// установка периода ON
        ZaycevNET = new TextField();
        ZaycevNET.setText("1000");
        ZaycevNET.setColumns(10);
        ZaycevNET.setFocusable(false);

        try {
            a = Integer.parseInt(ZaycevNET.getText());
        } catch (NumberFormatException e) {
            fail();
            ZaycevNET.setText("1000");
            a = 1000;
        }
        ZOV.add(ZaycevNET);
// установка периода OFF


// spawn ON
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
        spawnChanse.setFocusable(false);

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
// spawn OFF        

ZOV.add(lenta);
ZOV.add(timer1, BorderLayout.EAST);

//всякое для менюbar ON

JComboBox spawnChanse_1 = new JComboBox();
TextField ZaycevNET_1 = new TextField();
JCheckBox lenta_1 = new JCheckBox();
ButtonGroup group_1 = new ButtonGroup();
JRadioButton visibel_1 = new JRadioButton();
JRadioButton invisible_1 = new JRadioButton();

spawnChanse_1.setFocusable(false);
ZaycevNET_1.setFocusable(false);
lenta_1.setFocusable(false);
visibel_1.setFocusable(false);
invisible_1.setFocusable(false);


spawnChanse_1.addItem("10%");
spawnChanse_1.addItem("20%");
spawnChanse_1.addItem("30%");
spawnChanse_1.addItem("40%");
spawnChanse_1.addItem("50%");
spawnChanse_1.addItem("60%");  
spawnChanse_1.addItem("70%");
spawnChanse_1.addItem("80%");
spawnChanse_1.addItem("90%");
spawnChanse_1.addItem("100%");           
        // ZOV.add(spawnChanse_1);
        spawnChanse_1.setFocusable(false);
        spawnChanse_1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e )   {
                switch (spawnChanse_1.getSelectedIndex()) {
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

        ZaycevNET_1.setText("1000");
        ZaycevNET_1.setColumns(10);
        ZaycevNET_1.setFocusable(false);

        try {
            a = Integer.parseInt(ZaycevNET_1.getText());
        } catch (NumberFormatException e) {
            fail();
            ZaycevNET_1.setText("1000");
            a = 1000;
        }


        lenta_1.setFocusable(false);
        lenta_1.addItemListener((ItemListener) new ItemListener() {
            public void itemStateChanged(ItemEvent e )   {
                msgBox.setVisible(!msgBox.isVisible());
            }   
        });

        visibel_1 = new JRadioButton("VISIBLE TIME");
        group.add(visibel_1);
        // ZOV.add(visibel);
        ZOV.setFocusable(false);
        visibel.setFocusable(false);
        
        visibel_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SVO.habitat.numTimer = true;
                timer1.setVisible(SVO.habitat.numTimer);
            }
        });

        invisible_1 = new JRadioButton("INVISIBLE TIME");
        group.add(invisible_1);
        // ZOV.add(invisible_1);
        invisible_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SVO.habitat.numTimer = false;
                timer1.setVisible(SVO.habitat.numTimer);
            }
        });
        timer1.setFocusable(false);
        invisible_1.setFocusable(false);

        //всякое для менюbar OFF

//menuBar ON -------------------------------------------------------------------

JComboBox spawnChanse_2 = new JComboBox();
TextField ZaycevNET_2 = new TextField();
JCheckBox lenta_2 = new JCheckBox();
ButtonGroup group_2 = new ButtonGroup();
JRadioButton visibel_2 = new JRadioButton();
JRadioButton invisible_2 = new JRadioButton();
B_2 = new JButton("START");
E_2 = new JButton("STOP");

spawnChanse_2.setFocusable(false);
ZaycevNET_2.setFocusable(false);
lenta_2.setFocusable(false);
visibel_2.setFocusable(false);
invisible_2.setFocusable(false);
B_2.setFocusable(false);
E_2.setFocusable(false);



spawnChanse_2.addItem("10%");
spawnChanse_2.addItem("20%");
spawnChanse_2.addItem("30%");
spawnChanse_2.addItem("40%");
spawnChanse_2.addItem("50%");
spawnChanse_2.addItem("60%");  
spawnChanse_2.addItem("70%");
spawnChanse_2.addItem("80%");
spawnChanse_2.addItem("90%");
spawnChanse_2.addItem("100%");           

        spawnChanse_2.setFocusable(false);
        spawnChanse_2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e )   {
                switch (spawnChanse_2.getSelectedIndex()) {
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

          ZaycevNET_2.setText("1000");
          ZaycevNET_2.setColumns(10);
          ZaycevNET_2.setFocusable(false);

        try {
            a = Integer.parseInt(ZaycevNET_2.getText());
        } catch (NumberFormatException e) {
            fail();
            ZaycevNET_2.setText("1000");
            a = 1000;
        }


        lenta_2.setFocusable(false);
        lenta_2.addItemListener((ItemListener) new ItemListener() {
            public void itemStateChanged(ItemEvent e )   {
                msgBox.setVisible(!msgBox.isVisible());
            }   
        });

        visibel_2 = new JRadioButton("VISIBLE TIME");
        group.add(visibel_2);
        // ZOV.add(visibel);
        ZOV.setFocusable(false);
        visibel.setFocusable(false);
        
        visibel_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SVO.habitat.numTimer = true;
                timer1.setVisible(SVO.habitat.numTimer);
            }
        });

        invisible_2 = new JRadioButton("INVISIBLE TIME");
        group.add(invisible_2);
        // ZOV.add(invisible_1);
        invisible_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SVO.habitat.numTimer = false;
                timer1.setVisible(SVO.habitat.numTimer);
            }
        });
        timer1.setFocusable(false);
        invisible_2.setFocusable(false);

        B_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SVO.habitat.toggleSimulation();
                B_2.setEnabled(false);
                E_2.setEnabled(true);
            }
        });

        E_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SVO.habitat.stopSimulation();
                newWindow();

            }
        });

        

        //всякое для менюbar OFF

JMenuBar menubar = new JMenuBar();
JMenu menu = new JMenu("menu");

JMenuItem itm = new JMenuItem("Start");
menu.add(itm);
itm.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        SVO.habitat.toggleSimulation();
        B.setEnabled(false);
        E.setEnabled(true);
    }
});

itm = new JMenuItem("Stop");
menu.add(itm);
itm.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        SVO.habitat.toggleSimulation();
        B.setEnabled(false);
        E.setEnabled(true);
    }
});


menubar.add(menu);
menubar.add(spawnChanse_1);
menubar.add(ZaycevNET_1);
menubar.add(lenta_1);
menubar.add(visibel_1);
menubar.add(invisible_1);

setJMenuBar(menubar); 


//menuBar OFF ----------------------------------------------------------------


//ToolBar ON
JToolBar tbCommon = new JToolBar();
        tbCommon.add(B_2);
        tbCommon.add(E_2);
        // tbCommon.addSeparator();
        tbCommon.add(spawnChanse_2);
        tbCommon.add(ZaycevNET_2);
        tbCommon.add(lenta_2);
        tbCommon.add(visibel_2);
        tbCommon.add(invisible_2);
        ZOV.add(tbCommon, BorderLayout.WEST);
//ToolBar OFF



        setFocusable(true);
        pack();
        setVisible(true);
    }

    TextArea getText1() {
        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setFocusable(false);

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
        textArea.setFocusable(false);

        return textArea;
    }
    
    void newWindow() {
        msgBox = new MessageBox("String of message", new JFrame(), "Message box", true, this, true);
        msgBox.setFocusable(false);

    }

    void fail(){
        Error = new MessageBox("String of message", new JFrame(), "Message box", true, this, false);
        Error.setFocusable(false);

        setVisible(true);
    }

    public static void main(String[] args) {
        App app = new App();
    }
}

// Говнокод OFF