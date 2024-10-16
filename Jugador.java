import java.util.ArrayList;
public class Jugador {
    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaProteccion;
    private float Max;
    private float MaxEficiencia;
    private ArrayList<Integer> inventario;

    public Jugador(){
        this.unidadesEnergiaProteccion = (float) 100.0;
        this.Max = (float) 100.0;
        this.eficienciaEnergiaProteccion = (float) 0.0;
        this.MaxEficiencia = (float)1.0;
        inventario = new ArrayList<>();
        InicializarInventario();
    } 
    
    public void recargarEnergiaProteccion(int sodio){
        
        int SodioInventario = getInventario(1);
        if (SodioInventario - sodio < 0) {
            System.out.println("Accion imposible, no tienes suficiente sodio");
        }
        else{
            if ( this.unidadesEnergiaProteccion+ (float)0.65 * (float)sodio * (float)(1 + this.eficienciaEnergiaProteccion) > this.Max){
                inventario.set(2, SodioInventario - sodio);
                this.unidadesEnergiaProteccion = this.Max;
                return;
            }
            inventario.set(2, SodioInventario - sodio);
            this.unidadesEnergiaProteccion += (float)0.65 * (float)sodio * (float)(1 + this.eficienciaEnergiaProteccion);
        }        
    }

    private void InicializarInventario(){
        for(int i = 0 ; i<4 ; i++){
            inventario.add(0);
        }
    }

    public int getInventario(int pos){
        return inventario.get(pos);
    }

    public void setInventario(int pos, int Unidades){
        inventario.set(pos, inventario.get(pos) + Unidades );
    }
    
    public float getEnergiaProteccion(){
        return this.unidadesEnergiaProteccion;
    }

    public float getEficiencia(){
        return this.eficienciaEnergiaProteccion; 
    }
    public void setEficiencia(float aunmento){
        this.eficienciaEnergiaProteccion += aunmento; 
    }

    public float getMax(){
        return this.Max;
    }
    public float getMaxEficiencia(){
        return this.MaxEficiencia;
    }

    public void setConsumoDeEnergia(float consumoDeEnergia, int Unidades){
        
        this.unidadesEnergiaProteccion -= (float)0.5*(float)Unidades*(consumoDeEnergia/100)*(1 - getEficiencia());
    }

    public void MostrarInventario(){
        System.out.println("\nInventario: ");
        System.out.println(" 1 Cristales de hidrogeno : " + getInventario(0) + " | 2 Flores de sodio: " + getInventario(1) + " | 3 Uranio: " + getInventario(2) + " | 4 Platino: " + getInventario(3));
    }

    public void vaciarInventario(){
        for(int i = 0; i<4;i++)
        setInventario(i,0);
    }
    public void setUnidadesEnergiaProteccion(float unidadesEnergiaProteccion){
        this.unidadesEnergiaProteccion = unidadesEnergiaProteccion;
    }
}