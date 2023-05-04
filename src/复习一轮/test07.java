package 复习一轮;

import util.TreeNode;

import java.util.*;

public class test07 {
    public static void main(String[] args) {
        permuteUnique(new int[]{1, 1, 2});
    }

    //46
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> path = new ArrayList();
        int[] used = new int[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        dfspermute(nums, used, path, res);
        return res;
    }

    private void dfspermute(int[] nums, int[] used, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) continue;
            path.add(nums[i]);
            used[i] = 1;
            dfspermute(nums, used, path, res);
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }

    //47
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfspermuteUnique(nums, new int[nums.length], new ArrayList<>(), res);
        return res;
    }

    private static void dfspermuteUnique(int[] nums, int[] used, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) continue;
            if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == 0) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            dfspermuteUnique(nums, used, path, res);
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }

    //77
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] used = new int[n + 1];
        List<Integer> path = new ArrayList<>();
        dfscombine(n, 1, k, path, res);

        return res;
    }

    private void dfscombine(int n, int start, int k, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (i < start) {
                continue;
            }
            path.add(i);
//            used[i] = 1;
            dfscombine(n, i + 1, k, path, res);
//            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }

    //78
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfssubsets(nums, 1, path, res);
        return res;
    }

    private void dfssubsets(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfssubsets(nums, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    //22
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        List<Character> path = new ArrayList<>();

        dfsgenerateParenthesis(n, 0, 0, path, res);
        return res;
    }

    private void dfsgenerateParenthesis(int n, int left, int right, List<Character> path, List<String> res) {

        if (path.size() == 2 * n) {
            StringBuffer sb = new StringBuffer();
            for (Character character : path) {
                sb.append(character);
            }
            res.add(sb.toString());
        }

        if (left < n) {
            path.add('(');
            dfsgenerateParenthesis(n, left + 1, right, path, res);
            path.remove(path.size() - 1);
        }

        if (left > right) {
            path.add(')');
            dfsgenerateParenthesis(n, left, right + 1, path, res);
            path.remove(path.size() - 1);
        }

    }

    //226
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    //98 todo 再写一遍
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode max, TreeNode min) {
        if (root == null) return true;
        if (max != null && root.val >= max.val) return false;
        if (min != null && root.val <= min.val) return false;

        return isValidBST(root.left, root, min) && isValidBST(root.right, max, root);
    }

    //104
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int i = maxDepth(root.left);
        int i1 = maxDepth(root.right);
        return Math.max(i, i1) + 1;
    }

    //111
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        int i = minDepth(root.left);
        int i1 = minDepth(root.right);

        return Math.min(i, i1) + 1;
    }

    //297
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#,";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + right;
    }

    //297
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> strings1 = Arrays.asList(data.split(","));
        List<String> strings = new ArrayList<>(Arrays.asList(data.split(",")));

        TreeNode root = builderTree(strings1);
        return root;
    }

    private TreeNode builderTree(List<String> strings) {
        String remove = strings.remove(0);
        if (remove.equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(remove));
        root.left = builderTree(strings);
        root.right = builderTree(strings);
        return root;
    }

    //105
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    private TreeNode buildTree(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if (pstart > pend || istart > iend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pstart]);

        int index = 0;
        while (preorder[pstart] != inorder[index]) index++;
        root.left = buildTree(preorder, pstart + 1, pstart + index - istart, inorder, istart, index - 1);
        root.right = buildTree(preorder, pstart + index - istart + 1, pend, inorder, index + 1, iend);
        return root;
    }


    //236
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null && right == null) {
            return left;
        }
        if (left == null && right != null) {
            return right;
        }
        return null;
    }


    //236
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();

        dfslowestCommonAncestor(root, parent);

        while (p != null) {
            visited.add(p);
            p = parent.get(p);
        }
        while (q != null) {
            if(visited.contains(q)){
                return q;

            }
            q = parent.get(q);
        }
        return null;
    }

    private void dfslowestCommonAncestor(TreeNode root, Map<TreeNode, TreeNode> parent) {
        if (root == null) return;
        if (root.left != null) {
            parent.put(root.left, root);
        }
        if (root.right != null) {
            parent.put(root.right, root);
        }

        dfslowestCommonAncestor(root.left, parent);
        dfslowestCommonAncestor(root.right, parent);

    }


}
