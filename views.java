import java.util.*;

public class views {
    static class TreeNode{
        int val;
        TreeNode left;TreeNode right;
        TreeNode(int x){
            val=x;left=null;right=null;
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
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String []arr=s.split(" ");
        TreeNode root=buildTree(arr);
        leftview(root);
        rightview(root);
        bottomview(root);
        verticalview(root);
        topview(root);
    }
    static void leftview(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(i==0)System.out.print(curr.val + " ");   //for left print the first element of each level
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
    }
    static void rightview(TreeNode root){
        if(root==null)return;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(i==size-1)System.out.print(curr.val + " ");    //for right print the last element of each level
                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);
            }
        }
    }

    static class Pair{
        TreeNode node;
        int hd;
        Pair(TreeNode n,int h){
            node=n;
            hd=h;
        }
    }
    static void bottomview(TreeNode root){
        if(root==null) return;

        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();

        q.add(new Pair(root,0));

        while(!q.isEmpty()){
            Pair p = q.poll();

            map.put(p.hd,p.node.val);

            if(p.node.left!=null)
                q.add(new Pair(p.node.left,p.hd-1));

            if(p.node.right!=null)
                q.add(new Pair(p.node.right,p.hd+1));
        }

        for(int val:map.values())
            System.out.print(val+" ");
    }

    static void topview(TreeNode root){
        if(root==null) return;

        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();

        q.add(new Pair(root,0));

        while(!q.isEmpty()){
            Pair p = q.poll();

            if(!map.containsKey(p.hd))
                map.put(p.hd,p.node.val);

            if(p.node.left!=null)
                q.add(new Pair(p.node.left,p.hd-1));

            if(p.node.right!=null)
                q.add(new Pair(p.node.right,p.hd+1));
        }

        for(int val:map.values())
            System.out.print(val+" ");
    }
    
}
