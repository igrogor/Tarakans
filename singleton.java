import java.util.HashSet;
import java.util.TreeMap;
import java.util.Vector;

public final class singleton implements java.io.Serializable {
    private static final singleton instance = new singleton();
    private static long serialVersionUID = 1L;

    Vector<AntWarrior> Ants1 ;
    Vector<AntWorker> Ants2;
    HashSet<Integer>  antIds ;
    TreeMap<Integer, Integer> birthTimes ;

    
    private singleton() {
        Ants1 = new Vector<>();
        Ants2 = new Vector<>();
        antIds = new HashSet<>();
        birthTimes = new TreeMap<>();
    }

    public static singleton getInstance() {
        return instance;

    }
}
