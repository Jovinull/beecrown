import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class E1833 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.nextLine()); // Número de casos de teste

        // Configuração para formato monetário brasileiro
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("0.00", symbols);

        for (int t = 1; t <= T; t++) {
            double R = Double.parseDouble(scanner.nextLine()); // Valor cobrado por minuto

            // Sequência montada (errada)
            int M = Integer.parseInt(scanner.nextLine());
            List<String> montada = new ArrayList<>();
            if (M > 0) {
                montada = Arrays.asList(scanner.nextLine().split(" "));
            }

            // Sequência desejada
            int N = Integer.parseInt(scanner.nextLine());
            List<String> desejada = new ArrayList<>();
            if (N > 0) {
                desejada = Arrays.asList(scanner.nextLine().split(" "));
            }

            // Calculando o custo do serviço
            double custo = calcularCusto(montada, desejada, R);

            // Imprimindo o resultado no formato brasileiro
            System.out.printf("Caso #%d: R$ %s%n", t, df.format(custo));
        }

        scanner.close();
    }

    private static double calcularCusto(List<String> montada, List<String> desejada, double R) {
        int M = montada.size();
        int N = desejada.size();

        // Tabela de custo para alinhar as sequências
        double[][] dp = new double[M + 1][N + 1];

        // Inicialização da tabela
        for (int i = 0; i <= M; i++) {
            dp[i][0] = i * 0.5 * R; // Remover todas as lâmpadas da sequência montada
        }

        for (int j = 0; j <= N; j++) {
            dp[0][j] = j * 2.5 * R; // Adicionar todas as lâmpadas à sequência desejada
        }

        // Preenchendo a tabela dinâmica
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (montada.get(i - 1).equals(desejada.get(j - 1))) {
                    dp[i][j] = dp[i - 1][j - 1]; // Lâmpada já está no lugar correto
                } else {
                    double remover = dp[i - 1][j] + 0.5 * R; // Remover lâmpada da sequência montada
                    double adicionar = dp[i][j - 1] + 2.5 * R; // Adicionar lâmpada à sequência desejada
                    double trocar = dp[i - 1][j - 1] + 1.0 * R; // Trocar lâmpada por outra

                    dp[i][j] = Math.min(remover, Math.min(adicionar, trocar));
                }
            }
        }

        return dp[M][N];
    }
}