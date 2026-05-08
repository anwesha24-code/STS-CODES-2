import java.util.*;
//Recursive O(2^n) O(n)
//Dynamic Programming O(n^2) O(n)
class Main {
    static int cut(int[] p, int n) {
        if (n == 0) return 0;
        int max = 0;
        for (int i = 0; i < n; i++)
            max = Math.max(max, p[i] + cut(p, n - i - 1));
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] price = new int[n];
        for (int i = 0; i < n; i++) price[i] = sc.nextInt();
        System.out.print(cut(price, n));
    }
}