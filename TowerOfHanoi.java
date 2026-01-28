import java.util.*;
public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long moves = (1L << n) - 1;
        System.out.println(moves);
        process(n,"A","B","C");
    }
    public static void process(int n,String src,String dest,String aux){
        if(n==1){
            System.out.println(src+"to"+dest);
            return;
        }
        process(n-1,src,aux,dest);
        System.out.println(src+"to"+dest);
        process(n-1,aux,dest,src);
    }
            
}
