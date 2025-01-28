import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = scanner.nextInt(); // Número de habitantes
            if (n == 0) break;

            int[] demands = new int[n];
            for (int i = 0; i < n; i++) {
                demands[i] = scanner.nextInt();
            }

            long work = 0;
            long balance = 0; // Saldo acumulado de vinho

            for (int i = 0; i < n; i++) {
                balance += demands[i]; // Atualiza o saldo com a demanda/venda
                work += Math.abs(balance); // Soma o trabalho necessário
            }

            System.out.println(work);
        }

        scanner.close();
    }
}
