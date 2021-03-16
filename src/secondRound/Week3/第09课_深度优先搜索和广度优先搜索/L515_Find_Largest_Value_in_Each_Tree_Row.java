package secondRound.Week3.第09课_深度优先搜索和广度优先搜索;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L515_Find_Largest_Value_in_Each_Tree_Row {

    //可以优化，不一定出现level，另外可以尝试 dfs
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if(root == null) return resList;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        resList.add(root.val);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i < size; i++){
                TreeNode temp = queue.pollFirst();
                if(resList.size() - 1 < level) resList.add(temp.val);
                else{
                    resList.set(level, resList.get(level) > temp.val ? resList.get(level) : temp.val);
                }

                if(temp.left != null) queue.offerLast(temp.left);
                if(temp.right != null) queue.offerLast(temp.right);
            }
            level++;
        }
        ArrayList a = new ArrayList();
        return resList;
    }
}

//list
// 增加 add（对象） add（index,对象）
//删除 remove（对象） remove（index）
// 查询 contains(对象)
// 改 set（index，对象）怎么set数值，需要两个参数
