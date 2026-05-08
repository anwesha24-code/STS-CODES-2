//method-1

//recover bst trick method
//input array containing tree values
//output array containing recovered values

import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String []arr=s.split(" ");
        int []ans=new int[arr.length];
        for(int i=0;i<arr.length;i++)ans[i]=Integer.parseInt(arr[i]);
        Arrays.sort(ans);
        for(int a:ans)System.out.println(a);
    }
}

//-----------------------------------------------------------

//method-2

//format followed
//get String input and build tree
//traverse inorder(any traversal can be followed) and store in list
//sort the list and build the tree again using sorted list
import java.util.*;
public class recoverbst {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
    public static TreeNode buildTree(String[] arr) {
        if (arr.length == 0 || arr[0].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();
            if (i < arr.length && !arr[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(current.left);
            }
            i++;
            if (i < arr.length && !arr[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }
    public static List<Integer>lst=new ArrayList<>();
    public static void inorder(TreeNode root){
        if (root!=null) {
            inorder(root.left);
            lst.add(root.val);
            inorder(root.right);
        }
        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String []arr=s.split(" ");
        TreeNode root=buildTree(arr);
        inorder(root);
        Collections.sort(lst);
        String []bstarray=new String[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            bstarray[i] = String.valueOf(lst.get(i));
        }
        TreeNode finalroot=buildTree(bstarray);
    }
}