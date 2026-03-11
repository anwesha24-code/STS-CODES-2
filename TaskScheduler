import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][]=new int [n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }
        Arrays.sort(arr, (a, b) -> {
            if (b[1] != a[1]) return b[1] - a[1]; // priority not same
            return a[0] - b[0]; // if priority same we take task id
        });
        for(int i=0;i<n;i++)System.out.print(arr[i][0]+" ");
    }
}
