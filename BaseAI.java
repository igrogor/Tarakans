abstract class BaseAI extends Thread {
    boolean itsWork = true;

    public void run() {
        while (true) {
            synchronized(this) {
                if(!itsWork){
                    try{
                        wait();
                    } catch(InterruptedException e){
                        System.out.println("Гоооооооол!");
                    }
                }
            }
            moveAi();
        }
    }
    abstract public void moveAi();

    public synchronized void pauseAi() {
        itsWork = false;
    }
    
    public synchronized void resumAi(){
        notify();
        itsWork = true;
    }

}