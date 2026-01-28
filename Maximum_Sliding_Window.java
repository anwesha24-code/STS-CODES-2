//time complexity: O(n*k)
//space complexity: O(n-k+1)
import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        int k=sc.nextInt();
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        int []ans=new int[n-k+1];
        for(int i=0;i<n-k+1;i++){
            int maxi=Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++)maxi=Math.max(maxi,arr[j]);
            ans[i]=maxi;
        }
        for(int i=0;i<n-k+1;i++)System.out.print(ans[i]+" ");
    }
}
