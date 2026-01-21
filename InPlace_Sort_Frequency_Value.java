import java.util.*;

class InPlace_Sort_Frequency_Value {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int x : arr)
            freq.put(x, freq.getOrDefault(x, 0) + 1);

        Arrays.sort(arr, (a, b) -> {
            if (!freq.get(a).equals(freq.get(b)))
                return freq.get(b) - freq.get(a);   // freq desc
            return b - a;                           // value desc
        });

        for (int x : arr)
            System.out.print(x + " ");
    }
}
