import java.util.*;
class Largest_Possible_Number_Sort_Array_InPlace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) a[i] = sc.next();

        Arrays.sort(a, (x, y) -> (y + x).compareTo(x + y));
        String res = "";
        for (String s : a)res += s;

        System.out.println(res);
    }
}
