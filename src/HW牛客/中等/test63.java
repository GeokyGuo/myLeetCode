package HW牛客.中等;

import java.util.*;

public class test63 {
    public static void main(String[] args) {

    }

    public static void test01(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
//            in.nextInt();
            int length = in.nextInt();
            String res = subStr(s, length);
            System.out.println(res);
        }
    }

    private static String subStr(String s, int length) {
        //ACGT
        //index，ratio
        HashMap<Integer, Double> map = new HashMap<>();
        Deque<Character> queue = new ArrayDeque<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < length; i++) {
            queue.offer(chars[i]);
        }
        Double rate = getRatio(queue);
        map.put(length - 1, rate);

        for (int i = length; i < chars.length; i++) {
            queue.offer(chars[i]);
            queue.poll();
            map.put(i, getRatio(queue));
        }

        List<Map.Entry<Integer, Double>> mapList = new ArrayList<>(map.entrySet());
        mapList.sort((e1,e2)-> {
            int i = e2.getValue().compareTo(e1.getValue());
            if(i!=0) return i;
            return e1.getKey() - e2.getKey();
        });

        Integer lastIndex = mapList.get(0).getKey();
        int start = lastIndex - length + 1;
        StringBuffer sb = new StringBuffer();
        for (int i = start; i <= lastIndex ; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    private static Double getRatio(Deque<Character> queue) {
        int count = 0;
        for (Character character : queue) {
            if(character=='C'||character == 'G'){
                count++;
            }
        }
        return count + 1.0 / queue.size();
    }


}
