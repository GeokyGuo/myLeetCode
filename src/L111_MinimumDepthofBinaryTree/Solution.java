package L111_MinimumDepthofBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
//
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(3);
//
//        root.right.left = null;
//        root.right.right = null;
//
//
//        root.left.left.left = new TreeNode(4);
//        root.left.left.right = new TreeNode(4);


        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;

        queue.add(root);

        while (true) {
            int size = queue.size();
            int flag = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node==null) {
                    continue;
                }
                if (node.left == null && node.right == null) {
                    flag = 1;
                    break;

                }
                queue.add(node.left);
                queue.add(node.right);
            }
            level++;
            if (flag==1) {
                break;
            }
        }

        return level;
    }

}
//null 放到队列中占不占位？？？