package HW牛客.中等;

import java.util.*;

public class test41 {//超时 未ac

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] weight = new int[n];
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            weight[i] = in.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            nums[i] = x;
            sum += x;
        }
        int[] all = new int[sum];

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 0; j < num; j++) {
                all[k++] = weight[i];
            }
        }

        Arrays.sort(all);


        dfs(all, new boolean[all.length], new ArrayList<>());
        System.out.println(res1.size());
        res1.forEach(e -> System.out.println(e + " "));


        //本来想用动态规划，但是发现自己的动态规划思路是错的 todo，随意选某几个，不能使用 i开始，j结尾只能表示i到j中间的连续，不能选到 i和j这两个的组合
//        other(all);
//        int temp = all[all.length - 1];
//        for (int i = all.length - 2; i >= 0; i--) {
//            all[i + 1] = all[i];
//        }
//        all[0] = temp;
//
//        other(all);
//        System.out.println(res2.size() + 1);
//        res2.forEach(e -> System.out.println(e + " "));

    }

    static Set<Integer> res1 = new TreeSet<>();
    static Set<Integer> res2 = new TreeSet<>();

    static void dfs(int[] all, boolean[] visited, List<Integer> path) {
        int sum = 0;
        for (Integer integer : path) {
            sum += integer;
        }
        res1.add(sum);

        for (int i = 0; i < all.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && all[i] == all[i - 1] && !visited[i - 1]) {
                continue;
            }
            path.add(all[i]);
            visited[i] = true;
            dfs(all, visited, path);
            visited[i] = false;
            path.remove(path.size() - 1);
        }

    }

//
//    //dp[i][j] 为 以 i开始，j结束的序列和
//    //dp[i][j] = dp[i][j-1] +arr[j]
//    static void other(int[] all) {
//
//        int[][] dp = new int[all.length][all.length];
//        for (int i = 0; i < all.length; i++) {
//            dp[i][i] = all[i];
//            res2.add(dp[i][i]);
//        }
//        for (int j = 1; j < all.length; j++) {
//            for (int i = 0; i < j; i++) {
//                dp[i][j] = dp[i][j - 1] + all[j];
//                res2.add(dp[i][j]);
//            }
//
//        }
//
//        for (int i = 0; i < all.length; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
//    }
}
