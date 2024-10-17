import java.util.ArrayList;
import java.util.Random;

public class MapaGalactico {
    
    private ArrayList<Planeta> planetas;
    private int posicion;
    private Jugador Stepz;
    private Nave V16;

    public MapaGalactico(Jugador Stepz, Nave V16){
        
        this.planetas = new ArrayList<>();

        //for (int i = 0 ; i<10 ; i++){
        planetas.add(generadorPlaneta());

        //}
        this.posicion = 0;
        this.Stepz = Stepz;
        this.V16 = V16;
    }

    // Setea la posicion actual con el valor dado
    public void posSet(int posicion){
        this.posicion = posicion;
    }

    // Modifica la posicion actual sumando el valor dado
    public void posSetAlternativ(int posicion){
        this.posicion += posicion;
    }

    // Retorna la posicion actual
    public int posGet(){
        return this.posicion;
    }

    // Retorna el planeta actual en la posicion actual
    public Planeta planetaGet(){
        return planetas.get(this.posicion);
    }

    // Retorna el planeta en una posición específica sin modificar la posición actual
    public Planeta planetaAlternativGet(int pos){
        return planetas.get(pos);
    }

    // Retorna el tamaño de la lista de planetas
    public int getSize(){
        return planetas.size();
    }

    // Retorna el tipo del planeta en la posición actual
    public String getTypeActual(){
        Planeta actual = planetaGet();
        return actual.getType();
    }

    // Retorna el tipo del planeta en una posicion futura (especificada por el parametro pos)
    public String getTypeFuturo(int pos){
        Planeta actual = planetaAlternativGet(pos);
        return actual.getType();
    }

    // Resetea la posición actual a 0
    public void reset(){
        this.posicion = 1;
    }

    // Se crean los planetas con las problibilidades pedidas por la tarea y se le dan los datos necesarios para los constructores a los planetas
    // se calculas radios, y a partir de eso los demas datos
    public Planeta generadorPlaneta(){
        
        Random rand = new Random();
        int NumeroRandom = rand.nextInt(100);

        if (NumeroRandom < 30 ) {
            Ran_2_ARGS Semilla = new Ran_2_ARGS((int) Math.pow(10, 3), (int) Math.pow(10, 6));
            int radio = Semilla.setRandom();

            double cristalesDouble = 0.65 * 4 * Math.PI * Math.pow(radio, 2);
            int cristalesHidrogeno = (int) cristalesDouble;

            double floresDouble = 0.35 * 4 * Math.PI * Math.pow(radio, 2);;
            int floresDeSodio = (int) floresDouble;

            String TipoDePlaneta = "Helado"; 
            
            return new Helado(radio,cristalesHidrogeno,floresDeSodio,TipoDePlaneta , V16, Stepz);
        }
        else if (NumeroRandom < 60){
            Ran_2_ARGS Semilla = new Ran_2_ARGS((int) Math.pow(10, 4), (int) Math.pow(10, 6));
            int radio = Semilla.setRandom();

            double cristalesDouble = 0.2 * 4 * Math.PI * Math.pow(radio, 2);
            int cristalesHidrogeno = (int) cristalesDouble;

            double floresDouble = 0.65 * 4 * Math.PI * Math.pow(radio, 2);;
            int floresDeSodio = (int) floresDouble;

            String TipoDePlaneta = "Oceanico"; 

            return new Oceanico(radio,cristalesHidrogeno,floresDeSodio,TipoDePlaneta, V16 , Stepz);
        }
        else if(NumeroRandom < 80){
            Ran_2_ARGS Semilla = new Ran_2_ARGS((int) Math.pow(10, 4), (int) Math.pow(10, 5));
            int radio = Semilla.setRandom();

            double cristalesDouble = 0.2 * 4 * Math.PI * Math.pow(radio, 2);
            int cristalesHidrogeno = (int) cristalesDouble;

            double floresDouble = 0.2 * 4 * Math.PI * Math.pow(radio, 2);;
            int floresDeSodio = (int) floresDouble;

            String TipoDePlaneta = "Radioactivo"; 

            return new Radioactivos(radio,cristalesHidrogeno,floresDeSodio,TipoDePlaneta, Stepz);
        }
        else if(NumeroRandom < 99){
            Ran_2_ARGS Semilla = new Ran_2_ARGS((int) Math.pow(10, 3), (int) Math.pow(10, 5));
            int radio = Semilla.setRandom();

            double cristalesDouble = 0.3 * 4 * Math.PI * Math.pow(radio, 2);
            int cristalesHidrogeno = (int) cristalesDouble;

            int floresDeSodio = 0;

            String TipoDePlaneta = "Volcanico"; 

            return new Volcanico(radio,cristalesHidrogeno,floresDeSodio,TipoDePlaneta, Stepz);
        }
        else{
            return new CentroGalactivo(1,1,1, "Centro Galactico");
        }
    }

    //Printea la lista de planetas
    public void PrinteoGalaxia(){
        System.out.println("Lista de planetas disponibles: ");

        for (int i = 1 ; i < planetas.size() ; i++){
            
            System.out.println("Planeta numero" +" " + (i) + " Tipo " + planetas.get(i).getType());
            
        }
    }

    //se obtiene el planeta, y se llama la funcion definida en el planeta especifico
    public boolean visitar(){
        Planeta actual = planetaGet();
        return actual.visitar(Stepz);
    }

    //Añade un planeta a la lista
    public void addPlaneta(){
        planetas.add(generadorPlaneta());
    }

    // se obtiene el planeta y se le aplica la funcion salir del planeta especifico
    public boolean salir(){
        Planeta salir = planetaGet();
        return salir.salir();
    }

    // Si esta funcion desaparece, un agujero negro se traga a NoJavaSky, esta funcion mantiene el equilibrio en el universo
    public void debugxD(){
        planetas.add(generadorPlaneta());
        this.posicion = 1;
    }
    
}