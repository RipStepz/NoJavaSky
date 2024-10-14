public class NoJavaSky {

    public static void main(String[] args) {
        
        Jugador Stepz = new Jugador();
        MapaGalactico Mapa = new MapaGalactico(Stepz);
        Nave V16 = new Nave(Stepz);
        
        Mapa.PrinteoGalaxia();
        V16.viajarPlaneta(Mapa, 0, 0);
        V16.getAlternativUnidadesCombustible();

        
        Mapa.visitar();
        Stepz.MostrarInventario();
        System.out.println("La energia restante es: " + Stepz.getEnergiaProteccion());
        
        Stepz.recargarEnergiaProteccion(10);
        System.out.println("La energia restante es: " + Stepz.getEnergiaProteccion());
        
        
        // V16.viajarPlaneta(Mapa, 0, 0);
        // V16.getAlternativUnidadesCombustible();
        // Mapa.visitar();
        // Stepz.MostrarInventario();
        // Stepz.recargarEnergiaProteccion(10);
        // Stepz.MostrarInventario();
        // System.out.println("La energia restante es: " + Stepz.getEnergiaProteccion());    
        
    }
}