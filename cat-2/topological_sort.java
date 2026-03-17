import java.util.*;

class topological_sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        int[] indegree = new int[V];

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt(); // u → v
            adj.get(u).add(v);
            indegree[v]++;
        }

        topoSort(adj, indegree, V);
    }

    static void topoSort(ArrayList<ArrayList<Integer>> adj, int[] indegree, int V) {
        Queue<Integer> q = new LinkedList<>();

        // push nodes with indegree 0
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }
    }
}