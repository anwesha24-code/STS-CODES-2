import java.util.*;
//Time Complexity: O(n*n)
//Space Complexity: O(n)
class Main {
    static boolean f(String s, String p, int i, int j) {
        if (i < 0 && j < 0) return true;
        if (j < 0) return false;
        if (i < 0) {
            for (int k = 0; k <= j; k++) if (p.charAt(k) != '*') return false;
            return true;
        }
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
            return f(s, p, i-1, j-1);
        if (p.charAt(j) == '*')
            return f(s, p, i-1, j) || f(s, p, i, j-1);
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(), p = sc.next();
        System.out.print(f(s, p, s.length()-1, p.length()-1));
    }
}