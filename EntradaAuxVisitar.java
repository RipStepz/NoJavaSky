import java.util.Scanner;
public class EntradaAuxVisitar {
    // Mantenemos el scanner abierto y lo reutilizamos en todo el ciclo de vida de la aplicación
    private static Scanner scanner = new Scanner(System.in);

    public EntradaAuxVisitar() {
        // No necesitas crear una nueva instancia del scanner aquí, ya lo hemos inicializado de forma estática.
    }    
    
    public int InEntradaTamano() {
        int salto = 0;

        // Si hay un error con la entrada, atrapamos la excepción
        try {
            System.out.print("\nIntroduce el tamaño del salto (Puede ser positivo o negativo): ");
            salto = scanner.nextInt();  // Lee el siguiente entero
        } catch (Exception e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            scanner.next();  // Limpiar el buffer del scanner en caso de entrada no válida
        }
        return salto;
    }

    public boolean InEntrada2(int salto) {
        boolean retorno = false;

        // Similar, atrapamos errores en caso de que la entrada no sea un número entero válido
        try {
            System.out.print("Seguro que quieres realizar un salto de " + salto + " planetas? (0 no, 1 si): ");
            int retornoInt = scanner.nextInt();  // Lee el siguiente entero
            
            if (retornoInt == 1) {
                retorno = true;
            }
        } catch (Exception e) {
            System.out.println("Entrada inválida. Por favor, ingrese 0 o 1.");
            scanner.next();  // Limpiar el buffer del scanner en caso de entrada no válida
        }
        return retorno;
    }

    // No cierras el scanner aquí para que puedas seguir usándolo en otras partes del código
    public void Finish() {
        // Deja el método vacío o cierra el scanner solo al final del programa
    }
}
