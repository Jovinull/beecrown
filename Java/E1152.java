import java.util.*;

public class E1152 {
    static class Edge implements Comparable<Edge> {
        int u, v, weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    static int[] parent, rank;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int N = sc.nextInt(); // Número de cidades (vértices)
            int M = sc.nextInt(); // Número de estradas (arestas)
            
            if (N == 0 && M == 0) break; // Condição de parada

            List<Edge> edges = new ArrayList<>();
            int totalCost = 0;

            // Lendo as arestas
            for (int i = 0; i < M; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                edges.add(new Edge(u, v, w));
                totalCost += w; // Soma total do custo das estradas
            }

            // Ordenamos as arestas pelo menor peso
            Collections.sort(edges);

            // Inicializando a estrutura de União-Find
            parent = new int[N];
            rank = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                rank[i] = 0;
            }

            // Algoritmo de Kruskal para encontrar a MST
            int mstCost = 0;
            int edgesUsed = 0;

            for (Edge edge : edges) {
                if (union(edge.u, edge.v)) { // Se a aresta pode ser usada sem formar ciclos
                    mstCost += edge.weight;
                    edgesUsed++;
                    if (edgesUsed == N - 1) break; // Já formamos a MST
                }
            }

            // Economia: total de estradas - custo da MST
            System.out.println(totalCost - mstCost);
        }
        sc.close();
    }

    // Método para encontrar a raiz do conjunto (Union-Find com compressão de caminho)
    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Compressão de caminho
        }
        return parent[x];
    }

    // Método para unir dois conjuntos (Union-Find com união por rank)
    static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return false; // Já estão no mesmo conjunto

        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }
}
