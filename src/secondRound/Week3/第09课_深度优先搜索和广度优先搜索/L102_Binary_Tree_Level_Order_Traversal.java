package secondRound.Week3.第09课_深度优先搜索和广度优先搜索;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/////////////Bfs
public class L102_Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if(root == null) return resList;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);


        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode temp =  queue.pollFirst();
                list.add(temp.val);
                if(temp.left != null) queue.offerLast(temp.left);
                if(temp.right != null) queue.offerLast(temp.right);
            }
            resList.add(list);
        }
        return resList;
    }


    /////////////dfs
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if(root == null) return resList;
        dfs(resList, root, 0);
        return resList;

    }

    void dfs(List<List<Integer>> resList, TreeNode root, int level){
        if(root == null) return;
        if(resList.size() - 1< level) resList.add(new ArrayList<Integer>());
        resList.get(level).add(root.val);
        dfs(resList, root.left, level + 1);
        dfs(resList, root.right, level + 1);

    }


}
