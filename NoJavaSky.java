public class NoJavaSky {

    public static void main(String[] args) {
        
        Jugador Stepz = new Jugador();
        
        Nave V16 = new Nave(Stepz);
        MapaGalactico Mapa = new MapaGalactico(Stepz, V16);
        PreguntaAccion accion = new PreguntaAccion();
        int eleccion;
        int eleccionRecarga;

        System.out.println("Bienvenido a Lolo Company:\n");;

        System.out.println("Lolo Company es una organización que contrata personas para trabajos peligrosos "
                        + "y esporádicos. Tu objetivo es recolectar recursos con los que puedas sobrevivir "
                        + "y tradear con la compañía.");
        
        System.out.println("Lolo Company se queda con los recursos que le intercambias, pero a cambio mejora tu material de trabajo. El sueldo que te corresponde se le paga a tu familiar más cercano, ya que en este trabajo NO SOBREVIVIRÁS.");
                        

        System.out.print("La única forma de evitar este trágico destino es llegar al centro galáctico mientras cumples con tu labor. Este lugar especial en la galaxia es el único en el que la compañía no tiene poder.\n");

        System.out.println("Para poder llegar a ese ilusorio destino, necesitas mejorar la eficiencia de tu nave, al menos al 50%. Pero el trabajo está lleno de adversidades ten cuidado ");

        System.err.println("con el combustible de tu nave o la protección restante de tu traje, ya que si cualquiera de estos llega a 0, MORIRÁS como muchas otras personas en este peligroso trabajo.");
       
        System.out.println("Las sedes donde puedes tradear con Lolo Company se encuentran exclusivamente en los planetas de tipo Helado y Oceánico. Pero esto no significa que no tengan poder en el resto de planetas. Recuerda esto: ELLOS ESTÁN EN TODOS LADOS...\n");


        while (true) {
            Mapa.PrinteoGalaxia();
            eleccion = accion.Eleccion();
            
            if (eleccion == 1) {
                Mapa.visitar();
            }
            else if (eleccion == 2) {
                V16.viajarPlaneta(Mapa, 0,0);
            }
            else if (eleccion == 3) {
                Stepz.MostrarInventario();
            }
            else if (eleccion == 4) {
                System.out.println("Nave: ");
                System.out.println("Combustible de la nave: " + V16.getUnidadesCombustible() + " | Eficiencia: " + V16.getEficienciaPropulsor() * 100 + "%");

                System.out.println();

                System.out.println("Traje: ");
                System.out.println("Energia restante del traje: " + Stepz.getEnergiaProteccion() + " | Eficiencia: " + Stepz.getEficiencia()*100 + "%");
            }
            if(eleccion == 5){
                eleccionRecarga = accion.Nave_Jugador();

                if (eleccionRecarga ==1) {
                    V16.recargarPropulsores(accion.Nave());
                }
                else{
                    Stepz.recargarEnergiaProteccion(accion.Traje());
                }
            }
        }
        
        // Mapa.PrinteoGalaxia();
        // V16.viajarPlaneta(Mapa, 0, 0);
        // V16.getAlternativUnidadesCombustible();

        
        // Mapa.visitar();
        // Stepz.MostrarInventario();
        // System.out.println("La energia restante es: " + Stepz.getEnergiaProteccion());
        
        // Stepz.recargarEnergiaProteccion(10);
        // System.out.println("La energia restante es: " + Stepz.getEnergiaProteccion());
        
        
        // V16.viajarPlaneta(Mapa, 0, 0);
        // V16.getAlternativUnidadesCombustible();
        // Mapa.visitar();
        // Stepz.MostrarInventario();
        // Stepz.recargarEnergiaProteccion(10);
        // Stepz.MostrarInventario();
        // System.out.println("La energia restante es: " + Stepz.getEnergiaProteccion());    
        
    }
}