import java.util.*;

public class E1643 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // Número de distâncias
        List<Integer> results = new ArrayList<>();

        // Pré-computar a sequência de Fibonacci até 25000
        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(1); // F1
        fibonacci.add(2); // F2
        while (true) {
            int next = fibonacci.get(fibonacci.size() - 1) + fibonacci.get(fibonacci.size() - 2);
            if (next > 25000) break;
            fibonacci.add(next);
        }

        // Processar cada distância
        for (int i = 0; i < t; i++) {
            int x = scanner.nextInt();
            results.add(convertToMiles(x, fibonacci));
        }

        // Imprimir resultados
        for (int result : results) {
            System.out.println(result);
        }

        scanner.close();
    }

    private static int convertToMiles(int x, List<Integer> fibonacci) {
        int n = fibonacci.size();
        int[] fibRep = new int[n]; // Representação Fibonacci de x

        // Representação gulosa no sistema Fibonacci
        for (int i = n - 1; i >= 0; i--) {
            if (x >= fibonacci.get(i)) {
                fibRep[i] = 1;
                x -= fibonacci.get(i);
            }
        }

        // Deslocar bits uma posição à direita
        int[] shiftedFibRep = new int[n];
        System.arraycopy(fibRep, 1, shiftedFibRep, 0, n - 1);

        // Calcular y
        int y = 0;
        for (int i = 0; i < n; i++) {
            if (shiftedFibRep[i] == 1) {
                y += fibonacci.get(i);
            }
        }

        return y;
    }
}
