import java.util.Scanner;

class Main {

    static int n;
    static int[][] M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();          // number of people
        M = new int[n][n];
        // input matrix
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                M[i][j] = sc.nextInt();

        for (int i = 0; i < n; i++) {
            if (check(i)) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);   // no celebrity
        sc.close();
    }

    public static boolean check(int c) {

        // row check: celebrity knows no one
        for (int j = 0; j < n; j++)
            if (M[c][j] == 1)
                return false;
        // column check: everyone knows celebrity
        for (int i = 0; i < n; i++)
            if (i != c && M[i][c] == 0)
                return false;
        return true;
    }
}
