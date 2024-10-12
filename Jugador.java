public class Jugador {
    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaProteccion;

    public Jugador(){
        this.unidadesEnergiaProteccion = (float) 100.0;
        this.eficienciaEnergiaProteccion = (float) 0.0;
    } 
    
    public void recargarEnergiaProteccion(int sodio){
        this.unidadesEnergiaProteccion += 0.65 * sodio * (1 + this.eficienciaEnergiaProteccion);
    }

}

