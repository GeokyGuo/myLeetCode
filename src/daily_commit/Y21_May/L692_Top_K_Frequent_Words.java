package daily_commit.Y21_May;

import java.util.*;

public class L692_Top_K_Frequent_Words {
    public List<String> topKFrequent(String[] words, int k) {
        // 统计词频
        //在元素个数为K的 小根堆中排序， 排序规则是  词频越大越在底部， 词频相同，字母排序小的在底部
        //输出小根堆，逆序
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) map.put(str, map.getOrDefault(str, 0) + 1);

        PriorityQueue<Object[]> q = new PriorityQueue<>(k, (a, b) -> {
            int aCout = (int)a[0]; int bCount = (int)b[0];
            if(aCout != bCount) return aCout - bCount;
            else{
                String aStr = (String)a[1]; String bStr = (String)b[1];
                return bStr.compareTo(aStr);
            }
        });

        for (String str : map.keySet()) {
            int count = map.get(str);
            if (q.size() < k) q.offer(new Object[]{count, str});
            else {
                if (count > (int)q.peek()[0]) {
                    q.poll();
                    q.offer(new Object[]{count, str});
                }else if(count == (int)q.peek()[0]) {
                    if (str.compareTo((String)q.peek()[1]) < 0) {
                        q.poll();
                        q.offer(new Object[]{count, str});
                    }
                }
            }
        }
        List<String> list = new LinkedList<>();
        while(!q.isEmpty()) list.add((String)q.poll()[1]);
        Collections.reverse(list);
        return list;
    }
}

//很大的问题，就是还是没搞懂 comparable 和comparaTo 怎么使用