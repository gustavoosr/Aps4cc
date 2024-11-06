package threads;

import java.util.ArrayList;
import java.util.List;
import telaprin.TelaOrdenar;

public class MergeThread extends Thread {
    private final List<TelaOrdenar.Imagem> photos;
    private List<TelaOrdenar.Imagem> sortedPhotos;

    public MergeThread(List<TelaOrdenar.Imagem> photos) {
        this.photos = photos;
    }

    public List<TelaOrdenar.Imagem> getSortedPhotos() {
        return sortedPhotos;
    }

    @Override
    public void run() {
        sortedPhotos = mergeSort(photos);
    }

    // Implementação do Merge Sort
    private List<TelaOrdenar.Imagem> mergeSort(List<TelaOrdenar.Imagem> photos) {
        if (photos.size() <= 1) {
            return photos;
        }

        int mid = photos.size() / 2;
        List<TelaOrdenar.Imagem> left = new ArrayList<>(photos.subList(0, mid));
        List<TelaOrdenar.Imagem> right = new ArrayList<>(photos.subList(mid, photos.size()));

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private List<TelaOrdenar.Imagem> merge(List<TelaOrdenar.Imagem> left, List<TelaOrdenar.Imagem> right) {
        List<TelaOrdenar.Imagem> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            // Comparação pelo ID da foto (int)
            if (left.get(i).getOrdem() <= right.get(j).getOrdem()) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}