import java.util.Scanner;

class Dijkstra {

    static final int INF = 9999;

    static void dijkstra(int[][] graph, int source, int n) {

        int[] distance = new int[n];
        boolean[] visited = new boolean[n];

        // Initialize
        for (int i = 0; i < n; i++) {
            distance[i] = INF;
            visited[i] = false;
        }

        distance[source] = 0;

        // Dijkstra Algorithm
        for (int count = 0; count < n - 1; count++) {

            int u = -1;
            int min = INF;

            // Find unvisited vertex with minimum distance
            for (int i = 0; i < n; i++) {
                if (!visited[i] && distance[i] < min) {
                    min = distance[i];
                    u = i;
                }
            }

            if (u == -1)
                break;

            visited[u] = true;

            // Update distances
            for (int v = 0; v < n; v++) {

                if (!visited[v] &&
                    graph[u][v] != 0 &&
                    distance[u] + graph[u][v] < distance[v]) {

                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        // Print shortest distances
        System.out.println("\nShortest distances from source:");

        for (int i = 0; i < n; i++) {
            System.out.println("Vertex " + i + " = " + distance[i]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter source vertex: ");
        int source = sc.nextInt();

        dijkstra(graph, source, n);

        sc.close();
    }
}