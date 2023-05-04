package secondRound.Week2.第06课_树_二叉树_二叉搜索树;

import java.util.*;

public class Note_前中后DFS大一统_后序巧解 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List reList = trans(root);
        System.out.println(Arrays.toString(reList.toArray()));
    }

    static List<Integer> trans(TreeNode root) {  //本质上就是   在栈里边排好顺序，第一次标记1入栈的本质是在  根 左右   标记一下下次谁最先被访问，变色后出来的时候  就是访问的时候

        List<Integer> reList = new ArrayList<>();
        if (root == null) return reList;
        Deque<colorTreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(new colorTreeNode(root, 0));

        while (!stack.isEmpty()) {
            colorTreeNode node = stack.pollFirst();

            if (node.flag == 0) {//第一次出栈

                stack.offerFirst(new colorTreeNode(node.node, 1));
                if (node.node.right != null)
                    stack.offerFirst(new colorTreeNode(node.node.right, 0)); //进栈标0，为出栈做准备，最终一定要出栈
                if (node.node.left != null) stack.offerFirst(new colorTreeNode(node.node.left, 0));
            } else {//第二次出0
                reList.add(node.node.val);
            }
        }
        return reList;
    }

}

class colorTreeNode {
    TreeNode node;
    Integer flag;

    public colorTreeNode(TreeNode node, Integer flag) {
        this.flag = flag;
        this.node = node;
    }


//    后序的巧妙解法
//    接下来我们思考一下前序遍历和后序遍历之间的关系：
//
//    前序遍历顺序为：根 -> 左 -> 右
//
//    后序遍历顺序为：左 -> 右 -> 根
//
//    如果1： 我们将前序遍历中节点插入结果链表尾部的逻辑，修改为将节点插入结果链表的头部
//
//    那么结果链表就变为了：右 -> 左 -> 根
//
//    如果2： 我们将遍历的顺序由从左到右修改为从右到左，配合如果1
//
//    那么结果链表就变为了：左 -> 右 -> 根
//
//            这刚好是后序遍历的顺序
//
//    基于这两个思路，我们想一下如何处理：
//
//    修改前序遍历代码中，节点写入结果链表的代码，将插入队尾修改为插入队首
//
//    修改前序遍历代码中，每次先查看左节点再查看右节点的逻辑，变为先查看右节点再查看左节点


    //2023.04.22 结论：还是要看这两篇文章
//    https://blog.csdn.net/My_Jobs/article/details/43451187
//    https://leetcode.cn/problems/binary-tree-postorder-traversal/solution/die-dai-jie-fa-shi-jian-fu-za-du-onkong-jian-fu-za/
}

