abstract class BaseAI extends Thread {
    boolean itsWork;

    BaseAI() {
        itsWork = true;
    }

    public void run() {
        while (true) {
            synchronized (this) {
                if (!itsWork) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println("Гоооооооол!");
                    }
                }
            }
            moveAi();
            App.Magnit.repaint();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    abstract public void moveAi();

    public void pauseAi() {
        itsWork = false;
    }

    public void resumAi() {
        synchronized (this) {
            notify();
            itsWork = true;
        }
    }

}