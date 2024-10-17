import java.util.Scanner;
public class EntradaAuxVisitar {
   
    private static Scanner scanner = new Scanner(System.in);
    
    //Recibe el tamaño del salto y lo retorna (Para los saltos entre planetas)
    public int InEntradaTamano() {
        int salto = 0;

        // Si hay un error con la entrada, atrapamos la excepcion
        try {
            System.out.print("\nIntroduce el tamaño del salto (Puede ser positivo o negativo): ");
            salto = scanner.nextInt();  
        } catch (Exception e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            scanner.next();  // Para evitar errores se usa el next
        }
        return salto;
    }

    public boolean InEntrada2(int salto) {
        boolean retorno = false;

        // Si hay un error con la entrada, atrapamos la excepcion
        try {
            System.out.print("Seguro que quieres realizar un salto de " + salto + " planetas? (0 no, 1 si): ");
            int retornoInt = scanner.nextInt(); 
            
            if (retornoInt == 1) {
                retorno = true;
            }
        } catch (Exception e) {
            System.out.println("Entrada inválida. Por favor, ingrese 0 o 1.");
            scanner.next(); // Para evitar errores se usa el next
        }
        return retorno;
    }
}
