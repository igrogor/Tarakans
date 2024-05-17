import java.util.Random;
import java.util.Vector;

class WorkerAntAI extends BaseAI {
    Habitat New_Worker;
    App Morder;
    double speed = 0.1;
    boolean isFinPoint = true;
    Random rand = new Random();
    // int direction = 0;
    // int pre_direction = 5;
    // int direction = rand.nextInt(4);

    // 0 - left top
    // 1 - right top
    // 2 - left down
    // 3 - right down
    // 5 - home

    public WorkerAntAI(Habitat New_Worker) {
        this.New_Worker = New_Worker;
    }

    // public synchronized void moveAi() {
    //     for (int i = 0; i < New_Worker.Ants2.size(); i++) {
    //         // if (!isFinPoint) {
    //         // try {
    //         // New_Worker.Ants2.wait();
    //         // }
    //         // catch(InterruptedException e){
    //         // System.out.println("InterruptedException");
    //         // }
    //         // }
    //         if (isFinPoint) {

    //             // System.out.println("direction - " + New_Worker.Ants2.get(i).direction);
    //             switch (New_Worker.Ants2.get(i).direction) {
    //                 case 0:
    //                     New_Worker.Ants2.get(i).x = speed * (New_Worker.Ants2.get(i).y / New_Worker.Ants2.get(i).x)
    //                             - New_Worker.Ants2.get(i).x;
    //                     New_Worker.Ants2.get(i).y = speed * (New_Worker.Ants2.get(i).x / New_Worker.Ants2.get(i).y)
    //                             - New_Worker.Ants2.get(i).y;

    //                     if (New_Worker.Ants2.get(i).x == 0 && New_Worker.Ants2.get(i).y == 0) {
    //                         New_Worker.Ants2.get(i).pre_direction = 0;
    //                         New_Worker.Ants2.get(i).direction = 4;
    //                     }
    //                     break;
    //                 case 1:
    //                     New_Worker.Ants2.get(i).x = speed * (New_Worker.Ants2.get(i).y / New_Worker.Ants2.get(i).x)
    //                             + New_Worker.Ants2.get(i).x;
    //                     New_Worker.Ants2.get(i).y = speed * (New_Worker.Ants2.get(i).x / New_Worker.Ants2.get(i).y)
    //                             - New_Worker.Ants2.get(i).y;

    //                     if (New_Worker.Ants2.get(i).x == 800 && New_Worker.Ants2.get(i).y == 0) {
    //                         New_Worker.Ants2.get(i).pre_direction = 1;
    //                         New_Worker.Ants2.get(i).direction = 4;
    //                     }
    //                     break;
    //                 case 2:
    //                     New_Worker.Ants2.get(i).x = speed * (New_Worker.Ants2.get(i).x / New_Worker.Ants2.get(i).y)
    //                             - New_Worker.Ants2.get(i).x;
    //                     New_Worker.Ants2.get(i).y = speed * (New_Worker.Ants2.get(i).y / New_Worker.Ants2.get(i).x)
    //                             + New_Worker.Ants2.get(i).y;

    //                     if (New_Worker.Ants2.get(i).x == 0 && New_Worker.Ants2.get(i).y == 800) {
    //                         New_Worker.Ants2.get(i).pre_direction = 2;
    //                         New_Worker.Ants2.get(i).direction = 4;
    //                     }
    //                     break;
    //                 case 3:
    //                     New_Worker.Ants2.get(i).x = speed * (New_Worker.Ants2.get(i).x / New_Worker.Ants2.get(i).y)
    //                             + New_Worker.Ants2.get(i).x;
    //                     New_Worker.Ants2.get(i).y = speed * (New_Worker.Ants2.get(i).y / New_Worker.Ants2.get(i).x)
    //                             + New_Worker.Ants2.get(i).y;

    //                     if (New_Worker.Ants2.get(i).x == 800 && New_Worker.Ants2.get(i).y == 800) {
    //                         New_Worker.Ants2.get(i).pre_direction = 3;
    //                         New_Worker.Ants2.get(i).direction = 4;
    //                     }
    //                     break;
    //                 case 4:
    //                     switch (New_Worker.Ants2.get(i).pre_direction) {
    //                         case 0:
    //                             New_Worker.Ants2.get(i).x = speed
    //                                     * (New_Worker.Ants2.get(i).x / New_Worker.Ants2.get(i).y)
    //                                     + New_Worker.Ants2.get(i).x;
    //                             New_Worker.Ants2.get(i).y = speed
    //                                     * (New_Worker.Ants2.get(i).y / New_Worker.Ants2.get(i).x)
    //                                     + New_Worker.Ants2.get(i).y;
    //                             break;
    //                         case 1:
    //                             New_Worker.Ants2.get(i).x = speed
    //                                     * (New_Worker.Ants2.get(i).x / New_Worker.Ants2.get(i).y)
    //                                     - New_Worker.Ants2.get(i).x;
    //                             New_Worker.Ants2.get(i).y = speed
    //                                     * (New_Worker.Ants2.get(i).y / New_Worker.Ants2.get(i).x)
    //                                     + New_Worker.Ants2.get(i).y;
    //                             break;
    //                         case 2:
    //                             New_Worker.Ants2.get(i).x = speed
    //                                     * (New_Worker.Ants2.get(i).x / New_Worker.Ants2.get(i).y)
    //                                     + New_Worker.Ants2.get(i).x;
    //                             New_Worker.Ants2.get(i).y = speed
    //                                     * (New_Worker.Ants2.get(i).y / New_Worker.Ants2.get(i).x)
    //                                     - New_Worker.Ants2.get(i).y;
    //                             break;
    //                         case 3:
    //                             New_Worker.Ants2.get(i).x = speed
    //                                     * (New_Worker.Ants2.get(i).x / New_Worker.Ants2.get(i).y)
    //                                     - New_Worker.Ants2.get(i).x;
    //                             New_Worker.Ants2.get(i).y = speed
    //                                     * (New_Worker.Ants2.get(i).y / New_Worker.Ants2.get(i).x)
    //                                     - New_Worker.Ants2.get(i).y;
    //                             break;

    //                         default:
    //                             break;
    //                     }
    //                     if (New_Worker.Ants2.get(i).x == New_Worker.Ants2.get(i).homeX
    //                             && New_Worker.Ants2.get(i).y == New_Worker.Ants2.get(i).homeY) {
    //                         New_Worker.Ants2.get(i).pre_direction = 4;
    //                         New_Worker.Ants2.get(i).direction = rand.nextInt(4);
    //                     }
    //                     break;

    //                 default:
    //                     break;
    //             }
    //         }
    //     }
    // }
    public synchronized void moveAi() {
        for (int i = 0; i < New_Worker.Ants2.size(); i++) {


        }
    }


}