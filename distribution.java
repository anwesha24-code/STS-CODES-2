import java.util.*;

public class distribution {
    static int countWays(int i, int persons, int items){
        if(i == persons){
            if(items == 0) return 1;
            return 0;
        }

        int ways = 0;

        for(int j = 0; j <= 2; j++){
            if(items - j >= 0)
                ways += countWays(i+1, persons, items-j);
        }

        return ways;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int items = sc.nextInt();
        int persons = sc.nextInt();

        System.out.println(countWays(0, persons, items));
    }
}