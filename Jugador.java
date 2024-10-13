import java.util.ArrayList;
public class Jugador {
    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaProteccion;
    private ArrayList<Integer> inventario;

    public Jugador(){
        this.unidadesEnergiaProteccion = (float) 100.0;
        this.eficienciaEnergiaProteccion = (float) 0.0;
        inventario = new ArrayList<>();
        InicializarInventario();
    } 
    
    public void recargarEnergiaProteccion(int sodio){
        this.unidadesEnergiaProteccion += 0.65 * sodio * (1 + this.eficienciaEnergiaProteccion);
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
}

