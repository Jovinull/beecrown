import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = Integer.parseInt(scanner.nextLine().trim());
            if (n == 0) break;

            StringBuilder text = new StringBuilder();
            for (int i = 0; i < n; i++) {
                text.append(scanner.nextLine());
            }

            Map<String, Integer> digraphCount = new HashMap<>();
            int totalDigraphs = 0;

            // Contando os dígrafos
            for (int i = 0; i < text.length() - 1; i++) {
                String digraph = text.substring(i, i + 2);
                digraphCount.put(digraph, digraphCount.getOrDefault(digraph, 0) + 1);
                totalDigraphs++;
            }

            // Ordenação dos dígrafos por frequência e ordem ASCII
            List<Map.Entry<String, Integer>> sortedDigraphs = new ArrayList<>(digraphCount.entrySet());
            sortedDigraphs.sort((a, b) -> {
                if (!b.getValue().equals(a.getValue())) {
                    return b.getValue() - a.getValue();
                }
                return a.getKey().compareTo(b.getKey());
            });

            // Exibir os top 5 dígrafos
            int count = 0;
            for (Map.Entry<String, Integer> entry : sortedDigraphs) {
                if (count >= 5) break;
                double frequency = (double) entry.getValue() / totalDigraphs;
                System.out.printf("%s %d %.6f\n", entry.getKey(), entry.getValue(), frequency);
                count++;
            }
            System.out.println();
        }
        scanner.close();
    }
}
