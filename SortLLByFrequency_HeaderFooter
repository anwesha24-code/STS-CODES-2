
import java.util.*;

class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class Main {

//function to be written------------------------
    
Node temp=head;int len=0;
while(temp!=null){
    temp=temp.next;
    len++;
}
temp=head;
HashMap<Integer,Integer>hmp=new HashMap<>();
while(temp!=null){
    hmp.put(temp.val,hmp.getOrDefault(temp.val,0)+1);
    temp=temp.next;
}
int [][]arr=new int[hmp.size()][2];int i=0;
for(Map.Entry<Integer,Integer>ent:hmp.entrySet()){
    arr[i][0]=ent.getKey();
    arr[i][1]=ent.getValue();
    i++;
}
Arrays.sort(arr,(a,b)->b[1]-a[1]);
temp=head;
i=0;
while(temp!=null && i<arr.length){
    for(int j=0;j<arr[i][1];j++){
        temp.val=arr[i][0];
        temp=temp.next;
    }
    i++;
}
//-----------------------------------------------

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Node head = null, temp = null;

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;
                temp = head;
            } else {
                temp.next = newNode;
                temp = temp.next;
            }
        }
        sort(head);
        Node trav = head;
        while (trav != null) {
            System.out.println(trav.val);
            trav = trav.next;
        }
    }
}

