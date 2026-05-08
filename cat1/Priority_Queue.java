package cat1;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Priority_Queue {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<n;i++){
            int val=sc.nextInt();
            int prio=sc.nextInt();
            pq.add(new int[]{val,prio});
        }
        System.out.println(pq.poll()[0]);
    }
}
