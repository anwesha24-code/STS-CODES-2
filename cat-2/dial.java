import java.util.*;

class Pair {
    int v, w;

    Pair(int val, int wt) {
        v = val;
        w = wt;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w)); // remove if directed
        }

        int src = 0; // starting node
        dijkstra(adj, V, src);
    }

    public static void dijkstra(ArrayList<ArrayList<Pair>> adj, int V, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.w - b.w
        );

        dist[src] = 0;
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.v;
            int d = curr.w;

            for (Pair nei : adj.get(node)) {
                int next = nei.v;
                int weight = nei.w;

                if (d + weight < dist[next]) {
                    dist[next] = d + weight;
                    pq.add(new Pair(next, dist[next]));
                }
            }
        }

        // print result
        System.out.println("Shortest distances:");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " -> " + dist[i]);
        }
    }
}
