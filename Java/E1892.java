import java.util.*;

public class E1892 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            // Lê o número de alunos (N)
            int N = scanner.nextInt();

            if (N == 0) break; // Condição de parada

            // Array para armazenar as matrículas
            String[] matriculas = new String[N];
            for (int i = 0; i < N; i++) {
                matriculas[i] = scanner.next();
            }

            // Chama o método para contar os pares (i, j) onde i < j e m[i] > m[j]
            long inversoes = mergeSortAndCount(matriculas, 0, N - 1);

            // Exibe o número de inversões
            System.out.println(inversoes);
        }

        scanner.close();
    }

    // Método para contar inversões usando Merge Sort
    private static long mergeSortAndCount(String[] arr, int left, int right) {
        long count = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;

            // Conta as inversões na metade esquerda
            count += mergeSortAndCount(arr, left, mid);

            // Conta as inversões na metade direita
            count += mergeSortAndCount(arr, mid + 1, right);

            // Conta as inversões durante o merge
            count += mergeAndCount(arr, left, mid, right);
        }

        return count;
    }

    // Método para realizar o merge e contar as inversões
    private static long mergeAndCount(String[] arr, int left, int mid, int right) {
        // Tamanhos dos subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Arrays temporários
        String[] leftArray = new String[n1];
        String[] rightArray = new String[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;
        long inversions = 0;

        // Merge dos subarrays enquanto conta as inversões
        while (i < n1 && j < n2) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
                inversions += (n1 - i); // Contabiliza as inversões
            }
        }

        // Copia os elementos restantes, se houver
        while (i < n1) {
            arr[k++] = leftArray[i++];
        }

        while (j < n2) {
            arr[k++] = rightArray[j++];
        }

        return inversions;
    }
}
