import java.util.Scanner;

public class Stock_Span_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] price = new int[n];
        for (int i = 0; i < n; i++)
            price[i] = sc.nextInt();

        int[] span = new int[n];

        for (int i = 0; i < n; i++) {
            span[i] = 1;
            for (int j = i - 1; j >= 0 && price[j] <= price[i]; j--)
                span[i]++;
        }

        for (int x : span)
            System.out.print(x + " ");
    }

}
