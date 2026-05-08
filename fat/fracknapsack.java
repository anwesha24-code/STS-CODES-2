import java.util.*;

class fracknapsack {
    static class Item {
        int wt, val;
        Item(int w, int v) { wt = w; val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // number of items
        int W = sc.nextInt();   // capacity

        Item[] a = new Item[n];

        for (int i = 0; i < n; i++) {
            int wt = sc.nextInt();
            int val = sc.nextInt();
            a[i] = new Item(wt, val);
        }

        // sort by value/weight ratio (descending)
        Arrays.sort(a, (x, y) -> Double.compare((double)y.val/y.wt, (double)x.val/x.wt));

        double profit = 0;

        for (Item i : a) {
            if (W >= i.wt) {
                profit += i.val;
                W -= i.wt;
            } else {
                profit += (double)i.val * W / i.wt;
                break;
            }
        }

        System.out.println(profit);
    }
}