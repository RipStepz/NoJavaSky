public class NoJavaSky {

    public static void main(String[] args) {
        
        Jugador Stepz = new Jugador();
        MapaGalactico Mapa = new MapaGalactico(Stepz);
        Nave V16 = new Nave(Stepz);
        
        Mapa.PrinteoGalaxia();
        V16.viajarPlaneta(Mapa, 0, 0);
        //Mapa.PrinteoGalaxia();
        Mapa.visitar();
        System.out.println("La cantidad actual de Hidrogeno es: " + Stepz.getInventario(0));
        
        Mapa.visitar();
        System.out.println("La cantidad actual de Hidrogeno es: " + Stepz.getInventario(0));

        // V16.viajarPlaneta(Mapa, 0, 0);
        // Mapa.visitar();
        // Mapa.PrinteoGalaxia();
        
        
    }
}