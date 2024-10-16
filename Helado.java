import java.util.Scanner;
public class Helado extends Planeta implements tieneAsentamientos{

    private int temperatura;
    private Nave V16;

    Ran_2_ARGS randTemp = new Ran_2_ARGS(-120, -30);

    // Constructor
    public Helado(int radio , int cristalesHidrogeno, int floresDeSodio, String TipoDePlaneta, Nave V16) {
        
        super(radio , cristalesHidrogeno , floresDeSodio, TipoDePlaneta);
        this.temperatura = randTemp.setRandom();
        this.V16 = V16;
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

    private float getTemperatura(){
        return this.temperatura;
    }

    @Override
    public int AuxViajarPlaneta(Jugador jugador){
        return super.AuxViajarPlaneta(jugador);
    }

    @Override
    public boolean visitar(Jugador jugador ){        
        
        super.visitar(jugador);
        System.out.print(" | Temperatura promedio del planeta: " + temperaturaGet() + "\n");
        
        System.out.println("\n¿Que accion quieres realizar?");
        System.out.print("1 Extraer recursos | 2 Ir a la sede de Lolo Company: ");
        Scanner scanner = new Scanner(System.in); // Creamos el objeto Scanner para leer la entrada
        int decision = scanner.nextInt(); 
        
        while (decision != 1 && decision != 2) {
            System.out.println("Ingrese un valor valido");
            System.out.print("1 Extraer recursos | 2 Ir a la sede de Lolo Company: ");
        }
        if (decision == 1) {
            AuxExtraerRecursos();
            System.out.print("Ingresa un número: ");
            int numero = scanner.nextInt(); // Leemos el número ingresado por el usuario
            extraerRecursos(numero , jugador);
        }
        else{
            visitarAsentamientos(jugador);
        }

        return false;
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
        float consumo = (float)-1.0*((float)0.15 * (float)getTemperatura() * (float)Unidades);
        Stepz.setConsumoDeEnergia(consumo , Unidades);
    }

    @Override
    public void visitarAsentamientos(Jugador jugador){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nHa llegado a una de las cedes de la compañia, ¿desea vender sus recursos por mejoras (1 si | 2 no)? :");
        int Decision = scanner.nextInt();
        while (Decision !=1 && Decision != 2) {
            System.out.print("\n Por favor ingrese un valor valido (1 si | 2 no)? :");
            Decision = scanner.nextInt();
        }
        if (Decision == 2) {
            return;
        }
        else{
            System.out.print("\n La compañia le ofrece intercambiarle su 200 de uranio a cambio de mejorar la nave y 100 de platino a cambio de mejorar el traje. (1 Mejorar nave (Tradear uranio) | 2 Mejoar el traje (usar el platino)): ");
            Decision = scanner.nextInt();
            while (Decision !=1 && Decision != 2) {
                System.out.print("\n Por favor ingrese un valor valido (1 Nave/Uranio | 2 Traje/platino)? :");
                Decision = scanner.nextInt();
            }

            if (Decision == 1) {
                if (jugador.getInventario(2) - 200 < 0) {
                    System.out.println("No tienes suficiente uranio para completar el tradeo"); 
                    return;
                }
                if (V16.getEficienciaPropulsor() + (float)0.05 > V16.getMaxEficiencia()) {
                    V16.setEficienciaPropulsor((float)1.0);
                    return; 
                }
                jugador.setInventario(2, -200);
                V16.setEficienciaPropulsor(V16.getEficienciaPropulsor() + (float)0.05); 
            }
            else{
                if (jugador.getInventario(3) - 100 < 0) {
                    System.out.println("No tienes suficiente platino para completar el tradeo"); 
                    return;
                }
                if (jugador.getEficiencia() + (float)0.05 > jugador.getMaxEficiencia()) {
                    jugador.setEficiencia((float)1.0);
                    return; 
                }
                jugador.setInventario(3, -100);
                jugador.setEficiencia(jugador.getEficiencia() + (float)0.05); 
            }
        }
        return;
    }

    

    // void visitarAsentamientos(Jugador jugador){
    // }
}