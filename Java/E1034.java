import java.util.*;

public class E1034 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê o número de instâncias
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); // Número de tipos de blocos
            int M = scanner.nextInt(); // Comprimento desejado

            int[] blocks = new int[N];
            for (int i = 0; i < N; i++) {
                blocks[i] = scanner.nextInt();
            }

            // Array para DP, inicializado com um valor alto (infinito)
            int[] dp = new int[M + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0; // Base: 0 blocos para comprimento 0

            // Preenchimento da tabela DP
            for (int block : blocks) {
                for (int j = block; j <= M; j++) {
                    if (dp[j - block] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[j - block] + 1);
                    }
                }
            }

            // Resultado: número mínimo de blocos para atingir M
            System.out.println(dp[M]);
        }

        scanner.close();
    }
}
