import java.util.Scanner;

public class EntradaVisitar {
   
        private Scanner scanner;
        private boolean Flag = true;

        public EntradaVisitar(){
            scanner = new Scanner(System.in);
        }    
        
        public int InEntrada(){
            int pos = 0;
            while (Flag) {
            System.out.print("\nIntroduce el numero del planeta a visitar: ");
            pos = scanner.nextInt();
            
            if (pos > 0) {   
                return pos;
            }
            System.out.print("Por favor ingrese un planeta de indice mayor o igual a 1 ");   
        }
        return pos;
    }
    
    public boolean InEntrada2(int pos){
        boolean retorno = false;
        System.out.print("Seguro que quieres visitar el planeta que se encuentra en la pos (0 no, 1 si): ");
        //System.out.println();
        
        int retornoInt = scanner.nextInt();
        if (retornoInt == 1) {
            retorno = true;
        }

        return retorno;
    }

    public void Finish(){
        scanner.close();
    }
}