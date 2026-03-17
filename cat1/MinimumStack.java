import java.util.Scanner;

public class MinimumStack {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] stack = new int[100];
        int top = -1;

        int n = sc.nextInt();
        // PUSH using loop
        for (int i = 0; i < n; i++) {
            stack[++top] = sc.nextInt();
        }

        // FIND MIN using loop
        int min = stack[0];
        for (int i = 1; i <= top; i++) {
            if (stack[i] < min) {
                min = stack[i];
            }
        }
        System.out.println("Minimum element = " + min);
    }
}
