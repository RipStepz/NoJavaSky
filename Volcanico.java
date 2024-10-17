import java.util.Scanner;

public class Volcanico extends Planeta{
    
    private int temperatura;
    private int platino;
    private Jugador Stepz;
    Ran_2_ARGS randTemp = new Ran_2_ARGS(120, 256);

    // Inicializa todas las variables , antes usando el constructor de la superClase
    public Volcanico(int radio , int cristalesHidrogeno, int floresDeSodio, String TipoDePlaneta, Jugador Stepz) {
        
        super(radio , cristalesHidrogeno , floresDeSodio , TipoDePlaneta);
        this.temperatura = randTemp.setRandom();

        double platinoDouble = (0.25 * 4 * Math.PI * Math.pow(radio, 2)) -20.5 * Math.pow(this.temperatura , 2) ;
        this.platino = (int)platinoDouble;

        this.Stepz = Stepz;
    }

    // Retorna el valor del radio, llamando a la implementacion de la clase padre
    @Override
    public int radioGet(){
        return super.radioGet();
    }

    // Retorna la cantidad de cristales de hidrógeno, llamando a la implementacion de la clase padre
    @Override
    public int cristalesHidrogenoGet(){
        return super.cristalesHidrogenoGet();
    }

    // Retorna la cantidad de flores de sodio, llamando a la implementacion de la clase padre
    @Override
    public int floresDeSodioGet(){
        return super.floresDeSodioGet();
    }

    // retorna la temperatura del planeta
    public int temperaturaGet(){
        return this.temperatura;
    }
    // retorna la cantidad de platino del planeta
    public int platinoget(){
        return this.platino;
    }

    // Retorna el tipo de planeta, llamando a la implementacion de la clase padre
    @Override
    public String getType(){
        return super.getType();
    }

    // Ocupa un objeto auxiliar para preguntar cosas por consola
    //y retornar el tamaño de saltos entre planetas, llamando a la implementacion de la clase padre
    @Override
    public int AuxViajarPlaneta(Jugador jugador){
        return super.AuxViajarPlaneta(jugador);
    }

    //Resta la cantidad de hidrogendo del total, llamando a la implementacion de la clase padre
    @Override
    public void AlternativcristalesHidrogenoset(int Unidades){
        super.AlternativcristalesHidrogenoset(Unidades);
    }
    //Resta la cantidad de sodio del total, llamando a la implementacion de la clase padre
    @Override
    public void AlternativfloresDeSodioset(int Unidades){
        super.AlternativfloresDeSodioset(Unidades);
    }

    //Resta la cantidad de platino del total
    public void AlternativPlatinoset(int Unidades){
        this.platino -= Unidades;
    }

    // Calcula el consumo de energia del planeta
    private void ConsumoDeEnergia(Jugador Stepz , int Unidades){
        float consumo = ((float)0.08 * (float)temperaturaGet() * (float)Unidades);
        Stepz.setConsumoDeEnergia(consumo, Unidades);
    }

    // Se llama lo que se printea en la super clase, se imprime los parametros propias de un Planeta Radioactivo
    // Se hacen preguntas por consola para ver que y que cantidad extraer
    @Override
    public boolean visitar(Jugador jugador){        
        super.visitar(jugador);
        System.out.print(" | Radiacion promedio del planeta: " + platinoget() + "\n");
        AuxExtraerRecursos();
        Scanner scanner = new Scanner(System.in); // Creamos el objeto Scanner para leer la entrada
        System.out.print("Ingresa un número: ");
        int numero = scanner.nextInt(); // Leemos el número ingresado por el usuario
        //scanner.next();  
        //scanner.close();
        extraerRecursos(numero);

        return false;
    }

    // Se da a elegir que recurso quieres extraer, lo suma al inventario y resta el consumo de energia
    @Override
    public int extraerRecursos(int tipo){

        Scanner scanner = new Scanner(System.in);
        
        if (tipo != 1 && tipo !=2 && tipo !=3) {
            while (tipo != 1 && tipo !=2 && tipo !=3) {
                System.out.print("Ingrese un numero  valido (1 o 2 o 3): ");
                tipo = scanner.nextInt(); 
                System.out.println();
            }
        }
    
        System.out.print("Ingrese la cantidad a retirar: ");
        int Unidades = scanner.nextInt();
        System.out.println();
        if (tipo == 1) {
            AlternativcristalesHidrogenoset(Unidades);
        }
        else if (tipo == 2){
            AlternativfloresDeSodioset(Unidades);
        }
        else{
            AlternativPlatinoset(Unidades);
        }
        ConsumoDeEnergia(Stepz , Unidades);
        if (tipo == 1 || tipo == 2) {
            Stepz.setInventario(tipo - 1, Unidades);
        }
        else{
            Stepz.setInventario(3, Unidades);
        }
        
        return 1;
    }

    // Se printean los recursos a extraer, llamando a la implementacion de la clase padre
    @Override
    public int AuxExtraerRecursos(){
        super.AuxExtraerRecursos();
        System.out.print(" | 3 Platino \n");
        return 1;
    }
    
    // se sale, llamando a la implementacion de la clase padre
    @Override
    public boolean salir(){
        return super.salir();
    }
    
}