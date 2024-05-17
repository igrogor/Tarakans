// Говнокод ON

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
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
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.lang.Thread;

public class App extends JFrame {
    static JPanel MariaRa;
    static JPanel BAR;
    static Rivyera Magnit;
    MessageBox msgBox;
    MessageBox Error;
    JLabel timer1;
    int period = 500;
    TextField ZaycevNET;
    TextField SetSpead;
    TextField Mikhail_Evdokimov;
    int a = 1000;
    int HARDBASS = 10000000;
    JButton B;
    JButton E;
    JButton B_2;
    JButton E_2;
    JButton awake;
    JButton sleep;
    BaseAI DmitryShilow;
    WorkerAntAI workerAI;
    WarriorAntAI warriorAI;

    public App() {

        setSize(2, 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        B = new JButton("START");
        B.setFont(new Font("Papyrus", Font.ITALIC, 40));
        E = new JButton("STOP");
        MariaRa = new JPanel();
        MariaRa.setBackground(new Color(201, 139, 91));
        MariaRa.add(B);
        MariaRa.add(E);
        Magnit = new Rivyera(this);
        workerAI = new WorkerAntAI(Magnit.habitat);
        warriorAI = new WarriorAntAI(Magnit.habitat);

        warriorAI.start();
        workerAI.start();

        timer1 = new JLabel(String.valueOf(Magnit.habitat.timer_1 / 40000));
        timer1.setVisible(Magnit.habitat.numTimer);
        B.setFocusable(false);
        E.setFocusable(false);
        // статистика по такраканам ON
        // -------------------------------------------------------
        ButtonGroup group = new ButtonGroup();
        JRadioButton visibel, invisible;
        visibel = new JRadioButton("VISIBLE TIME");
        group.add(visibel);
        MariaRa.add(visibel);
        MariaRa.setFocusable(false);
        visibel.setFocusable(false);

        visibel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Magnit.habitat.numTimer = true;
                timer1.setVisible(Magnit.habitat.numTimer);
            }
        });

        invisible = new JRadioButton("INVISIBLE TIME");
        group.add(invisible);
        MariaRa.add(invisible);
        invisible.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Magnit.habitat.numTimer = false;
                timer1.setVisible(Magnit.habitat.numTimer);
            }
        });
        timer1.setFocusable(false);

        invisible.setFocusable(false);
        // OFF------------------------------------------------------------------------------------

        // start "Tarakan the game"
        // -------------------------------------------------------------------
        B.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Magnit.habitat.toggleSimulation();
                B.setEnabled(false);
                E.setEnabled(true);
            }
        });

        E.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Magnit.habitat.stopSimulation();
                // статистика по тараканам
                // MariaRa.add(textArea);
                newWindow();

            }
        });

        // stop "Tarakan the game"
        // ------------------------------------------------------------------

        MariaRa.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, Color.BLACK));

        add(MariaRa, BorderLayout.WEST);
        add(Magnit, BorderLayout.CENTER);

        MariaRa.setFocusable(false);
        Magnit.setFocusable(false);

        Timer timer = new Timer(100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Magnit.repaint();
            }
        });

        timer.start();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_B) {
                    System.out.println("B");
                    Magnit.habitat.toggleSimulation();
                }

                if (e.getKeyCode() == KeyEvent.VK_E) {
                    System.out.println("E");
                    Magnit.habitat.stopSimulation();
                    newWindow();
                    msgBox.setVisible(true);
                }

                if (e.getKeyCode() == KeyEvent.VK_T) {
                    System.out.println("T");
                    Magnit.habitat.numTimer = !Magnit.habitat.numTimer;
                    visibel.setSelected(Magnit.habitat.numTimer);// --- ???????????????????????????????????????
                    invisible.setSelected(!Magnit.habitat.numTimer);// ----??????????????????????????????
                    timer1.setVisible(Magnit.habitat.numTimer);

                }
            }
        });

        JCheckBox lenta = new JCheckBox("statistic");
        lenta.setFocusable(false);

        lenta.addItemListener((ItemListener) new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                msgBox.setVisible(!msgBox.isVisible());
            }
        });

        // установка периода ON
        ZaycevNET = new TextField();
        ZaycevNET.setText("1000");
        ZaycevNET.setColumns(10);
        ZaycevNET.setFocusable(true);

        try {
            a = Integer.parseInt(ZaycevNET.getText());
        } catch (NumberFormatException e) {
            fail();
            ZaycevNET.setText("1000");
            a = 1000;
        }
        MariaRa.add(ZaycevNET);
        // установка периода OFF

        // // установка СКОРОСТИ ON
        // SetSpead = new TextField();
        // SetSpead.setText("0.1");
        // SetSpead.setColumns(10);
        // SetSpead.setFocusable(true);

        // try {
        // Ant.speed = Double.parseDouble(SetSpead.getText());
        // } catch (NumberFormatException e) {
        // fail();
        // SetSpead.setText("0.1");
        // Ant.speed = 0.1;
        // }
        // MariaRa.add(SetSpead);
        // // установка СКОРОСТИ OFF

        JComboBox speedChanse = new JComboBox();
        speedChanse.addItem("speed - 1");
        speedChanse.addItem("speed - 2");
        speedChanse.addItem("speed - 3");
        speedChanse.addItem("speed - 4");
        speedChanse.addItem("speed - 5");
        speedChanse.addItem("speed - 6");
        speedChanse.addItem("speed - 7");
        speedChanse.addItem("speed - 8");
        speedChanse.addItem("speed - 9");
        speedChanse.addItem("speed - 10");
        MariaRa.add(speedChanse);
        speedChanse.setFocusable(false);

        speedChanse.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                switch (speedChanse.getSelectedIndex()) {
                    case 1:
                        Ant.speed = 0.1;
                        break;
                    case 2:
                        Ant.speed = 1;
                        break;
                    case 3:
                        Ant.speed = 2;
                        break;
                    case 4:
                        Ant.speed = 3;
                        break;
                    case 5:
                        Ant.speed = 4;
                        break;
                    case 6:
                        Ant.speed = 5;
                        break;
                    case 7:
                        Ant.speed = 6;
                        break;
                    case 8:
                        Ant.speed = 7;
                        break;
                    case 9:
                        Ant.speed = 8;
                        break;
                    case 10:
                        Ant.speed = 9;
                        break;
                    default:
                        Ant.speed = 100;
                        break;
                }
            }
        });
        // speed OFF

        JComboBox radiusChanse = new JComboBox();
        radiusChanse.addItem("speed - 1");
        radiusChanse.addItem("speed - 2");
        radiusChanse.addItem("speed - 3");
        radiusChanse.addItem("speed - 4");
        radiusChanse.addItem("speed - 5");
        radiusChanse.addItem("speed - 6");
        radiusChanse.addItem("speed - 7");
        radiusChanse.addItem("speed - 8");
        radiusChanse.addItem("speed - 9");
        radiusChanse.addItem("speed - 10");
        MariaRa.add(radiusChanse);
        radiusChanse.setFocusable(false);

        radiusChanse.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                switch (radiusChanse.getSelectedIndex()) {
                    case 1:
                        WarriorAntAI.radius = 101;
                        break;
                    case 2:
                        WarriorAntAI.radius = 1;
                        break;
                    case 3:
                        WarriorAntAI.radius = 5;
                        break;
                    case 4:
                        WarriorAntAI.radius = 10;
                        break;
                    case 5:
                        WarriorAntAI.radius = 25;
                        break;
                    case 6:
                        WarriorAntAI.radius = 50;
                        break;
                    case 7:
                        WarriorAntAI.radius = 100;
                        break;
                    case 8:
                        WarriorAntAI.radius = 200;
                        break;
                    case 9:
                        WarriorAntAI.radius = 300;
                        break;
                    case 10:
                        WarriorAntAI.radius = 400;
                        break;
                    default:
                        WarriorAntAI.radius = 500;
                        break;
                }
            }
        });

        // установка времени жизни ON
        Mikhail_Evdokimov = new TextField();
        Mikhail_Evdokimov.setText("30");
        Mikhail_Evdokimov.setColumns(10);
        Mikhail_Evdokimov.setFocusable(true);

        try {
            HARDBASS = Integer.parseInt(Mikhail_Evdokimov.getText());
        } catch (NumberFormatException e) {
            fail();
            Mikhail_Evdokimov.setText("30");
            HARDBASS = 1000;
        }
        MariaRa.add(Mikhail_Evdokimov);
        // установка времени жизни OFF

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
        MariaRa.add(spawnChanse);
        spawnChanse.setFocusable(false);

        spawnChanse.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                switch (spawnChanse.getSelectedIndex()) {
                    case 1:
                        Magnit.habitat.nuclearBomb = 9;
                        break;
                    case 2:
                        Magnit.habitat.nuclearBomb = 8;
                        break;
                    case 3:
                        Magnit.habitat.nuclearBomb = 7;
                        break;
                    case 4:
                        Magnit.habitat.nuclearBomb = 6;
                        break;
                    case 5:
                        Magnit.habitat.nuclearBomb = 5;
                        break;
                    case 6:
                        Magnit.habitat.nuclearBomb = 4;
                        break;
                    case 7:
                        Magnit.habitat.nuclearBomb = 3;
                        break;
                    case 8:
                        Magnit.habitat.nuclearBomb = 2;
                        break;
                    case 9:
                        Magnit.habitat.nuclearBomb = 1;
                        break;
                    case 10:
                        Magnit.habitat.nuclearBomb = 0;
                        break;
                    default:
                        Magnit.habitat.nuclearBomb = 9;
                        break;
                }
            }
        });
        // spawn OFF

        MariaRa.add(lenta);
        MariaRa.add(timer1, BorderLayout.EAST);

        // всякое для менюbar ON

        JComboBox spawnChanse_1 = new JComboBox();
        TextField ZaycevNET_1 = new TextField();
        JCheckBox lenta_1 = new JCheckBox();
        ButtonGroup group_1 = new ButtonGroup();
        JRadioButton visibel_1 = new JRadioButton();
        JRadioButton invisible_1 = new JRadioButton();

        spawnChanse_1.setFocusable(false);
        ZaycevNET_1.setFocusable(true);
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
        spawnChanse_1.setFocusable(false);
        spawnChanse_1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                switch (spawnChanse_1.getSelectedIndex()) {
                    case 1:
                        Magnit.habitat.nuclearBomb = 9;
                        break;
                    case 2:
                        Magnit.habitat.nuclearBomb = 8;
                        break;
                    case 3:
                        Magnit.habitat.nuclearBomb = 7;
                        break;
                    case 4:
                        Magnit.habitat.nuclearBomb = 6;
                        break;
                    case 5:
                        Magnit.habitat.nuclearBomb = 5;
                        break;
                    case 6:
                        Magnit.habitat.nuclearBomb = 4;
                        break;
                    case 7:
                        Magnit.habitat.nuclearBomb = 3;
                        break;
                    case 8:
                        Magnit.habitat.nuclearBomb = 2;
                        break;
                    case 9:
                        Magnit.habitat.nuclearBomb = 1;
                        break;
                    case 10:
                        Magnit.habitat.nuclearBomb = 0;
                        break;
                    default:
                        Magnit.habitat.nuclearBomb = 9;
                        break;
                }
            }
        });

        ZaycevNET_1.setText("1000");
        ZaycevNET_1.setColumns(10);
        ZaycevNET_1.setFocusable(false);

        try {
            a = Integer.parseInt(ZaycevNET_1.getText());
            if (a < 0)
                throw new NumberFormatException();
        } catch (NumberFormatException e) {
            fail();
            ZaycevNET_1.setText("1000");
            a = 1000;
        }

        lenta_1.setFocusable(false);
        lenta_1.addItemListener((ItemListener) new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                msgBox.setVisible(!msgBox.isVisible());
            }
        });

        visibel_1 = new JRadioButton("VISIBLE TIME");
        group.add(visibel_1);
        MariaRa.setFocusable(false);
        visibel.setFocusable(false);

        visibel_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Magnit.habitat.numTimer = true;
                timer1.setVisible(Magnit.habitat.numTimer);
            }
        });

        invisible_1 = new JRadioButton("INVISIBLE TIME");
        group.add(invisible_1);
        invisible_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Magnit.habitat.numTimer = false;
                timer1.setVisible(Magnit.habitat.numTimer);
            }
        });
        timer1.setFocusable(false);
        invisible_1.setFocusable(false);

        // всякое для менюbar OFF

        // menuBar ON
        // -------------------------------------------------------------------

        JComboBox spawnChanse_2 = new JComboBox();
        TextField ZaycevNET_2 = new TextField();
        JCheckBox lenta_2 = new JCheckBox();
        ButtonGroup group_2 = new ButtonGroup();
        JRadioButton visibel_2 = new JRadioButton();
        JRadioButton invisible_2 = new JRadioButton();
        B_2 = new JButton("START");
        E_2 = new JButton("STOP");

        spawnChanse_2.setFocusable(false);
        ZaycevNET_2.setFocusable(true);
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
            public void itemStateChanged(ItemEvent e) {
                switch (spawnChanse_2.getSelectedIndex()) {
                    case 1:
                        Magnit.habitat.nuclearBomb = 9;
                        break;
                    case 2:
                        Magnit.habitat.nuclearBomb = 8;
                        break;
                    case 3:
                        Magnit.habitat.nuclearBomb = 7;
                        break;
                    case 4:
                        Magnit.habitat.nuclearBomb = 6;
                        break;
                    case 5:
                        Magnit.habitat.nuclearBomb = 5;
                        break;
                    case 6:
                        Magnit.habitat.nuclearBomb = 4;
                        break;
                    case 7:
                        Magnit.habitat.nuclearBomb = 3;
                        break;
                    case 8:
                        Magnit.habitat.nuclearBomb = 2;
                        break;
                    case 9:
                        Magnit.habitat.nuclearBomb = 1;
                        break;
                    case 10:
                        Magnit.habitat.nuclearBomb = 0;
                        break;
                    default:
                        Magnit.habitat.nuclearBomb = 9;
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
            public void itemStateChanged(ItemEvent e) {
                msgBox.setVisible(!msgBox.isVisible());
            }
        });

        visibel_2 = new JRadioButton("VISIBLE TIME");
        group.add(visibel_2);
        MariaRa.setFocusable(false);
        visibel.setFocusable(false);

        visibel_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Magnit.habitat.numTimer = true;
                timer1.setVisible(Magnit.habitat.numTimer);
            }
        });

        invisible_2 = new JRadioButton("INVISIBLE TIME");
        group.add(invisible_2);

        invisible_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Magnit.habitat.numTimer = false;
                timer1.setVisible(Magnit.habitat.numTimer);
            }
        });
        timer1.setFocusable(false);
        invisible_2.setFocusable(false);

        B_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Magnit.habitat.toggleSimulation();
                B_2.setEnabled(false);
                E_2.setEnabled(true);
            }
        });

        E_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Magnit.habitat.stopSimulation();
                newWindow();

            }
        });

        // всякое для менюbar OFF

        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("menu");

        JMenuItem itm = new JMenuItem("Start");
        menu.add(itm);
        itm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Magnit.habitat.toggleSimulation();
                B.setEnabled(false);
                E.setEnabled(true);
            }
        });

        itm = new JMenuItem("Stop");
        menu.add(itm);
        itm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Magnit.habitat.toggleSimulation();
                B.setEnabled(false);
                E.setEnabled(true);
            }
        });

        menubar.add(menu);
        menubar.add(lenta_1);
        menubar.add(visibel_1);
        menubar.add(invisible_1);

        setJMenuBar(menubar);

        // menuBar OFF ----------------------------------------------------------------

        // ToolBar ON
        JToolBar tbCommon = new JToolBar();
        tbCommon.add(B_2);
        tbCommon.add(E_2);

        tbCommon.add(lenta_2);
        tbCommon.add(visibel_2);
        tbCommon.add(invisible_2);
        MariaRa.add(tbCommon, BorderLayout.WEST);
        // ToolBar OFF

        // Объекты ON
        JButton currentObjectsButton = new JButton("Текущие объекты");
        currentObjectsButton.addActionListener(e -> {
            new ObjectListDialog(this, Magnit.habitat.birthTimes).setVisible(true);
        });
        MariaRa.add(currentObjectsButton);

        sleep = new JButton("SLEEP");
        awake = new JButton("AWAKE");

        sleep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                workerAI.pauseAi();
                warriorAI.pauseAi();
            }
        });

        awake.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                workerAI.resumAi();
                warriorAI.resumAi();
            }
        });

        sleep.setFocusable(false);
        awake.setFocusable(false);

        MariaRa.add(sleep);
        MariaRa.add(awake);

        // workerAI.pauseAi();
        // warriorAI.pauseAi();

        // Объекты OFF

        setFocusable(true);
        pack();
        setVisible(true);
    }

    TextArea getText1() {
        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setFocusable(false);

        textArea.setText("\n Ants warriorscreated - " + App.Magnit.habitat.Tarakan_1 + "\n Ants workers created - "
                + App.Magnit.habitat.Tarakan_2 + "\nAnts warriors died - " + App.Magnit.habitat.Tarakan_1_Dead
                + "\nAnts workers died - " + App.Magnit.habitat.Tarakan_2_Dead + "\n");
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

    void fail() {
        Error = new MessageBox("String of message", new JFrame(), "Message box", true, this, false);
        Error.setFocusable(false);

        setVisible(true);
    }

    public static void main(String[] args) {
        // Habitat habitat = new Habitat(); // Предполагая, что Habitat - это ваш класс

        App app = new App(); // Передача объектов workerAI и warriorAI в конструктор App
    }
}

// Говнокод OFF