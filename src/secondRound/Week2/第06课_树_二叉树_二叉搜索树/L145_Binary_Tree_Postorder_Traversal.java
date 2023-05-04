package secondRound.Week2.第06课_树_二叉树_二叉搜索树;

import java.util.*;

public class L145_Binary_Tree_Postorder_Traversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List reList = postorderTraversal1(root);
        System.out.println(Arrays.toString(reList.toArray()));

    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> reList = new ArrayList<>();
        postorderTraversal(reList, root);
        return reList;
    }

    static void postorderTraversal(List<Integer> reList, TreeNode root) {
        if (root == null) return;
        postorderTraversal(reList, root.left);
        postorderTraversal(reList, root.right);
        reList.add(root.val);
    }

    public static List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> reList = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, Integer> map = new HashMap<>(); //用map去标记 从左子树弹出还是右子树弹出

        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                map.put(p, 0);
                stack.offerFirst(p);
                p = p.left;
            }
            while (!stack.isEmpty() && map.get(stack.peekFirst()) == 1) {
                reList.add(stack.poll().val);   //中间 第二次到跟节点 直接弹出即可，不要去改动p
            }
            if (!stack.isEmpty()) {
                TreeNode temp = stack.peekFirst();
                map.put(temp, 1);
                p = temp.right;
            }
        }
        return reList;
    }

    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> reList = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.offerFirst(p);
                map.put(p, 0);
                p = p.left;
            }

            while (!stack.isEmpty() && map.get(stack.peekFirst()) == 1) {  //从右边 退根的时候，会一直退
                reList.add(stack.pollFirst().val);
            }

            if (!stack.isEmpty()) {
                map.put(stack.peekFirst(), 1);
                p = stack.peekFirst().right;
            }
        }

        return reList;
    }

    //145
    public List<Integer> postorderTraversal(util.TreeNode root) {
        Deque<util.TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        util.TreeNode cur = root;
        util.TreeNode r = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                util.TreeNode peek = stack.peek();
                if (peek.right != null && peek.right != r) {
                    cur = peek.right;
                } else {
                    util.TreeNode pop = stack.pop();
                    res.add(pop.val);
                    r = pop;
                }
            }
        }

        return res;
    }
}
