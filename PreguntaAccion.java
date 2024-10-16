import java.util.Scanner;

public class PreguntaAccion {
    
    private Scanner scanner;
    
    public PreguntaAccion(){
        scanner = new Scanner(System.in);
    }

    public int Eleccion(){
        System.out.println("¿Que accion deseas realizar?");
        System.out.print("1 Visitar planeta | 2 Viajar entre planetas | 3 Mostrar inventario | 4 Estadisticas Nava/Jugador | 5 Recargar Energia Nave/Traje: ");
        
        int eleccion = scanner.nextInt();
        
        while (eleccion != 1 && eleccion != 2 && eleccion != 3 && eleccion != 4 && eleccion != 5) {
            System.out.println("Ingrese una accion valida");
            System.out.print("1 Visitar planeta | 2 Viajar entre planetas | 3 Mostrar inventario | 4 Estadisticas Nava/Jugador | 5 Recargar Energia Nave/Traje: ");
            eleccion = scanner.nextInt();
        }

        return eleccion;
    }

    public int Nave_Jugador(){
        System.out.println("¿Que accion deseas realizar?");
        System.out.print("1 Recargar el combustible de la nave con hidrogeno | 2 Recargar la energia del traje con sodio: ");
        
        int eleccion = scanner.nextInt();
        
        while (eleccion != 1 && eleccion != 2 ) {
            System.out.println("Ingrese una accion valida");
            System.out.println("1 Recargar el combustible de la nave con hidrogeno | 2 Recargar la energia del traje con sodio: ");
            eleccion = scanner.nextInt();
        }

        return eleccion;
    }
    public int Nave(){
        System.out.println("¿Cuanto Hidrogeno quieres usar para recargar energia?: ");
        int eleccion = scanner.nextInt();
        
        while (eleccion <0 ) {
            System.out.println("Ingrese una cantidad valida de hidrogeno (no puede ser negativa): ");
            eleccion = scanner.nextInt();
        }
        return eleccion;
    }
    public int Traje(){
        System.out.println("¿Cuanto Sodio quieres usar para recargar energia?: ");
        int eleccion = scanner.nextInt();
        
        while (eleccion < 0 ) {
            System.out.println("Ingrese una cantidad valida de sodio (no puede ser negativa): ");
            eleccion = scanner.nextInt();
        }
        return eleccion;
    }
}
