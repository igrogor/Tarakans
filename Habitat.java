import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Habitat   {
    String window;
    String Deats_warrior;
    String Deats_worker;
    //Image a;
    public int Tarakan_1;
    public int Tarakan_2;
    public int Tarakan_1_Dead;
    public int Tarakan_2_Dead;
    boolean simulationRunning;
    Timer timer;
    ArrayList<AntWarrior> Ants1 = new ArrayList<AntWarrior>();
    ArrayList<AntWorker> Ants2 = new ArrayList<AntWorker>();
    int simulationTime;
    boolean num = false;
    boolean numTimer = false;
    int timer_1;

    Habitat() {

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
            }
        }, 0, 1000);
    }
        
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

    void Update( ArrayList<AntWarrior> Ants1, ArrayList<AntWorker> Ants2) {
        Random rand = new Random();
        int x1 = rand.nextInt(10);
        int x2 = rand.nextInt(10);
        int x6 = rand.nextInt(10);
        int x3 = Ants1.isEmpty() ? 0 : rand.nextInt(Ants1.size());
        int x5 = Ants2.isEmpty() ? 0 : rand.nextInt(Ants2.size());
        int x4 = rand.nextInt(2);

        if (x1 > 3) {
            if(x4 == 1){
                Ants1.add(new AntWarrior());
                Tarakan_1++;
            }else{
                Ants2.add(new AntWorker());
                Tarakan_2++;
            }  
        }
        if (!Ants1.isEmpty() && x2 > 7) {
            Ants1.remove(x3); 
            Tarakan_1_Dead++;
        }
        if (!Ants2.isEmpty() && x6 > 7) {
            Ants2.remove(x5); 
            Tarakan_2_Dead++;
        }
    }
    
    public void Static(int num){

         window = new String("Ants warriorscreated - " + Tarakan_1 + " Ants workers created - " + Tarakan_2 );
         Deats_warrior = new String("Ants warriors died - " + Tarakan_1_Dead);
         Deats_worker = new String(" Ants workers died - " + Tarakan_2_Dead);
        System.out.println(num);
    }
}

