import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // Número de tipos de cortes disponíveis
        int T = sc.nextInt(); // Comprimento total do cano
        
        int[] C = new int[N]; // Comprimentos disponíveis
        int[] V = new int[N]; // Valores correspondentes
        
        for (int i = 0; i < N; i++) {
            C[i] = sc.nextInt();
            V[i] = sc.nextInt();
        }
        
        sc.close();
        
        // DP para armazenar o máximo valor para cada tamanho de cano até T
        int[] dp = new int[T + 1];
        
        // Resolvendo de forma semelhante ao problema da Mochila (Unbounded Knapsack)
        for (int i = 0; i < N; i++) {
            for (int j = C[i]; j <= T; j++) {
                dp[j] = Math.max(dp[j], dp[j - C[i]] + V[i]);
            }
        }
        
        // O maior valor possível para um cano de tamanho T
        System.out.println(dp[T]);
    }
}
