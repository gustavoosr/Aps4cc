package threads;

import telaprin.TelaOrdenar;

public class Minuto implements Runnable {
    private static boolean pausado = false;
    private TelaOrdenar tela;
    private static int i;
    public Minuto(TelaOrdenar tela) {
        this.tela = tela;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if(!pausado){
                  TelaOrdenar.setMinuto(i);
                    i++;
                    if(i==59)
                        i=0;
                    
                }
            try {
                Thread.sleep(60000);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Limpar a interrupção

            }
        }
    }
    public static void pausar(){
        pausado = true;
    }
}

