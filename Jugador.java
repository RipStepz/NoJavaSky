import java.util.ArrayList;
public class Jugador {
    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaProteccion;
    private float Max;
    private float MaxEficiencia;
    private ArrayList<Integer> inventario;

    //inicializo todos los parametros iniciales
    public Jugador(){
        this.unidadesEnergiaProteccion = (float) 100.0;
        this.Max = (float) 100.0;
        this.eficienciaEnergiaProteccion = (float) 0.0;
        this.MaxEficiencia = (float)1.0;
        inventario = new ArrayList<>();
        InicializarInventario();
    } 
    
    // añade 4 elementos al inventario
    private void InicializarInventario(){
        for(int i = 0 ; i<4 ; i++){
            inventario.add(0);
        }
    }

    // setea los elementos del inventario en 0
    public void vaciarInventario(){
        for(int i = 0; i<4;i++)
        setInventario(i,0);
    }

    //  printea cada elelmento del inventario
    public void MostrarInventario(){
        System.out.println("\nInventario: ");
        System.out.println(" 1 Cristales de hidrogeno : " + getInventario(0) + " | 2 Flores de sodio: " + getInventario(1) + " | 3 Uranio: " + getInventario(2) + " | 4 Platino: " + getInventario(3));
    }
    
    // obtengo un elemento del inventario
    public int getInventario(int pos){
        return inventario.get(pos);
    }

    // Agrega al inventario las unidades de x material
    public void setInventario(int pos, int Unidades){
        inventario.set(pos, inventario.get(pos) + Unidades );
    }
    
    // retorna la energia proteccion
    public float getEnergiaProteccion(){
        return this.unidadesEnergiaProteccion;
    }

    // retorna la eficiencia
    public float getEficiencia(){
        return this.eficienciaEnergiaProteccion; 
    }

    // setea la eficiencia
    public void setEficiencia(float aunmento){
        this.eficienciaEnergiaProteccion += aunmento; 
    }

    // retorna el maximo de Energia
    public float getMax(){
        return this.Max;
    }

    // retorna la eficiencia maxima
    public float getMaxEficiencia(){
        return this.MaxEficiencia;
    }

    // resta el consumo de energia a la energia total
    public void setConsumoDeEnergia(float consumoDeEnergia, int Unidades){
        
        this.unidadesEnergiaProteccion -= (float)0.5*(float)Unidades*(consumoDeEnergia/100)*(1 - getEficiencia());
    }

    // setea la energia de proteccion
    public void setUnidadesEnergiaProteccion(float unidadesEnergiaProteccion){
        this.unidadesEnergiaProteccion = unidadesEnergiaProteccion;
    }

    // Recarga la energia de proteccion
    public void recargarEnergiaProteccion(int sodio){
        
        int SodioInventario = getInventario(1);
        if (SodioInventario - sodio < 0) { // si no se puede se printea el error
            System.out.println("Accion imposible, no tienes suficiente sodio");
        }
        else{
            if ( this.unidadesEnergiaProteccion+ (float)0.65 * (float)sodio * (float)(1 + this.eficienciaEnergiaProteccion) > this.Max){
                inventario.set(2, SodioInventario - sodio);
                this.unidadesEnergiaProteccion = this.Max; // si es mayor al maximo, solo lo seteo en maximo
                return;
            }
            inventario.set(2, SodioInventario - sodio);
            this.unidadesEnergiaProteccion += (float)0.65 * (float)sodio * (float)(1 + this.eficienciaEnergiaProteccion); // se suma lo recargado
        }        
    }
}