package test;


import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class test {

    public static void main(String[] args) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        System.out.println(queue.size());
    }
}
