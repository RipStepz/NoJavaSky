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

    public void PrinteoGalaxia(){
        System.out.println("Lista de planetas disponibles: ");

        for (int i = 1 ; i < planetas.size() ; i++){
            
            System.out.println("Planeta numero" +" " + (i) + " Tipo " + planetas.get(i).getType());
            
        }
    }

    public void print(){
        System.out.print("\nEl planeta actual es: " + planetaGet().getType() + " y su posicion es " + (posicion + 1) + "\n"); 
    }

    public boolean visitar(){
        Planeta actual = planetaGet();
        return actual.visitar(Stepz);
    }

    public void reset(){
        this.posicion = 0;
    }

    public void addPlaneta(){
        planetas.add(generadorPlaneta());
    }

    public boolean EsCentro(int pos){
        String Nombre = getTypeFuturo(pos);
        if (Nombre == "Centro Galactico" ) {
            return true;
        }
        return false;
    }

    public void posSet(int posicion){
        this.posicion = posicion;
    }
    public void posSetAlternativ(int posicion){
        this.posicion += posicion;
    }

    public int posGet(){
        return this.posicion;
    }

    public Planeta planetaGet(){
        return planetas.get(this.posicion);
    }
    public Planeta planetaAlternativGet(int pos){
        return planetas.get(pos);
    }

    public int getSize(){
        return planetas.size();
    }

    public String getTypeActual(){
        Planeta actual = planetaGet();
        return actual.getType();
    }
    public String getTypeFuturo(int pos){
        Planeta actual = planetaAlternativGet(pos);
        return actual.getType();
    }

    public void Parche(){
        planetas.remove(0);
    }
    // Lo mas importante, no quitar por favor
    public void debugxD(){ 
        planetas.add(generadorPlaneta());
        this.posicion = 1;
    }
}