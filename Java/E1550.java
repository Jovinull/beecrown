import java.util.*;

public class E1550 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Número de casos de teste

        while (T-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            System.out.println(minOperations(A, B));
        }
        sc.close();
    }

    // Função para encontrar o menor número de operações
    private static int minOperations(int A, int B) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(new int[]{A, 0}); // {número atual, número de operações}
        visited.add(A);

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int num = curr[0], steps = curr[1];

            if (num == B) return steps;

            // Gerar os dois próximos estados possíveis
            int addOne = num + 1;
            int reverse = reverseNumber(num);

            // Adicionar operações na fila se ainda não foram visitadas
            if (addOne <= 9999 && !visited.contains(addOne)) {
                queue.add(new int[]{addOne, steps + 1});
                visited.add(addOne);
            }
            if (reverse <= 9999 && !visited.contains(reverse)) {
                queue.add(new int[]{reverse, steps + 1});
                visited.add(reverse);
            }
        }

        return -1; // Não deveria chegar aqui, pois sempre há um caminho até B
    }

    // Função para inverter os dígitos de um número
    private static int reverseNumber(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + (num % 10);
            num /= 10;
        }
        return reversed;
    }
}
