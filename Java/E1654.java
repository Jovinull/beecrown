import java.util.HashSet;

public class E1654 {
    public static void main(String[] args) {
        final int MAX_CENTS = 2000; // 20.00 euros em centavos
        HashSet<String> results = new HashSet<>();

        // Reduzimos os loops com condições mais restritivas
        for (int a = 1; a <= MAX_CENTS; a++) {
            for (int b = a; b <= MAX_CENTS; b++) {
                for (int c = b; c <= MAX_CENTS; c++) {
                    int sum = a + b + c;
                    long product = 1L * a * b * c;

                    // Calcula d e verifica rapidamente sua validade
                    if (product % sum != 0) continue;
                    int d = (int) (product / sum);

                    // Garante que d está no intervalo e segue a ordem crescente
                    if (d >= c && d <= MAX_CENTS) {
                        results.add(String.format("%.2f %.2f %.2f %.2f",
                                a / 100.0, b / 100.0, c / 100.0, d / 100.0));
                    }
                }
            }
        }

        // Imprime os resultados únicos
        for (String result : results) {
            System.out.println(result);
        }
    }
}
