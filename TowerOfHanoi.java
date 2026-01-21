public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long moves = (1L << n) - 1;
        System.out.println(moves);
    }
}
