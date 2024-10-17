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

    // se obtiene un numero aleatorio entre min y max (ambos incluidos)
    public int setRandom() {
        Random_seleccionado = rand.nextInt((max - min + 1)) + min;
        return Random_seleccionado;
    }

    //retorna el random que se genero
    public int getRandom(){
        return Random_seleccionado;
    }
}
