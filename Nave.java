public class Nave {
    private float unidadesCombustible;
    private float eficienciaPropulsor;
    private Jugador Stepz;

    public Nave(Jugador jugador){
        this.unidadesCombustible = (float) 100.0;
        this.eficienciaPropulsor = (float) 0.0;
        this.Stepz = jugador;

    }

    public void recargarPropulsores(int hidrogenos){
        this.unidadesCombustible = (float)0.65 * (float)hidrogenos * (1 + (float)eficienciaPropulsor);
    }
    
    public float getEficienciaPropulsor(){
        return this.eficienciaPropulsor;
    }

    public void setEficienciaPropulsor(float mejora){
        this.eficienciaPropulsor = mejora;
    }
    
    public void viajarPlaneta(MapaGalactico Mapa , int direccion , int tamanoSalto) {
        Planeta actual = Mapa.planetaGet();
        int salto = actual.visitar(Stepz); // me retorna el tamaño del salto
    
        // Si el salto nos lleva a una posición fuera del rango inicial (antes del índice 0)
        if (Mapa.posGet() + salto < 0) {  // Usa 0 en lugar de 1, ya que el índice inicial de la lista es 0
            System.out.println("El salto seleccionado, te haría retroceder más allá del inicio, por defecto se lleva al planeta inicial");
            Mapa.posSet(0);  // Llevar al primer planeta
            return;
        }
    
        // Si el salto nos lleva más allá del tamaño actual de la lista de planetas
        if (Mapa.posGet() + salto >= Mapa.getSize()) {  
            // Calcula cuántos planetas necesitamos generar
            int planetasPorGenerar = (Mapa.posGet() + salto + 1) - Mapa.getSize(); 
    
            // Generamos los planetas faltantes
            for (int i = 0; i < planetasPorGenerar; i++) {
                Mapa.addPlaneta();
            }
        }
    
        // Actualizamos la posición después del salto
        Mapa.posSetAlternativ(salto);
    }
}
