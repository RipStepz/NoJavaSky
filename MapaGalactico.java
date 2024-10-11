import java.util.ArrayList;
import java.util.Random;

public class MapaGalactico {
    
    private ArrayList<Planeta> planetas;
    private int posicion;
    private Jugador Stepz;

    public MapaGalactico(Jugador Stepz){
        
        this.planetas = new ArrayList<>();

        for (int i = 0 ; i<10 ; i++){
            planetas.add(generadorPlaneta());
        }
        this.posicion = 0;
        this.Stepz = Stepz;
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
            
            return new Helado(radio,cristalesHidrogeno,floresDeSodio,TipoDePlaneta);
        }
        else if (NumeroRandom < 60){
            Ran_2_ARGS Semilla = new Ran_2_ARGS((int) Math.pow(10, 4), (int) Math.pow(10, 6));
            int radio = Semilla.setRandom();

            double cristalesDouble = 0.2 * 4 * Math.PI * Math.pow(radio, 2);
            int cristalesHidrogeno = (int) cristalesDouble;

            double floresDouble = 0.65 * 4 * Math.PI * Math.pow(radio, 2);;
            int floresDeSodio = (int) floresDouble;

            String TipoDePlaneta = "Oceanico"; 

            return new Oceanico(radio,cristalesHidrogeno,floresDeSodio,TipoDePlaneta);
        }
        else if(NumeroRandom < 80){
            Ran_2_ARGS Semilla = new Ran_2_ARGS((int) Math.pow(10, 4), (int) Math.pow(10, 5));
            int radio = Semilla.setRandom();

            double cristalesDouble = 0.2 * 4 * Math.PI * Math.pow(radio, 2);
            int cristalesHidrogeno = (int) cristalesDouble;

            double floresDouble = 0.2 * 4 * Math.PI * Math.pow(radio, 2);;
            int floresDeSodio = (int) floresDouble;

            String TipoDePlaneta = "Radioactivo"; 

            return new Radioactivos(radio,cristalesHidrogeno,floresDeSodio,TipoDePlaneta);
        }
        else if(NumeroRandom < 99){
            Ran_2_ARGS Semilla = new Ran_2_ARGS((int) Math.pow(10, 3), (int) Math.pow(10, 5));
            int radio = Semilla.setRandom();

            double cristalesDouble = 0.3 * 4 * Math.PI * Math.pow(radio, 2);
            int cristalesHidrogeno = (int) cristalesDouble;

            int floresDeSodio = 0;

            String TipoDePlaneta = "Volcanico"; 

            return new Volcanico(radio,cristalesHidrogeno,floresDeSodio,TipoDePlaneta);
        }
        else{
            return new CentroGalactivo(1,1,1, "Centro Galactico");
        }
    }

    public void posSet(int posicion){
        this.posicion = posicion;
    }
    public int posGet(){
        return posicion;
    }
    
    public Planeta planetaGet(){
        return planetas.get(this.posicion);
    }

    public void PrinteoGalaxia(){
        System.out.println("Lista de planetas disponibles: \n");

        for (int i = 0 ; i < planetas.size() ; i++){
            
            System.out.println("Planeta numero" +" " + (i + 1) + " Tipo " + planetas.get(i).getType());
        }
    }

    public void visitar(){
        Planeta actual = planetaGet();
        int pos = actual.visitar(Stepz) - 1;
        
        if (pos > planetas.size()) {
            for(int i = planetas.size(); i <= pos ; i++ ){
                planetas.add(generadorPlaneta());
            }
        }
        posicion = pos;
    }

    public void print(){
        
        System.out.print("\nEl planeta actual es: " + planetaGet().getType() + " y su posicion es " + (posicion + 1) + "\n"); 
    }
}