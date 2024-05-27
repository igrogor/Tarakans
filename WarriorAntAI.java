
class WarriorAntAI extends BaseAI {
    Habitat New_Warrior;
    App Morder;
    Rivyera Olimp;
    static double radius = 100;

    public WarriorAntAI(Habitat New_Warrior) {
        this.New_Warrior = New_Warrior;
    }

    public synchronized void moveAi() {
        for (int i = 0; i < New_Warrior.Ants1.size(); i++) {

            if (i < New_Warrior.Ants1.size()) {


                double centerX = New_Warrior.Ants1.get(i).homeX;
                double centerY = New_Warrior.Ants1.get(i).homeY + radius;

                New_Warrior.Ants1.get(i).angle += (Math.PI / 180) * Ant.speed * 10;
                New_Warrior.Ants1.get(i).x = (int) (centerX + radius * Math.cos(New_Warrior.Ants1.get(i).angle));
                New_Warrior.Ants1.get(i).y = (int) (centerY + radius * Math.sin(New_Warrior.Ants1.get(i).angle));
            }
            synchronized (this) { 
                if (!itsWork) {
                    try {
                        wait(); // Ожидание, пока поток не будет разблокирован
                    } catch (InterruptedException e) {
                        // Обработка прерывания
                    }
                }
            }
        }
    }
}

