public class CentroGalactivo extends Planeta {

    // Inicializa todas las variables , antes usando el constructor de la superClase
    public CentroGalactivo(int radio , int cristalesHidrogeno, int floresDeSodio, String TipoDePlaneta) {
        
        super(radio , cristalesHidrogeno , floresDeSodio , TipoDePlaneta);
    }

    // Retorna el tipo de planeta, llamando a la implementacion de la clase padre
    @Override
    public String getType(){
        return super.getType();
    }

    // Solo retorna true para comprobar si se visito el planeta final y ganar
    @Override public boolean visitar(Jugador jugador){
        return true;
    }   
}