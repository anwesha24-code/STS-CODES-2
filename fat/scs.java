import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next(), b = sc.next();
        int n = a.length(), m = b.length();

        int[][] dp = new int[n+1][m+1];

        // LCS calculation
        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
                dp[i][j] = (a.charAt(i-1)==b.charAt(j-1)) 
                    ? 1 + dp[i-1][j-1] 
                    : Math.max(dp[i-1][j], dp[i][j-1]);

        // length of SCS
        System.out.print(n + m - dp[n][m]);
    }
}