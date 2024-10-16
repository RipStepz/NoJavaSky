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
    public void AlternativcristalesHidrogenoset(int Unidades){
        this.cristalesHidrogeno -= Unidades;
    }

    public int floresDeSodioGet(){
        return this.floresDeSodio;
    }
    public void AlternativfloresDeSodioset(int Unidades){
        this.floresDeSodio -= Unidades;
    }

    public String getType(){
        return TipoDePlaneta;
    }

    public int AuxViajarPlaneta(Jugador jugador){
        
        EntradaVisitar cin = new EntradaVisitar();

        int salto = cin.InEntradaTamano();
        
        while (!cin.InEntrada2(salto)) {
            salto = cin.InEntradaTamano();
        }
        cin.Finish();
        return(salto);
    }

    public boolean visitar(Jugador jugador){
        System.out.print("Planeta tipo: " + getType() + " | Cantidad de Hidrogeno: " + cristalesHidrogenoGet() + " | Cantidad de Flores de Sodio: " + floresDeSodioGet());
        return true;
    }

    public int AuxExtraerRecursos(){
        System.out.println("Recursos a extraer: ");
        System.out.print("1 Cristales de hidrogeno | 2 flores de sodio ");
        return 1;

    }

    public int extraerRecursos(int tipo){
        
        return 1;
    }

}
