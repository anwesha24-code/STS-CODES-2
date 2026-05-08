import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p=sc.nextInt();
        System.out.println(countways(n,p));
    }
    public static int countways(int item,int person){
        if(person==0){
            if(item==0)return 1;
            return 0;
        }
        int total=0;
        if(item>=0)total+=countways(item,person-1);
        if(item>=1)total+=countways(item-1,person-1);
        if(item>=2)total+=countways(item-2,person-1);
        return total;
    }
}