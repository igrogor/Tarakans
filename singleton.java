import java.io.Serializable;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class Singleton implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private static Singleton instance; // Единственный экземпляр Singleton

    private Habitat habitat; // Ссылка на объект Habitat

    // Приватный конструктор, чтобы предотвратить создание экземпляров извне
    private Singleton() {
    }

    // Метод для получения единственного экземпляра Singleton
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Геттер и сеттер для объекта Habitat
    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }
}

// public class Singleton implements Serializable{
//     private static final long serialVersionUID = 1214262494968570109L;

//     private static Singleton instance;
//     private Vector<AntWarrior> Ants1 = new Vector<>();
//     private Vector<AntWorker> Ants2 = new Vector<>();
//     private HashSet<Integer> antIds = new HashSet<>();
//     private TreeMap<Integer, Integer> birthTimes = new TreeMap<>();

//     private Singleton() {instance = this; }

//     public static Singleton getInstance() {
//         if(instance == null) {
//             instance = new Singleton();
//         }
//         return instance;
//     }

//     public Vector<AntWarrior> getAntWarriorVector() {return Ants1; }

//     public void setAntWarriorVector(Vector<AntWarrior>Ants1 ) {this.Ants1 = Ants1;}


//     public Vector<AntWorker> getAntWorkerVector() {return Ants2; }

//     public void setAntWorkerVector(Vector<AntWorker>Ants2 ) {this.Ants2 = Ants2;}


//     public HashSet<Integer> getHashSet() {return antIds; }

//     public void setHashSet(HashSet<Integer>antIds) {this.antIds = antIds;}
    

//     public TreeMap<Integer, Integer> getTreeMap() {return birthTimes; }

//     public void setTreeMap(TreeMap<Integer, Integer>birthTimes) {this.birthTimes = birthTimes;}



// }
