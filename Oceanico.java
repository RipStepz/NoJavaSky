public class Oceanico extends Planeta {
    
    private int profundidad;

    Ran_2_ARGS randOceanico = new Ran_2_ARGS(30, (int) Math.pow(10,3));

    // Constructor
    public Oceanico(int radio , int cristalesHidrogeno, int floresDeSodio, String TipoDePlaneta) {
        
        super(radio , cristalesHidrogeno , floresDeSodio, TipoDePlaneta);
        this.profundidad = randOceanico.setRandom();
    }

    @Override
    public int radioGet(){
        return super.radioGet();
    }

    @Override
    public int cristalesHidrogenoGet(){
        return super.cristalesHidrogenoGet();
    }
    
    public int floresDeSodioGet(){
        return floresDeSodioGet();
    }

    public int temperaturaGet(){
        return this.profundidad;
    }

    @Override
    public String getType(){
        return super.getType();
    }

    @Override
    public int visitar(Jugador jugador){
        return super.visitar(jugador);
    }
}
