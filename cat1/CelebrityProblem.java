import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] M = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                M[i][j] = sc.nextInt();

        int celebrity = -1;
        for (int row = 0; row < n; row++) {
            boolean ans = true;
            for (int col = 0; col < n; col++) {
                if (M[row][col] == 1) {
                    ans = false;
                    break;
                }
            }
            if (ans) {
                for (int i = 0; i < n; i++) {
                    if (i != row && M[i][row] == 0) {
                        ans = false;
                        break;
                    }
                }
            }
            if (ans) {
                celebrity = row;
                break;
            }
        }

        System.out.println(celebrity);
    }
}
