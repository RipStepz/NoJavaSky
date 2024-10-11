abstract public class Planeta {
    
    private int radio;
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private String TipoDePlaneta;

    public Planeta(int radio, int cristalesHidrogeno, int floresDeSodio, String TipoDePlaneta) {
        // Usamos this para diferenciar entre los atributos de la clase y los parámetros del constructor
        this.radio = radio;
        this.cristalesHidrogeno = cristalesHidrogeno;
        this.floresDeSodio = floresDeSodio;
        this.TipoDePlaneta = TipoDePlaneta;
    }

    public int radioGet(){
        return this.radio;
    }
    
    public int cristalesHidrogenoGet(){
        return this.cristalesHidrogeno;
    }

    public int floresDeSodioGet(){
        return this.floresDeSodio;
    }

    public String getType(){
        return TipoDePlaneta;
    }

    public int visitar(Jugador jugador){
        
        EntradaVisitar cin = new EntradaVisitar();

        int pos = cin.InEntrada();
        
        while (!cin.InEntrada2(pos)) {
            pos = cin.InEntrada();
        }
        cin.Finish();
        return(pos);
    }

    // public int extraerRecursos(int tipo){

    // }

    // public boolean salir(){

    // }
}
