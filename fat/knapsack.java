import java.util.*;

class knapsack{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of items
        int W = sc.nextInt(); // capacity

        int[] wt = new int[n];
        int[] val = new int[n];

        for (int i = 0; i < n; i++) wt[i] = sc.nextInt();
        for (int i = 0; i < n; i++) val[i] = sc.nextInt();

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] <= j)
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        System.out.println(dp[n][W]);
    }
}