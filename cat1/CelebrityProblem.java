package cat1;import java.util.*;

class Main {
    static int celebrity(int[][] M, int n) {
        int a = 0;
        int b = n - 1;
        while(a < b) {
            if(M[a][b] == 1) {
                a++;
            } else {
                b--;
            }
        }
        int c = a;
        for(int i = 0; i < n; i++) {
            if(i != c) {
                if(M[c][i] == 1 || M[i][c] == 0) {
                    return -1;
                }
            }
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] M = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                M[i][j] = sc.nextInt();
            }
        }
        System.out.println(celebrity(M,n));
    }
}