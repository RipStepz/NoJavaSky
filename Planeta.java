import java.util.Scanner;
abstract public class Planeta {
    
    private int radio;
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private String TipoDePlaneta;

    // Inicializa todas las variables
    public Planeta(int radio, int cristalesHidrogeno, int floresDeSodio, String TipoDePlaneta) {
        // Usamos this para diferenciar entre los atributos de la clase y los parámetros del constructor
        this.radio = radio;
        this.cristalesHidrogeno = cristalesHidrogeno;
        this.floresDeSodio = floresDeSodio;
        this.TipoDePlaneta = TipoDePlaneta;
    }

    // retorna el radio
    public int radioGet(){
        return this.radio;
    }
    
    // retorna la cantidad de hidrogeno
    public int cristalesHidrogenoGet(){
        return this.cristalesHidrogeno;
    }
    // resta hidrogeno al total
    public void AlternativcristalesHidrogenoset(int Unidades){
        this.cristalesHidrogeno -= Unidades;
    }

    // retorna las flores de sodio
    public int floresDeSodioGet(){
        return this.floresDeSodio;
    }
    // resta sodio al total
    public void AlternativfloresDeSodioset(int Unidades){
        this.floresDeSodio -= Unidades;
    }

    // Retorna el tipo de planeta
    public String getType(){
        return TipoDePlaneta;
    }

    // solo printea atrivitos basicos, la logida del visitar, se hace en las subclases
    public boolean visitar(Jugador jugador){
        System.out.print("Planeta tipo: " + getType() + " | Cantidad de Hidrogeno: " + cristalesHidrogenoGet() + " | Cantidad de Flores de Sodio: " + floresDeSodioGet());
        return true;
    }

    // Ocupa un objeto auxiliar para preguntar cosas por consola
    //y retornar el tamaño de saltos entre planetas
    public int AuxViajarPlaneta(Jugador jugador){
        
        EntradaVisitar cin = new EntradaVisitar();

        int salto = cin.InEntradaTamano();
        
        while (!cin.InEntrada2(salto)) {
            salto = cin.InEntradaTamano();
        }
        cin.Finish();
        return(salto);
    }

    // Aqui no se hace nada, es trabajo de las subclases
    public int extraerRecursos(int tipo){  
        return 1;
    }
    // Se printean los recursos a extraer
    public int AuxExtraerRecursos(){
        System.out.println("Recursos a extraer: ");
        System.out.print("1 Cristales de hidrogeno | 2 flores de sodio ");
        return 1;

    }

    // Se pregunta si se quiere salir, si se quiere se retorna falso, si no es verdadero
    public boolean salir(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDesea salir del planeta? (1 si | 2 no): ");
        int respuesta = scanner.nextInt();
        while (respuesta != 1 && respuesta != 2) {
            System.out.print("\nFavor poner un valor correcto? (1 si | 2 no): ");
            respuesta = scanner.nextInt();
        }
        if (respuesta == 1) {
            return false;
        }
        else{
            return true;
        }
    }

}
