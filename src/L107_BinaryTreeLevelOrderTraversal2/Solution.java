package L107_BinaryTreeLevelOrderTraversal2;


import java.util.List;
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        int maxDeep = getMaxDeep(root);
       // Queue<Integer> queue = new Queue<Integer>();
        return null;
    }

    private int getMaxDeep(TreeNode root) {

        return 0;
    }
}
