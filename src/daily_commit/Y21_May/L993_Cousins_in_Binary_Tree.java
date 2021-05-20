package daily_commit.Y21_May;

import util.TreeNode;

public class L993_Cousins_in_Binary_Tree {
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] x_ = dfs(root, null, 0, x);
        int[] y_ = dfs(root, null, 0, y);

        if (x_[1] == y_[1]) return x_[0] != y_[0];
        else return false;
    }

    int[] dfs(TreeNode root, TreeNode fa, int deep, int target) {
        if (root == null) {
            return new int[]{-1, -1};
        }
        if (root.val == target) {
            return fa == null ? new int[]{-1, deep} : new int[]{fa.val, deep};
        }
        int[] l = dfs(root.left, root, deep + 1, target);
        if (l[0] != -1) return l;
        else return dfs(root.right, root, deep + 1, target);
    }
}
