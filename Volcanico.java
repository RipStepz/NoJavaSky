import java.util.Scanner;

public class Volcanico extends Planeta{
    
    private int temperatura;
    private int platino;
    private Jugador Stepz;
    Ran_2_ARGS randTemp = new Ran_2_ARGS(120, 256);

    // Constructor
    public Volcanico(int radio , int cristalesHidrogeno, int floresDeSodio, String TipoDePlaneta, Jugador Stepz) {
        
        super(radio , cristalesHidrogeno , floresDeSodio , TipoDePlaneta);
        this.temperatura = randTemp.setRandom();

        double platinoDouble = (0.25 * 4 * Math.PI * Math.pow(radio, 2)) -20.5 * Math.pow(this.temperatura , 2) ;
        this.platino = (int)platinoDouble;

        this.Stepz = Stepz;
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
    public int platinoget(){
        return this.platino;
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

    @Override
    public int AuxExtraerRecursos(){
        super.AuxExtraerRecursos();
        System.out.print(" | 3 Platino \n");
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

    public void AlternativPlatinoset(int Unidades){
        this.platino -= Unidades;
    }

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

    private void ConsumoDeEnergia(Jugador Stepz , int Unidades){
        float consumo = ((float)0.08 * (float)temperaturaGet() * (float)Unidades);
        Stepz.setConsumoDeEnergia(consumo, Unidades);
    }
    
}