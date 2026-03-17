import java.util.*;

public class boundary_traversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode buildTree(String[] arr) {
        if (arr.length == 0 || arr[0].equals("null"))
            return null;
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

    static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    static void leftBoundary(TreeNode root) {

        TreeNode curr = root.left;

        while (curr != null) {

            if (!isLeaf(curr))
                System.out.print(curr.val + " ");

            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }

    static void leafNodes(TreeNode root) {

        if (root == null)
            return;

        if (isLeaf(root)) {
            System.out.print(root.val + " ");
            return;
        }

        leafNodes(root.left);
        leafNodes(root.right);
    }

    static void rightBoundary(TreeNode root) {

        TreeNode curr = root.right;
        Stack<Integer> stack = new Stack<>();

        while (curr != null) {

            if (!isLeaf(curr))
                stack.push(curr.val);

            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }

        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    static void boundaryTraversal(TreeNode root) {

        if (root == null)
            return;

        System.out.print(root.val + " ");

        leftBoundary(root);

        leafNodes(root.left);
        leafNodes(root.right);

        rightBoundary(root);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String[] arr = s.split(" ");

        TreeNode root = buildTree(arr);

        boundaryTraversal(root);

        sc.close();
    }
}