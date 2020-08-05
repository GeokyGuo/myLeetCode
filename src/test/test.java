package test;


import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class test {
    public static Sout<Innesout> insout = new Sout<Innesout>(new Innesout());
    public static void main(String[] args) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        System.out.println(queue.size());
    }

    private static class Sout<I> {
        public Sout(I innesout) {

        }
    }
    private static class Innesout {

    }
}
