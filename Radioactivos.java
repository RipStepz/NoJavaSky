import java.util.Scanner;

public class Radioactivos extends Planeta{
    
    private int radiacion;
    private int uranio;
    private Jugador Stepz;

    Ran_2_ARGS randRadiacion = new Ran_2_ARGS(10, 50);

    // Constructor
    public Radioactivos(int radio , int cristalesHidrogeno, int floresDeSodio , String TipoDePlaneta , Jugador Stepz) {
        
        super(radio , cristalesHidrogeno , floresDeSodio, TipoDePlaneta);
        
        this.radiacion = randRadiacion.setRandom();
        
        double uranioDouble = 0.2 * 4 * Math.PI * Math.pow(radio, 2) * this.radiacion;;
        this.uranio = (int) uranioDouble;
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

    public int radiacionGet(){
        return this.radiacion;
    }

    public int uranioGet(){
        return uranio;
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
        System.out.print(" | Radiacion promedio del planeta: " + radiacionGet() + "\n");
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
        System.out.print(" | 3 uranio \n");
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
    
    public void AlternativUranioset(int Unidades){
        this.uranio -= Unidades;
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
            AlternativUranioset(Unidades);
        }
        ConsumoDeEnergia(Stepz , Unidades);
        Stepz.setInventario(tipo -1, Unidades);
        return 1;
    }

    private void ConsumoDeEnergia(Jugador Stepz , int Unidades){
        float consumo = ((float)0.3 * (float)radiacionGet() * (float)Unidades);
        System.out.println("Valor varianle consumo : " + consumo);
        Stepz.setConsumoDeEnergia(consumo, Unidades);
    }
    
}