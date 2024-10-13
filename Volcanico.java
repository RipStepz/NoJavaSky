public class Volcanico extends Planeta{
    
    private int temperatura;
    private int platino;
    Ran_2_ARGS randTemp = new Ran_2_ARGS(120, 256);

    // Constructor
    public Volcanico(int radio , int cristalesHidrogeno, int floresDeSodio, String TipoDePlaneta) {
        
        super(radio , cristalesHidrogeno , floresDeSodio , TipoDePlaneta);
        this.temperatura = randTemp.setRandom();

        double platinoDouble = (0.25 * 4 * Math.PI * Math.pow(radio, 2)) -20.5 * Math.pow(this.temperatura , 2) ;
        this.platino = (int)platinoDouble;
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
    public int platinoget(){
        return this.platino;
    }

    @Override
    public String getType(){
        return super.getType();
    }

    @Override
    public boolean visitar(Jugador jugador){        
        super.visitar(jugador);
        System.out.print(" | Cantidad de platino: " + platinoget() + " | Temperatura promedio: " + temperaturaGet()  + "\n");
        return true;
    }
}