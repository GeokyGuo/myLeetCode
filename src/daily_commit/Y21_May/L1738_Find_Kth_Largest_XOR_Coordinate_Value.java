package daily_commit.Y21_May;

import java.util.PriorityQueue;

public class L1738_Find_Kth_Largest_XOR_Coordinate_Value {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> a - b);
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i < sum.length; i++) {
            for (int j = 1; j < sum[0].length; j++ ) {
                sum[i][j] = sum[i - 1][j] ^ sum[i][j - 1] ^ sum[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                if (queue.size() < k) {
                    queue.offer(sum[i][j]);
                }else {
                    if (sum[i][j] > queue.peek()) {
                        queue.poll();
                        queue.offer(sum[i][j]);
                    }
                }
            }
        }
        return queue.peek();
    }
}

//学到的第一点， 一维的异或前缀数组，  二维的异或前缀矩阵，可以由三点叠加
//学到的第二点， priorityQueue 就是直接就是堆排序的容器， 构造的时候comparator 入参 顺序是 a  b， 如果返回 a-b 就是升序，  如果返回b-a就是降序
//学到的第三点，  当要求 第K大的元素是， 构建 K个元素的小堆顶， 那么顶下的都是最大的那几个， 当要求第K小时， 构建大堆顶， 堆下的都是最小的那几个