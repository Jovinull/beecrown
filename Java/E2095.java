import java.util.*;

public class E2095 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê o número de soldados em cada exército (S)
        int S = scanner.nextInt();

        // Lê as habilidades dos soldados de Quadradônia
        int[] quadradonia = new int[S];
        for (int i = 0; i < S; i++) {
            quadradonia[i] = scanner.nextInt();
        }

        // Lê as habilidades dos soldados de Noglônia
        int[] noglonia = new int[S];
        for (int i = 0; i < S; i++) {
            noglonia[i] = scanner.nextInt();
        }

        // Ordena as habilidades de ambos os exércitos
        Arrays.sort(quadradonia);
        Arrays.sort(noglonia);

        int victories = 0;
        int i = 0, j = 0;

        // Usando dois ponteiros para maximizar as vitórias de Noglônia
        while (i < S && j < S) {
            if (noglonia[j] > quadradonia[i]) {
                victories++;
                i++; // Avança no exército de Quadradônia
            }
            j++; // Sempre avança no exército de Noglônia
        }

        // Imprime o número máximo de batalhas que Noglônia pode vencer
        System.out.println(victories);

        scanner.close();
    }
}
