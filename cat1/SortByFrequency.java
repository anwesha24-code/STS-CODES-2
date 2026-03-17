import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] != b[1])
                    return a[1] - b[1];   // increasing frequency
                return a[0] - b[0];       // value order if same freq
            }
        );

        for (int key : freq.keySet()) {
            pq.add(new int[]{key, freq.get(key)});
        }

        int idx = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int value = cur[0];
            int count = cur[1];

            for (int i = 0; i < count; i++) {
                arr[idx++] = value;
            }
        }

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
