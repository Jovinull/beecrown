import java.util.Scanner;

public class E2446 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int V = sc.nextInt(); // Valor da compra
        int M = sc.nextInt(); // Número de moedas
        int[] moedas = new int[M];
        
        for (int i = 0; i < M; i++) {
            moedas[i] = sc.nextInt();
        }
        
        // Solução usando Programação Dinâmica (Subset Sum Problem)
        boolean[] dp = new boolean[V + 1];
        dp[0] = true; // Sempre podemos formar 0 com nenhuma moeda
        
        for (int moeda : moedas) {
            for (int j = V; j >= moeda; j--) {
                dp[j] |= dp[j - moeda];
            }
        }
        
        System.out.println(dp[V] ? "S" : "N");
        sc.close();
    }
}