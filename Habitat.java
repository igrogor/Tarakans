import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.Vector;

public class Habitat implements java.io.Serializable {
    String window;
    String Deats_warrior;
    String Deats_worker;
    // Image a;
    public int Tarakan_1;
    public int Tarakan_2;
    public int Tarakan_1_Dead;
    public int Tarakan_2_Dead;
    boolean simulationRunning;
    transient Timer timer;
    // ArrayList<AntWarrior> Ants1 = new ArrayList<AntWarrior>();
    // ArrayList<AntWorker> Ants2 = new ArrayList<AntWorker>();
    int simulationTime;
    boolean num = false;
    boolean numTimer = false;
    int timer_1;
    int nuclearBomb = 9;
    transient App chan;

    int warriorLifeTime = 1000000;
    int workerLifeTime = 1000000;

    Vector<AntWarrior> Ants1 = new Vector<>();
    Vector<AntWorker> Ants2 = new Vector<>();
    HashSet<Integer> antIds = new HashSet<>();
    TreeMap<Integer, Integer> birthTimes = new TreeMap<>();

    public Habitat() {
    }

    Habitat(App Si3Pio) {
        chan = Si3Pio;
        Ants1 = new Vector<>();
        antIds = new HashSet<>();
        birthTimes = new TreeMap<>();

    }

    public void setWarriorLifeTime(int lifeTime) {
        this.warriorLifeTime = lifeTime;
    }

    public void setWorkerLifeTime(int lifeTime) {
        this.workerLifeTime = lifeTime;
    }

    int setTarakan1() {
        return Tarakan_1;
    }

    int setTarakan2() {
        return Tarakan_2;
    }

    int setTarakan1_dead() {
        return Tarakan_1_Dead;
    }

    int setTarakan2_dead() {
        return Tarakan_2_Dead;
    }

    public void startSimulation() {
        simulationRunning = true;
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Update(Ants1, Ants2);
                simulationTime++;
                timer_1++;
                chan.timer1.setText(String.valueOf(timer_1));
                try {
                    chan.a = Integer.parseInt(chan.ZaycevNET.getText());
                    if (chan.a < 0)
                        throw new NumberFormatException();
                } catch (NumberFormatException e) {
                    chan.fail();
                    chan.ZaycevNET.setText("1000");
                    chan.a = 1000;
                }
            }
        }, 0, 25);
    }// -------------------------------------------------------------------------------------------------------
     // A

    public void stopSimulation() {
        simulationRunning = false;
        timer.cancel();
        timer.purge();
        Ants1.clear();
        Ants2.clear();
        timer_1 = 0;
    }

    public void toggleSimulation() {
        if (simulationRunning) {
            stopSimulation();
        } else {
            resetTarakan_1();
            resetTarakan_2();
            startSimulation();
        }
    }

    private void resetTarakan_1() {
        Tarakan_1 = 0;
    }

    private void resetTarakan_2() {
        Tarakan_2 = 0;
    }

    public int getNumStudents() {
        return Tarakan_1;
    }

    public int getNumStudentGirls() {
        return Tarakan_2;
    }

    void Update(Vector<AntWarrior> Ants1, Vector<AntWorker> Ants2) {
        Random rand = new Random();
        int x1 = rand.nextInt(10);
        int x2 = rand.nextInt(10);
        int x6 = rand.nextInt(10);
        int x3 = Ants1.isEmpty() ? 0 : rand.nextInt(Ants1.size());
        int x5 = Ants2.isEmpty() ? 0 : rand.nextInt(Ants2.size());
        int x4 = rand.nextInt(2);
        // Безумие ON

        // if (timer_1 % (chan.a / 1000) == 0) {
        if (x1 > nuclearBomb) {
            if (x4 == 1) {

                Tarakan_1++;

                AntWarrior ant = new AntWarrior(simulationTime, chan);
                Ants1.add(ant);
                antIds.add(ant.id);
                birthTimes.put(ant.id, ant.birthTime);
            } else {

                Tarakan_2++;

                AntWorker ant = new AntWorker(simulationTime, chan);
                Ants2.add(ant);
                antIds.add(ant.id);
                birthTimes.put(ant.id, ant.birthTime);
            }
        }

        for (AntWarrior ant : Ants1) {
            if (!ant.isAlive(simulationTime)) {
                antIds.remove(ant.id);
                birthTimes.remove(ant.id);

                Tarakan_1_Dead++;
            }
        }

        for (AntWorker ant : Ants2) {
            if (!ant.isAlive(simulationTime)) {
                antIds.remove(ant.id);
                birthTimes.remove(ant.id);

                Tarakan_2_Dead++;
            }
        }
        // }
        Ants1.removeIf(ant -> !ant.isAlive(simulationTime));
        Ants2.removeIf(ant -> !ant.isAlive(simulationTime));
    }

    // Безумие OFF
    public void Static(int num) {

        window = new String("Ants warriorscreated - " + Tarakan_1 + " Ants workers created - " + Tarakan_2);
        Deats_warrior = new String("Ants warriors died - " + Tarakan_1_Dead);
        Deats_worker = new String(" Ants workers died - " + Tarakan_2_Dead);
        System.out.println(num);
    }
}
