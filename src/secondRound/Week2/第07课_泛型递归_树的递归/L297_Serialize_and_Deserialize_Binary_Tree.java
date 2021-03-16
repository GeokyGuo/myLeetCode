package secondRound.Week2.第07课_泛型递归_树的递归;

import util.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L297_Serialize_and_Deserialize_Binary_Tree {

    public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
        System.out.println(serialize(root));
    }
//    https://zhuanlan.zhihu.com/p/26418233
    /**
     * 二叉树序列化能够重建的充分条件
     * 　　上文讨论的所有情况，可以总结成如下的「定理」：
     * <p>
     * 　　一棵二叉树能够被重建，如果满足下面三个条件之一：
     * 　　　　a1. 已知先序遍历；或
     * 　　　　a2. 已知后序遍历；或
     * 　　　　a3. 已知层序遍历；
     * 　　且满足下面三个条件之一：
     * 　　　　b1. 前面已知的那种遍历包含了空指针；或
     * 　　　　b2. 已知中序遍历，且树中不含重复元素；或
     * 　　　　b3. 树是二叉搜索树，且不含重复元素。
     * 　　这是本文的主要结论。它指出，中序遍历提供的信息，与空指针和 BST 是相同的，而与先序、后序、层序遍历提供的信息互补。
     * 同时，这个充分条件也几乎是必要的，因为如果仅满足 a 组的两个条件，或者仅满足 b 组的两个条件，都不能重建二叉树。
     **/

    // Encodes a tree to a single string.
    public  static String serialize(TreeNode root) {
        if (root == null) {
            return "#,";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);

        return root.val + "," + left + right;
//        return root.val + "," + left + "," + right + ","; //不要写成这种形式，会多出很多不必要的逗号
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        List<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return builder(list);
    }

    TreeNode builder(List<String> list) {
        String temp = list.remove(0);
        if ("#".equals(temp)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(temp));
        root.left = builder(list);
        root.right = builder(list);
        return root;
    }
}
