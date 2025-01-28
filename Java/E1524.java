import java.util.*;

public class E1524 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            // Lê o número de pessoas na fila (N) e o número de grupos (K)
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            // Lê as posições das pessoas na fila
            int[] positions = new int[N];
            for (int i = 1; i < N; i++) {
                positions[i] = scanner.nextInt();
            }

            // Calcula as diferenças entre as posições consecutivas
            int[] gaps = new int[N - 1];
            for (int i = 0; i < N - 1; i++) {
                gaps[i] = positions[i + 1] - positions[i];
            }

            // Ordena as diferenças em ordem decrescente
            Arrays.sort(gaps);

            // Soma os menores tamanhos possíveis para os grupos
            int result = 0;
            for (int i = 0; i < N - K; i++) {
                result += gaps[i];
            }

            // Imprime o resultado para a instância
            System.out.println(result);
        }

        scanner.close();
    }
}
