import java.util.*;

public class vertical_traversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
    static class Pair {
        TreeNode node;
        int hd;
        Pair(TreeNode n, int h) {
            node = n;
            hd = h;
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.split(" ");
        TreeNode root = buildTree(arr);
        verticalTraversal(root);
    }
    static void verticalTraversal(TreeNode root) {

        if (root == null)
            return;

        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair p = q.poll();

            map.putIfAbsent(p.hd, new ArrayList<>());
            map.get(p.hd).add(p.node.val);

            if (p.node.left != null)
                q.add(new Pair(p.node.left, p.hd - 1));

            if (p.node.right != null)
                q.add(new Pair(p.node.right, p.hd + 1));
        }

        for (List<Integer> list : map.values()) {
            for (int x : list)
                System.out.print(x + " ");
            System.out.println();
        }
    }
}
