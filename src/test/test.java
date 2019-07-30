package test;



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

public class test {

    public static void main(String[] args) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        System.out.println(queue.size());
    }
}
