public class NoJavaSky {

    public static void main(String[] args) {
        
        Jugador Stepz = new Jugador();
        MapaGalactico Mapa = new MapaGalactico(Stepz);
        Mapa.PrinteoGalaxia();
        Mapa.visitar();
        Mapa.PrinteoGalaxia();
        Mapa.print();
        
    }
}