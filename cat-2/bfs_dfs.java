//method-1
//without constructing adjacency list
static void bfs(int n, int[][] edges, int start) {
    boolean[] visited = new boolean[n + 1];
    Queue<Integer> q = new LinkedList<>();

    q.add(start);
    visited[start] = true;

    while (!q.isEmpty()) {
        int node = q.poll();
        System.out.print(node + " ");
        for (int[] e : edges) {
            int u = e[0], v = e[1];

            if (u == node && !visited[v]) {
                visited[v] = true;
                q.add(v);
            } else if (v == node && !visited[u]) {
                visited[u] = true;
                q.add(u);
            }
        }
    }
}
static void dfs(int node, int[][] edges, boolean[] visited) {
    visited[node] = true;
    System.out.print(node + " ");

    for (int[] e : edges) {
        int u = e[0], v = e[1];

        if (u == node && !visited[v]) {
            dfs(v, edges, visited);
        } else if (v == node && !visited[u]) {
            dfs(u, edges, visited);
        }
    }
}

//------------------------------------------------------------------------

//method-2
import java.util.*;

public class bfs_dfs {

    static void bfs(int start, ArrayList<ArrayList<Integer>> adj, int V) {

        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {

            int node = q.poll();
            System.out.print(node + " ");

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }

    static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {

        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); // number of vertices
        int E = sc.nextInt(); // number of edges

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // reading edges
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u); // remove if directed graph
        }

        System.out.print("BFS: ");
        bfs(0, adj, V);

        System.out.println();

        System.out.print("DFS: ");
        boolean[] visited = new boolean[V];
        dfs(0, visited, adj);

        sc.close();
    }
}
