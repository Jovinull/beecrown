import java.util.*;

public class E1590 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê o número de casos de teste
        int T = scanner.nextInt();

        while (T-- > 0) {
            // Lê N (número de elementos na lista) e K (número mínimo de elementos para AND)
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            // Lê os N números
            int[] numbers = new int[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = scanner.nextInt();
            }

            // Ordena os números em ordem decrescente
            Arrays.sort(numbers);
            for (int i = 0; i < N / 2; i++) {
                int temp = numbers[i];
                numbers[i] = numbers[N - i - 1];
                numbers[N - i - 1] = temp;
            }

            int maxAndValue = 0;

            // Testa todas as máscaras de bits (apenas bits mais significativos)
            for (int bit = 30; bit >= 0; bit--) {
                int mask = maxAndValue | (1 << bit);

                // Conta quantos números ainda satisfazem a máscara
                int count = 0;
                for (int num : numbers) {
                    if ((num & mask) == mask) {
                        count++;
                    }
                }

                // Se pelo menos K números satisfazem a máscara, atualiza o maxAndValue
                if (count >= K) {
                    maxAndValue = mask;
                }
            }

            // Imprime o maior valor encontrado para o caso de teste
            System.out.println(maxAndValue);
        }

        scanner.close();
    }
}
