package daily_commit.Y21_May;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L872_Leaf_Similar_Trees {
    //ArrayList存储叶子节点
    private ArrayList<Integer> arr1 = new ArrayList<>();
    private ArrayList<Integer> arr2 = new ArrayList<>();

    //中序遍历求从左到右的叶子节点值
    public void midOrderImprovement(TreeNode root, List<Integer> list) {
        if (root != null) {

            if (root.left == null && root.right == null) {
                list.add(root.val);
            }
            midOrderImprovement(root.left, list);
            midOrderImprovement(root.right, list);
        }
    }

    //返回arr1和arr2的比较值
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        midOrderImprovement(root1, arr1);
        midOrderImprovement(root2, arr2);
        return arr1.equals(arr2);
    }
}
//list是否相等要用equal来比较
