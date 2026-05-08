import java.util.*;
//Recursive
// /Time Complexity O(3^(N * M))
//Space Complexity O(N + M)

//Dynamic Programming
//Time Complexity: O(n * m) 
//Space Complexity: O(n * m) 
class Main {
    static int f(String a, String b, int i, int j) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        if (a.charAt(i) == b.charAt(j))
            return f(a, b, i-1, j-1);

        return 1 + Math.min(
                f(a, b, i-1, j),     // delete
                Math.min(
                    f(a, b, i, j-1), // insert
                    f(a, b, i-1, j-1) // replace
                )
        );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next(), b = sc.next();
        System.out.print(f(a, b, a.length()-1, b.length()-1));
    }
}