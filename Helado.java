import java.util.Scanner;
public class Helado extends Planeta {

    private int temperatura;

    Ran_2_ARGS randTemp = new Ran_2_ARGS(-120, -30);

    // Constructor
    public Helado(int radio , int cristalesHidrogeno, int floresDeSodio, String TipoDePlaneta) {
        
        super(radio , cristalesHidrogeno , floresDeSodio, TipoDePlaneta);
        this.temperatura = randTemp.setRandom();
    }

    @Override
    public int radioGet(){
        return super.radioGet();
    }

    @Override
    public int cristalesHidrogenoGet(){
        return super.cristalesHidrogenoGet();
    }
    
    @Override
    public int floresDeSodioGet(){
        return super.floresDeSodioGet();
    }

    public int temperaturaGet(){
        return this.temperatura;
    }

    @Override
    public String getType(){
        return super.getType();
    }

    @Override
    public int AuxViajarPlaneta(Jugador jugador){
        return super.AuxViajarPlaneta(jugador);
    }

    @Override
    public boolean visitar(Jugador jugador){        
        super.visitar(jugador);
        System.out.print(" | Temperatura promedio del planeta: " + temperaturaGet() + "\n");
        AuxExtraerRecursos();
        Scanner scanner = new Scanner(System.in); // Creamos el objeto Scanner para leer la entrada
        System.out.print("Ingresa un número: ");
        int numero = scanner.nextInt(); // Leemos el número ingresado por el usuario
        //scanner.next();  
        //scanner.close();
        extraerRecursos(numero , jugador);

        return true;
    }

    @Override
    public int AuxExtraerRecursos(){
        return super.AuxExtraerRecursos();
    }

    @Override
    public int extraerRecursos(int tipo, Jugador Stepz){

        Scanner scanner = new Scanner(System.in);
        
        if (tipo != 1 && tipo !=2) {
            while (tipo != 1 && tipo !=2) {
                System.out.print("Ingrese un numero  valido (1 o 2): ");
                tipo = scanner.nextInt(); 
                System.out.println();
            }
        }
    
        System.out.print("Ingrese la cantidad a retirar: ");
        int Unidades = scanner.nextInt();
        System.out.println();
        Stepz.setInventario(tipo - 1, Unidades);
        return 1;
    }
    
    // void visitarAsentamientos(Jugador jugador){
    // }
}