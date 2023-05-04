package secondRound.Week2.第06课_树_二叉树_二叉搜索树;

import java.util.*;

public class L144_Binary_Tree_Preorder_Traversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List reList = preorderTraversal2(root);
        System.out.println(Arrays.toString(reList.toArray()));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> reList = new ArrayList<>();
        preorderTraversal(reList,root);
        return reList;
    }
    static void preorderTraversal(List reList,TreeNode root){
        if(root==null) return;
        reList.add(root.val);
        preorderTraversal(reList, root.left);
        preorderTraversal(reList, root.right);
    }



    //复习
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> reList = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

//        TreeNode s= null;
//        stack.offerFirst(s); 验证 stack 中不能push null

        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                reList.add(p.val);
                if (p.right != null) stack.offerFirst(p.right);
                p = p.left;
            }
            p = stack.pollFirst();
        }
        return reList;
    }

    //自己悟出的更好理解的前序方法，和中序的本质都是一样的，只是往列表中放的时机不一样
    public List<Integer> preorderTraversal3(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        List<Integer> resList = new ArrayList<>();

        while(!stack.isEmpty() || p != null){
            while(p != null){
                stack.offerLast(p);
                resList.add(p.val);
                p = p.left;
            }
            TreeNode temp = stack.pollLast();
            p = temp.right;
        }
        return resList;
    }

    //新增版本
    //144 非递归
    public List<Integer> preorderTraversal1(util.TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<util.TreeNode> stack = new ArrayDeque<>();
        util.TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            } else {
                util.TreeNode pop = stack.pop();
                cur = pop.right;
            }
        }

        return res;
    }

}
