public class Radioactivos extends Planeta{
    
    private int radiacion;
    private int uranio;

    Ran_2_ARGS randRadiacion = new Ran_2_ARGS(10, 50);

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
    
    @Override
    public int floresDeSodioGet(){
        return super.floresDeSodioGet();
    }

    public int radiacionGet(){
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
    public boolean visitar(Jugador jugador){        
        super.visitar(jugador);
        System.out.print(" | Cantidad de Uranio: "+ uranioGet()  + " | Radiacion promedio del planeta: " + radiacionGet() + "\n");
        return true;
    }
}