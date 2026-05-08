//Recursive
//Time Complexity: O((V-1)!) 
//Space Complexity: O(V)

//Dynamic Programming
//Time Complexity: O(N^2 * 2^N)
// Space Complexity: O(N * 2^N)

import java.util.*;

class Main {
    static int tsp(int[][] g, boolean[] v, int curr, int n, int count, int cost, int ans) {
        if (count == n && g[curr][0] > 0)
            return Math.min(ans, cost + g[curr][0]);

        for (int i = 0; i < n; i++) {
            if (!v[i] && g[curr][i] > 0) {
                v[i] = true;
                ans = tsp(g, v, i, n, count+1, cost + g[curr][i], ans);
                v[i] = false;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] g = new int[n][n];

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                g[i][j] = sc.nextInt();

        boolean[] v = new boolean[n];
        v[0] = true;

        System.out.print(tsp(g, v, 0, n, 1, 0, Integer.MAX_VALUE));
    }
}