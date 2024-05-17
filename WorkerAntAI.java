// import java.util.Random;

// class WorkerAntAI extends BaseAI {
//     Habitat habitat;
//     Random random = new Random();

//     WorkerAntAI(Habitat habitat) {
//         this.habitat = habitat;
//     }

//     @Override
//     public void moveAi() {

//     }
// }

// import java.util.Random;

// class WorkerAntAI extends BaseAI {
//     Habitat habitat;
//     Random random = new Random();

//     WorkerAntAI(Habitat habitat) {
//         this.habitat = habitat;
//     }

//     @Override
//     public void moveAi() {
//         for (AntWorker ant : habitat.Ants2) {
//             ant.moveTowardsTarget();
//         }
//     }
// }

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class WorkerAntAI extends BaseAI {
    Habitat habitat;
    Random random = new Random();

    WorkerAntAI(Habitat habitat) {
        this.habitat = habitat;
    }

    @Override
    public void moveAi() {
        List<AntWorker> antsCopy;
        synchronized (habitat.Ants2) {
            antsCopy = new ArrayList<>(habitat.Ants2);
        }
        for (AntWorker ant : antsCopy) {
            ant.moveTowardsTarget();
        }
    }
}