import java.util.*;

public class winnertree {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        while(n > 1){

            int k = 0;

            for(int i = 0; i < n; i += 2){
                if(i + 1 < n)
                    arr[k++] = Math.min(arr[i], arr[i+1]);
                else
                    arr[k++] = arr[i];
            }

            n = k;
        }
        System.out.println("Winner: " + arr[0]);
    }
}