import java.util.HashSet;
import java.util.TreeMap;
import java.util.Vector;




    // public class Singleton implements java.io.Serializable {
    //     private static long serialVersionUID = 1L;
        
    //     Vector<AntWarrior> Ants1_clone ;
    //     Vector<AntWorker> Ants2_clone;
    //     HashSet<Integer>  antIds_clone ;
    //     TreeMap<Integer, Integer> birthTimes_clone ;
        
    //     Habitat copu = new Habitat();
        
    //     private Singleton() {
    //         Ants1_clone = new Vector<>(copu.Ants1);
    //         Ants2_clone = new Vector<>(copu.Ants2);
    //         antIds_clone = new HashSet<>(copu.antIds);
    //         birthTimes_clone = new TreeMap<>(copu.birthTimes);
    //     }
    // }

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
    


    // public static Singleton getInstance() {
    //     return instance;

    // }

    // public class Singleton implements java.io.Serializable {
    //     private static long serialVersionUID = 1L;
        
    //     Vector<AntWarrior> Ants1_clone ;
    //     Vector<AntWorker> Ants2_clone;
    //     HashSet<Integer>  antIds_clone ;
    //     TreeMap<Integer, Integer> birthTimes_clone ;
        
    //     Habitat copu = new Habitat();
        
    //     private Singleton() {
    //         Ants1_clone = new Vector<>(copu.Ants1);
    //         Ants2_clone = new Vector<>(copu.Ants2);
    //         antIds_clone = new HashSet<>(copu.antIds);
    //         birthTimes_clone = new TreeMap<>(copu.birthTimes);
    //     }
    // }


