package secondRound.Week2.第07课_泛型递归_树的递归;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class L105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    public static void main(String[] args) {

    }
//感觉递归最难的就是算递推关系了，还有想有什么参数，大佬有什么好的训练方法吗，
// 有时候我函数的参数想不出来，有时候那个递推关系也是感觉很混乱，+1-1的总搞不清楚

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode buildTree(int[] pre, int pStart, int pEnd, int[] inoder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        int rootVal = pre[pStart];
        TreeNode root = new TreeNode(rootVal);
        int index = 0;
        while (rootVal!=inoder[index]) {
            index++;
        }
        root.left = buildTree(pre, pStart + 1, index - iStart + pStart, inoder, iStart, index - 1);
        root.right = buildTree(pre, index - iStart + pStart + 1, pEnd, inoder, index + 1, iEnd);
        return root;
    }

    //优化后的标准答案
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree1(preorder, 0, preorder.length - 1,map, 0, inorder.length - 1);
    }

    TreeNode buildTree1(int[] pre, int pStart, int pEnd, Map<Integer, Integer> inoder, int iStart, int iEnd) {

        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        int rootVal = pre[pStart];
        TreeNode root = new TreeNode(rootVal);
        int index = inoder.get(rootVal);

        root.left = buildTree1(pre, pStart + 1, index - iStart + pStart, inoder, iStart, index - 1);
        root.right = buildTree1(pre, index - iStart + pStart + 1, pEnd, inoder, index + 1, iEnd);
        return root;
    }
}
