package threads;

import java.util.List;
import telaprin.TelaOrdenar;

// Classe que estende Thread e implementa o algoritmo de QuickSort para objetos Photo
public class QuickSortThread extends Thread {
    private final List<TelaOrdenar.Imagem> img;
    private final int start;
    private final int end;

    // Construtor que recebe a lista de fotos e os índices de início e fim
    public QuickSortThread(List<TelaOrdenar.Imagem> img, int start, int end) {
        this.img = img;
        this.start = start;
        this.end = end;
    }

    // Método que é executado quando a thread é iniciada
    @Override
    public void run() {
        quickSort(img, start, end);  // Chama o QuickSort na lista de fotos
    }

    // Implementação do algoritmo de QuickSort adaptado para a lista de Photo
    private void quickSort(List<TelaOrdenar.Imagem> img, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separar(img, inicio, fim);
            quickSort(img, inicio, posicaoPivo - 1);
            quickSort(img, posicaoPivo + 1, fim);
        }
    }

    // Método que separa a lista de Photo em torno de um pivô
    private int separar(List<TelaOrdenar.Imagem> img, int inicio, int fim) {
        TelaOrdenar.Imagem pivo = img.get(inicio); // O pivô é um objeto Photo
        int i = inicio + 1;
        int f = fim;

        while (i <= f) {
            // Comparação pelo ID da foto (int)
            if (img.get(i).getOrdem() <= pivo.getOrdem()) {
                i++;
            } else if (img.get(f).getOrdem() > pivo.getOrdem()) {
                f--;
            } else {
                TelaOrdenar.Imagem troca = img.get(i);
                img.set(i, img.get(f));
                img.set(f, troca);
                i++;
                f--;
            }
        }

        // Coloca o pivô na posição correta
        img.set(inicio, img.get(f));
        img.set(f, pivo);
        return f;
    }

    // Método para obter a lista ordenada de fotos
    public List<TelaOrdenar.Imagem> getSortedPhotos() {
        return img;
    }
}