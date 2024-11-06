package threads;

import java.util.ArrayList;
import java.util.List;
import telaprin.TelaOrdenar;

public class HeapSortThread extends Thread {
    private final List<TelaOrdenar.Imagem> photos;
    private List<TelaOrdenar.Imagem> sortedPhotos;

    public HeapSortThread(List<TelaOrdenar.Imagem> photos) {
        this.photos = new ArrayList<>(photos); // Cópia defensiva da lista original
        this.sortedPhotos = new ArrayList<>(photos); // Inicializa a lista ordenada
    }

    @Override
    public void run() {
        sort(sortedPhotos); // Realiza o HeapSort na cópia da lista
    }

    public void sort(List<TelaOrdenar.Imagem> photos) {
        int n = photos.size();

        // Constrói a heap (rearranja o array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(photos, n, i);
        }

        // Um por um extrai os elementos da heap
        for (int i = n - 1; i >= 0; i--) {
            // Move a raiz atual para o final
            TelaOrdenar.Imagem temp = photos.get(0);
            photos.set(0, photos.get(i));
            photos.set(i, temp);

            // Chama heapify na heap reduzida
            heapify(photos, i, 0);
        }
    }

    // Método auxiliar para reorganizar a heap
    void heapify(List<TelaOrdenar.Imagem> photos, int n, int i) {
        int maior = i; // Inicializa o maior como raiz
        int esquerda = 2 * i + 1; // Filho à esquerda
        int direita = 2 * i + 2; // Filho à direita

        // Verifica se o filho à esquerda é maior que a raiz
        if (esquerda < n && photos.get(esquerda).getOrdem() > photos.get(maior).getOrdem()) {
            maior = esquerda;
        }

        // Verifica se o filho à direita é maior que o maior até agora
        if (direita < n && photos.get(direita).getOrdem() > photos.get(maior).getOrdem()) {
            maior = direita;
        }

        // Se o maior não for a raiz
        if (maior != i) {
            // Troca a raiz com o maior
            TelaOrdenar.Imagem troca = photos.get(i);
            photos.set(i, photos.get(maior));
            photos.set(maior, troca);

            // Recursivamente aplica o heapify na subárvore
            heapify(photos, n, maior);
        }
    }

    public List<TelaOrdenar.Imagem> getSortedPhotos() {
        return sortedPhotos; // Retorna a lista ordenada
    }
}
