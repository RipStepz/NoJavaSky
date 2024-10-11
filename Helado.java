public class Helado extends Planeta implements tieneAsentamientos{

    private int temperatura;

    Ran_2_ARGS randTemp = new Ran_2_ARGS(-120, -30);

    // Constructor
    public Helado(int radio , int cristalesHidrogeno, int floresDeSodio, String TipoDePlaneta) {
        
        super(radio , cristalesHidrogeno , floresDeSodio, TipoDePlaneta);
        this.temperatura = randTemp.setRandom();
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
        return this.temperatura;
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