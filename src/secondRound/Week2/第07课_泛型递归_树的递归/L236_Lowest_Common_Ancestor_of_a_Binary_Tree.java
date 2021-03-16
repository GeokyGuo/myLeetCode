package secondRound.Week2.第07课_泛型递归_树的递归;

import util.TreeNode;

public class L236_Lowest_Common_Ancestor_of_a_Binary_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}

//后序，
//递归函数功能，lowestCommonAncestor这个函数不要理解为找公共祖先” 是的，这是很关键的地方
//因为是递归，使用函数后可认为左右子树已经算出结果

//    算法
//            (递归) O(n)O(n)
//
//        当我们用递归去做这个题时不要被题目误导，应该要明确一点
//        这个函数的功能有三个：给定两个节点 pp 和 qq
//
//        如果 pp 和 qq 都存在，则返回它们的公共祖先；
//        如果只存在一个，则返回存在的一个；
//        如果 pp 和 qq 都不存在，则返回NULL
//        本题说给定的两个节点都存在，那自然还是能用上面的函数来解决
//
//        具体思路：
//        （1） 如果当前结点 rootroot 等于 NULL，则直接返回 NULL
//        （2） 如果 rootroot 等于 pp 或者 qq ，那这棵树一定返回 pp 或者 qq
//        （3） 然后递归左右子树，因为是递归，使用函数后可认为左右子树已经算出结果，用 leftleft 和 rightright 表示
//        （4） 此时若leftleft为空，那最终结果只要看 rightright；若 rightright 为空，那最终结果只要看 leftleft
//        （5） 如果 leftleft 和 rightright 都非空，因为只给了 pp 和 qq 两个结点，都非空，说明一边一个，因此 rootroot 是他们的最近公共祖先
//        （6） 如果 leftleft 和 rightright 都为空，则返回空（其实已经包含在前面的情况中了）
//
//        时间复杂度是 O(n)O(n)：每个结点最多遍历一次或用主定理，空间复杂度是 O(n)O(n)：需要系统栈空间
