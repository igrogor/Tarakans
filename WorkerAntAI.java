import java.util.Random;
import java.util.Vector;

class WorkerAntAI extends BaseAI {
    Habitat New_Worker;
    App Morder;
    int speed = 1;
    Random rand = new Random();

    public WorkerAntAI(Habitat New_Worker) {
        this.New_Worker = New_Worker;
    }

    // public void moveAi() {
    //     for (int i = 0; i < New_Worker.Ants1.size(); i++) {
    //         if (i < New_Worker.Ants1.size()) {
    //             if (New_Worker.Ants1.get(i).returning) {
    //                 // Движение назад к точке рождения
    //                 int dx = New_Worker.Ants1.get(i).homeX - New_Worker.Ants1.get(i).x;
    //                 int dy = New_Worker.Ants1.get(i).homeY - New_Worker.Ants1.get(i).y;
    //                 double distance = Math.sqrt(dx * dx + dy * dy);
    //                  // Установите скорость движения
    //                 if (distance > speed) {
    //                     New_Worker.Ants1.get(i).x += (int) (speed * dx / distance);
    //                     New_Worker.Ants1.get(i).y += (int) (speed * dy / distance);
    //                 } else {
    //                     New_Worker.Ants1.get(i).x = New_Worker.Ants1.get(i).homeX;
    //                     New_Worker.Ants1.get(i).y = New_Worker.Ants1.get(i).homeY;
    //                     New_Worker.Ants1.get(i).returning = false; // Прибыли в точку рождения, перестаем возвращаться
    //                 }
    //             } else {
    //                 // Движение к углу области обитания
    //                 // Например, если муравей движется в левый верхний угол (0, 0)
    //                 int cornerX = 0;
    //                 int cornerY = 0;
    //                 int dx = cornerX - New_Worker.Ants1.get(i).x;
    //                 int dy = cornerY - New_Worker.Ants1.get(i).y;
    //                 double distance = Math.sqrt(dx * dx + dy * dy);
    //                 int speed = 10; // Установите скорость движения
    //                 if (distance > speed) {
    //                     New_Worker.Ants1.get(i).x += (int) (speed * dx / distance);
    //                     New_Worker.Ants1.get(i).y += (int) (speed * dy / distance);
    //                 } else {
    //                     New_Worker.Ants1.get(i).x = cornerX;
    //                     New_Worker.Ants1.get(i).y = cornerY;
    //                     New_Worker.Ants1.get(i).returning = true; // Достигли угла, начинаем возвращаться
    //                 }
    //             }
    //         }
    //     }
    // }

    public void moveAi() {
        int speed = 1; // Устанавливаем скорость движения муравьев
    
        for (int i = 0; i < New_Worker.Ants1.size(); i++) {
            if (!(New_Worker.Ants1.get(i).x > 800 || New_Worker.Ants1.get(i).x < 0 || New_Worker.Ants1.get(i).y > 790 || New_Worker.Ants1.get(i).y < 10)) {
                // Если муравей не находится на границе области, переместить его в случайный угол
                int angle = rand.nextInt(4); // Генерация случайного угла: 0 - верхний левый, 1 - верхний правый, 2 - нижний левый, 3 - нижний правый
    
                switch (angle) {
                    case 0: // верхний левый угол
                        moveTo(New_Worker.Ants1.get(i), 0, 0, speed); // Переместить муравья к верхнему левому углу
                        break;
                    case 1: // верхний правый угол
                        moveTo(New_Worker.Ants1.get(i), 800, 0, speed); // Переместить муравья к верхнему правому углу
                        break;
                    case 2: // нижний левый угол
                        moveTo(New_Worker.Ants1.get(i), 0, 790, speed); // Переместить муравья к нижнему левому углу
                        break;
                    case 3: // нижний правый угол
                        moveTo(New_Worker.Ants1.get(i), 800, 790, speed); // Переместить муравья к нижнему правому углу
                        break;
                }
            } else {
                // Если муравей находится на границе области, переместить его обратно в точку своего рождения
                moveTo(New_Worker.Ants1.get(i), New_Worker.Ants1.get(i).homeX, New_Worker.Ants1.get(i).homeY, speed); // Переместить муравья к точке рождения
            }
        }
    }
    
    // Метод для плавного перемещения муравья к указанным координатам с заданной скоростью
    private void moveTo(Ant ant, int targetX, int targetY, int speed) {
        int dx = targetX - ant.x;
        int dy = targetY - ant.y;
        double distance = Math.sqrt(dx * dx + dy * dy);
    
        if (distance > speed) {
            ant.x += (int) (speed * dx / distance);
            ant.y += (int) (speed * dy / distance);
        } else {
            ant.x = targetX;
            ant.y = targetY;
        }
    }
    


    public synchronized void pauseAi() {
        itsWork = false;
    }

    public synchronized void resumAi() {
        notify();
        itsWork = true;
    }
}