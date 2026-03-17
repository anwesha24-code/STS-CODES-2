import java.util.PriorityQueue;

public class Priority_Queue {
    public static void main(String[] args) {

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> b[1] - a[1]);

        pq.add(new int[]{2, 3}); // value=2, priority=3
        pq.add(new int[]{3, 4}); // value=3, priority=4

        System.out.println(pq.poll()[0]); // prints value
    }
}
