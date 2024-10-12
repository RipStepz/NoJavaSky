public class NoJavaSky {

    public static void main(String[] args) {
        
        Jugador Stepz = new Jugador();
        MapaGalactico Mapa = new MapaGalactico(Stepz);
        Nave V16 = new Nave(Stepz);
        
        Mapa.PrinteoGalaxia();
        V16.viajarPlaneta(Mapa, 0, 0);
        Mapa.PrinteoGalaxia();
        Mapa.print();

        V16.viajarPlaneta(Mapa, 0, 0);
        Mapa.PrinteoGalaxia();
        Mapa.print();
        
    }
}
