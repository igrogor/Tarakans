
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// class WorkerAntAI extends BaseAI {
//     Habitat habitat;
//     Random random = new Random();

//     WorkerAntAI(Habitat habitat) {
//         this.habitat = habitat;
//     }

//     @Override
//     public void moveAi() {
//         List<AntWorker> antsCopy;
//         synchronized (habitat.Ants2) {
//             antsCopy = new ArrayList<>(habitat.Ants2);
//         }
//         for (AntWorker ant : antsCopy) {
//             ant.moveTowardsTarget();
//         }
//     }
// }


class WorkerAntAI extends BaseAI {
    Habitat habitat;
    Random random = new Random();

    WorkerAntAI(Habitat habitat) {
        this.habitat = habitat;
    }

    @Override
    public synchronized void moveAi() {
        List<AntWorker> antsCopy;
        synchronized (habitat.Ants2) {
            antsCopy = new ArrayList<>(habitat.Ants2);
        }

        for (AntWorker ant : antsCopy) {
            // Проверяем itsWork внутри цикла
            synchronized (this) { 
                if (!itsWork) {
                    try {
                        wait(); // Ожидание, пока поток не будет разблокирован
                    } catch (InterruptedException e) {
                        // Обработка прерывания
                    }
                }
            }
            ant.moveTowardsTarget();
        }
    }
}