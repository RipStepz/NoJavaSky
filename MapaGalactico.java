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

    public void posSetAlternativ(int posicion){
        this.posicion += posicion;
    }

    public int posGet(){
        return posicion;
    }
    
    public Planeta planetaGet(){
        return planetas.get(this.posicion);
    }

    public int getSize(){
        return planetas.size();
    }

    public void addPlaneta(){
        planetas.add(generadorPlaneta());
    }

    public void PrinteoGalaxia(){
        System.out.println("Lista de planetas disponibles: \n");

        for (int i = 0 ; i < planetas.size() ; i++){
            
            System.out.println("Planeta numero" +" " + (i + 1) + " Tipo " + planetas.get(i).getType());
        }
    }

    // public void visitar() {
    //     Planeta actual = planetaGet();
    //     int salto = actual.visitar(Stepz); // me retorna el tamaño del salto
    
    //     // Si el salto nos lleva a una posición fuera del rango inicial (antes del índice 0)
    //     if (posicion + salto < 0) {  // Usa 0 en lugar de 1, ya que el índice inicial de la lista es 0
    //         System.out.println("El salto seleccionado, te haría retroceder más allá del inicio, por defecto se lleva al planeta inicial");
    //         posicion = 0;  // Llevar al primer planeta
    //         return;
    //     }
    
    //     // Si el salto nos lleva más allá del tamaño actual de la lista de planetas
    //     if (posicion + salto >= planetas.size()) {  
    //         // Calcula cuántos planetas necesitamos generar
    //         int planetasPorGenerar = (posicion + salto + 1) - planetas.size(); 
    
    //         // Generamos los planetas faltantes
    //         for (int i = 0; i < planetasPorGenerar; i++) {
    //             planetas.add(generadorPlaneta());
    //         }
    //     }
    
    //     // Actualizamos la posición después del salto
    //     posicion += salto;
    // }
    

    public void print(){
        System.out.print("\nEl planeta actual es: " + planetaGet().getType() + " y su posicion es " + (posicion + 1) + "\n"); 
    }
}