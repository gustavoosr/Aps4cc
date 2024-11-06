 package threads;

import telaprin.TelaOrdenar;


public class Segundo implements Runnable {
    private static boolean pausado = false;
    private TelaOrdenar tela;
    private static int i;

    public Segundo(TelaOrdenar tela) {
        this.tela = tela;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
             if(!pausado){
                    TelaOrdenar.setSegundo(i);
                    i++;
                    if(i==59)
                        i=0;
                    
                }
            try {
                   Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Limpar a interrupção
            }
        }
    }
    public static void pausar(){
        pausado = true;
    }
}
