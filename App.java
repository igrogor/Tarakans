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

JComboBox spawnChanse_1 = spawnChanse;
TextField ZaycevNET_1 = ZaycevNET;
JCheckBox lenta_1 = lenta;
ButtonGroup group_1 = group;
JRadioButton visibel_1 = visibel;
JRadioButton invisible_1 = invisible;

//menuBar ON -------------------------------------------------------------------

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
// JToolBar tbCommon = new JToolBar();
//         tbCommon.add(E);
//         tbCommon.add(B);
//         // tbCommon.addSeparator();
//         tbCommon.add(spawnChanse);
//         tbCommon.add(ZaycevNET);
//         tbCommon.add(lenta);
//         tbCommon.add(visibel);
//         tbCommon.add(invisible);
//         ZOV.add(tbCommon, BorderLayout.SOUTH);
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