public class Nave {
    private float unidadesCombustible;
    private float eficienciaPropulsor;
    private float Max;
    private float MaxEficiencia;
    private Jugador Stepz;

    // Constructor, inicializa todas las variables
    public Nave(Jugador jugador){
        this.unidadesCombustible = (float) 100.0;
        this.eficienciaPropulsor = (float) 0.0;
        this.Stepz = jugador;
        this.MaxEficiencia = (float)1.0;
    }

    // Retorna la eficiencia
    public float getEficienciaPropulsor(){
        return this.eficienciaPropulsor;
    }

    // setea la eficiencia
    public void setEficienciaPropulsor(float mejora){
        this.eficienciaPropulsor = mejora;
    }

    // Retorna el combustible
    public float getUnidadesCombustible(){
        return this.unidadesCombustible;
    }

    // setea el combustible
    public void setCombustible(float unidades){
        this.unidadesCombustible = unidades;
    }

    // Gasto de combustible
    public void setAlternativCombustible(float salto){
        this.unidadesCombustible -= (float)0.75* (float)(1-getEficienciaPropulsor()) * salto * salto;
    }

    // Printea el combustible
    public void getAlternativUnidadesCombustible(){
        System.out.println("Cantidad de combustile restante: " + getUnidadesCombustible());
    } 

    // Retorna la eficiencia
    public float getMaxEficiencia(){
        return this.MaxEficiencia;
    }

    // Recarga el combustible y controla si tienes suficiente hidrogeno para hacerlo en caso de tenerlo te lo resta del inventario
    public void recargarPropulsores(int hidrogenos){
        
        int HidrogenoInventario = Stepz.getInventario(0);
        if (HidrogenoInventario- hidrogenos < 0) {
            System.out.println("Accion imposible, no tienes suficiente Hidrogeno");
        }
        else{
            if ( this.unidadesCombustible + (float)0.65 * (float)hidrogenos * (1 + (float)eficienciaPropulsor) > this.Max){
                Stepz.setInventario(2, - hidrogenos);
                this.unidadesCombustible = this.Max;
                return;
            }
            Stepz.setInventario(0, - hidrogenos);
            this.unidadesCombustible += (float)0.65 * (float)hidrogenos * (1 + (float)eficienciaPropulsor);
        }       
    }
    
    // Maneja la logica sobre el viaje entre planetas 
    public void viajarPlaneta(MapaGalactico Mapa , int direccion , int tamanoSalto) {
        Planeta actual = Mapa.planetaGet();
        int salto = actual.AuxViajarPlaneta(Stepz); // me retorna el tamaño del salto
    
        // Si el salto nos lleva a una posición fuera del rango inicial, mando al primer planeta
        if (Mapa.posGet() + salto < 1) { 
            System.out.println("El salto seleccionado, te haría retroceder más allá del inicio, por defecto se lleva al planeta inicial");
            Mapa.posSet(1);  // Llevar al primer planeta
            return;
        }
    
        // Si el salto nos lleva más allá del tamaño actual de la lista de planetas, genero mas
        if (Mapa.posGet() + salto >= Mapa.getSize()) {  
            // Calcula cuantos planetas necesitamos generar
            int planetasPorGenerar = (Mapa.posGet() + salto + 1) - Mapa.getSize(); 
    
            // Generamos los planetas faltantes
            for (int i = 0; i < planetasPorGenerar; i++) {
                Mapa.addPlaneta();
            }
        }
        // Actualizamos la posición después del salto
        setAlternativCombustible((float)salto);
        Mapa.posSetAlternativ(salto);
    }
}
