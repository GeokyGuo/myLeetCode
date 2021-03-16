package test;


import util.TreeNode;

import java.util.*;

public class test {

    public static void main(String[] args) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(null);
//        System.out.println(queue.size());

//        Deque<Integer> stack = new ArrayDeque<>();

        String str = "adfad\\n";

        for (char c : str.toCharArray()) {
            System.out.println(c);
        }
        System.out.println(str);

        System.out.println(str.contains("\\n"));

        String news = str.replace("\\n","\r\n");
        System.out.println(news);
        System.out.println(news);

    }
}
