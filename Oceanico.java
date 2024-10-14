import java.util.Scanner;

public class Oceanico extends Planeta {
    
    private int profundidad;

    Ran_2_ARGS randOceanico = new Ran_2_ARGS(30, (int) Math.pow(10,2));

    // Constructor
    public Oceanico(int radio , int cristalesHidrogeno, int floresDeSodio, String TipoDePlaneta) {
        
        super(radio , cristalesHidrogeno , floresDeSodio, TipoDePlaneta);
        this.profundidad = randOceanico.setRandom();
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

    public int profundidadGet(){
        return this.profundidad;
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
        System.out.print(" | Profundidad promedio del planeta: " + profundidadGet() + "\n");
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
        super.AuxExtraerRecursos();
        System.out.println();
        return 1;
    }

    @Override
    public void AlternativcristalesHidrogenoset(int Unidades){
        super.AlternativcristalesHidrogenoset(Unidades);
    }
    @Override
    public void AlternativfloresDeSodioset(int Unidades){
        super.AlternativfloresDeSodioset(Unidades);
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
        if (tipo == 1) {
            AlternativcristalesHidrogenoset(Unidades);
        }
        else{
            AlternativfloresDeSodioset(Unidades);
        }
        ConsumoDeEnergia(Stepz , Unidades);
        Stepz.setInventario(tipo - 1, Unidades);
        return 1;
    }

    private void ConsumoDeEnergia(Jugador Stepz , int Unidades){
        float consumo = ((float)0.002 * (float)profundidadGet()* (float)profundidadGet() *(float)Unidades);
        Stepz.setConsumoDeEnergia(consumo, Unidades);
    }
}