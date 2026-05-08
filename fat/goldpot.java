//Recursive
//Time Complexity: O(2^n)
//Space Complexity: O(n) 

//Dynamic Programming
//Time Complexity: O(n^2)
//Space Complexity: O(n^2)

import java.util.*;

class Main {
    static int f(int[] a, int i, int j) {
        if (i > j) return 0;
        return Math.max(
            a[i] + Math.min(f(a, i+2, j), f(a, i+1, j-1)),
            a[j] + Math.min(f(a, i+1, j-1), f(a, i, j-2))
        );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++) a[i] = sc.nextInt();
        System.out.print(f(a, 0, n-1));
    }
}