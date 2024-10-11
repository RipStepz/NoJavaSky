public class Radioactivos extends Planeta{
    
    private int radiacion;
    private int uranio;

    Ran_2_ARGS randRadiacion = new Ran_2_ARGS((int)Math.pow(10,4), (int)Math.pow(10,5));

    // Constructor
    public Radioactivos(int radio , int cristalesHidrogeno, int floresDeSodio , String TipoDePlaneta) {
        
        super(radio , cristalesHidrogeno , floresDeSodio, TipoDePlaneta);
        
        this.radiacion = randRadiacion.setRandom();
        
        double uranioDouble = 0.2 * 4 * Math.PI * Math.pow(radio, 2) * this.radiacion;;
        this.uranio = (int) uranioDouble;
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
        return this.radiacion;
    }

    public int uranioGet(){
        return uranio;
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
