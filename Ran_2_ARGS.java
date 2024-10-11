import java.util.Random;

public class Ran_2_ARGS {
    
    private int max, min, Random_seleccionado;
    private Random rand;

    // Constructor que toma el máximo y el mínimo
    public Ran_2_ARGS(int min, int max) {
        this.max = max;
        this.min = min;
        this.rand = new Random(); 
    }

    // Método para obtener un número aleatorio entre min y max (ambos incluidos)
    public int setRandom() {
        // La fórmula garantiza que el número aleatorio esté entre min y max, incluyendo ambos
        Random_seleccionado = rand.nextInt((max - min + 1)) + min;
        return Random_seleccionado;
    }

    public int getRandom(){
        return Random_seleccionado;
    }
}
