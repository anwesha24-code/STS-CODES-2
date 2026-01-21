//time complexity: O(n*k)
//space complexity: O(n-k+1)

import java.util.*;
class Maximum_Sliding_Window{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int []ans=new int[n-k+1];
        for(int i=0;i<n-k+1;i++){
            for(int j=i;j<i+k;j++){
                if(j==i)ans[i]=arr[j];
                else ans[i]=Math.max(ans[i],arr[j]);
            }
        }
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
}