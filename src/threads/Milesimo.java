package threads;

import java.awt.image.CropImageFilter;
import telaprin.TelaOrdenar;

public class Milesimo implements Runnable{
    private static boolean pausado = false;
    private TelaOrdenar tela;
    private static int i =0;
    public Milesimo (TelaOrdenar tela){
        this.tela= tela;
    }
    @Override
    public void run() {
        
        while (!Thread.currentThread().isInterrupted()){
             if(!pausado){
                    TelaOrdenar.setMilessimo(i);
                    i++;
                    if(i==999)
                        i=0;
                }
            try {
               Thread.sleep(1);
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt(); // limpar a interrupção
            }
        }
    }
    public static void pausar(){
        pausado = true;
    }
}