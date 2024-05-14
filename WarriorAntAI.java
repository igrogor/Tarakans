import java.util.Vector;

class WarriorAntAI extends BaseAI {
    Habitat New_Warrior;
    App Morder;
    Rivyera Olimp;
    Vector<AntWarrior> Ants1_new;

    int speed = 1;

    public WarriorAntAI(Habitat New_Warrior) {
        this.New_Warrior = New_Warrior;
    }

    // public void moveAi() {
    // for (int i = 0; i < New_Warrior.Ants2.size(); i++) {

    // // Сделать обработку на начальные
    // // кординаты!!!-----------------------------------

    // if (!(New_Warrior.Ants2.get(i).x > 799 || New_Warrior.Ants2.get(i).x < 0 ||
    // New_Warrior.Ants2.get(i).y > 799
    // || New_Warrior.Ants2.get(i).y < 0)) {
    // // true - left, false - right
    // if (New_Warrior.Ants2.get(i).derection == true) {
    // New_Warrior.Ants2.get(i).x = New_Warrior.Ants2.get(i).x - spead;
    // New_Warrior.Ants2.get(i).y = New_Warrior.Ants2.get(i).y - spead;
    // }
    // if (New_Warrior.Ants2.get(i).derection == false) {
    // New_Warrior.Ants2.get(i).x = New_Warrior.Ants2.get(i).x + spead;
    // New_Warrior.Ants2.get(i).y = New_Warrior.Ants2.get(i).y + spead;
    // }

    // } else {
    // New_Warrior.Ants2.get(i).derection = !(New_Warrior.Ants2.get(i).derection);
    // }
    // System.out.println("Warrior");
    // App.Magnit.repaint();

    // }

    // public void moveAi() {

    //     for (int i = 0; i < New_Warrior.Ants2.size(); i++) {
    //         if (i < New_Warrior.Ants1.size()) {
    //             // Предположим, что радиус окружности R и центр окружности в (homeX, homeY)
    //             // Для упрощения примера, рассмотрим движение по половине окружности

    //             double radius = 100; // Установите радиус окружности
    //             double centerX = New_Warrior.Ants2.get(i).homeX; // Установите координату X центра окружности
    //             double centerY = New_Warrior.Ants2.get(i).homeY + radius; // Установите координату Y центра окружности

    //             // Рассчитаем новые координаты, используя параметрические уравнения окружности
    //             New_Warrior.Ants2.get(i).angle += Math.PI / 180; // Установите угловой шаг, например, 1 градус
    //             New_Warrior.Ants2.get(i).x = (int) (centerX + radius * Math.cos(New_Warrior.Ants2.get(i).angle));
    //             New_Warrior.Ants2.get(i).y = (int) (centerY + radius * Math.sin(New_Warrior.Ants2.get(i).angle));
    //         }
    //     }
    // }

    public void moveAi() {
        for (int i = 0; i < New_Warrior.Ants2.size(); i++) {
            if (!(New_Warrior.Ants2.get(i).x > 799 || New_Warrior.Ants2.get(i).x < 0 || New_Warrior.Ants2.get(i).y > 799 || New_Warrior.Ants2.get(i).y < 0)) {
                if (New_Warrior.Ants2.get(i).derection == true) {
                    New_Warrior.Ants2.get(i).x = New_Warrior.Ants2.get(i).x - speed;
                    New_Warrior.Ants2.get(i).y = New_Warrior.Ants2.get(i).y - speed;
                }
                if (New_Warrior.Ants2.get(i).derection == false) {
                    New_Warrior.Ants2.get(i).x = New_Warrior.Ants2.get(i).x + speed;
                    New_Warrior.Ants2.get(i).y = New_Warrior.Ants2.get(i).y + speed;
                }
            } else {
                New_Warrior.Ants2.get(i).derection = !(New_Warrior.Ants2.get(i).derection);
            }
            System.out.println("Warrior");
            App.Magnit.repaint();
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
