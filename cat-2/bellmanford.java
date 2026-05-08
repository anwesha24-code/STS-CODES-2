import java.util.*;
class Edge {
    int u, v, w;
    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}
class bellmanFord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new Edge(u, v, w));
        }
        int src = 0; // source node
        bellmanFord(V, edges, src);
    }
    static void bellmanFord(int V, ArrayList<Edge> edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        // relax edges V-1 times
        for (int i = 1; i <= V - 1; i++) {
            for (Edge e : edges) {
                if (dist[e.u] != Integer.MAX_VALUE &&
                    dist[e.u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.w;
                }
            }
        }
        // check negative cycle
        for (Edge e : edges) {
            if (dist[e.u] != Integer.MAX_VALUE &&
                dist[e.u] + e.w < dist[e.v]) {
                System.out.println("Negative cycle detected!");
                return;
            }
        }
        // print distances
        System.out.println("Shortest distances:");
        for (int i = 0; i < V; i++) {
            System.out.println(src + " -> " + i + " = " + dist[i]);
        }
    }
}