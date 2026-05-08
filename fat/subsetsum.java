import java.util.*;
// Recursive
// Time ComplexityO(2ⁿ) 
// Space ComplexityO(n)

// Dynamic Programming
// Time Complexity O(n × sum) 
// Space Complexity O(n × sum)
class Main {
    static boolean f(int[] a, int n, int sum) {
        if (sum == 0) return true;
        if (n == 0) return false;

        if (a[n-1] > sum)
            return f(a, n-1, sum);

        return f(a, n-1, sum) || f(a, n-1, sum - a[n-1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sum = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++) a[i] = sc.nextInt();

        System.out.print(f(a, n, sum));
    }
}