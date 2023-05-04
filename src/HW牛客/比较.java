package HW牛客;

import java.util.*;

public class 比较 {
    //compareTo 是所有某个比较对象自身的方法，实现了 comparable接口，具有了比较的能力
    //comparetor是比较器，可以比较任意的对象，只要返回合适的0，1，-1值
    //自定义的比较器中可能要使用到对象的compareTo方法，例如test1

    //自定义比较器的中  升序降序的书写方式
    //(e1,e2)->e1-e2  这个是升序
    //(e1,e2)->e2-e1  这个是降序
    //(e1,e2)->{if(e1-e2 == 0) return 0 else {e1-e2 > 0 ? 1:-1}}  这个是升序

    //compareTo可以理解为“减号”
    //(e1,e2)->e2.compareTo(e1)  这个是降序


    public static void main(String[] args) {
//        test1(args);
//        test2(args);
        test3(args);

    }

    //对一维数组或二维数组排序， 使用Arrays.sort()，会改变数组本身
    public static void test1(String[] args) {
        Integer[] minNum = new Integer[]{5, 2, 9, 2, 3, 7, 9, 1};
//        Arrays.sort(minNum, (e1, e2) -> e2 - e1);
        Arrays.sort(minNum, (e1, e2) -> e2.compareTo(e1));

        System.out.println(Arrays.toString(minNum));

    }

    public static void test2(String[] args) {

        int[][] arr = {{2, 5}, {1, 4}, {2, 9}};

        Arrays.sort(arr, new Comparator<int[]>() {    // 匿名内部类
            @Override
            public int compare(int[] e1, int[] e2) {
                // 如果第一列元素相等，则比较第二列元素
                if (e1[0] == e2[0]) return e1[1] - e2[1];   // e1[1]-e2[1]表示对于第二列元素进行升序排序
                return e1[0] - e2[0];                     // e1[0]-e2[0]表示对于第一列元素进行升序排序
            }
        });
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    //对ArrayList 排序  Collections.sort(),list.sort()会改变list本身    Collections.reverse()
    public static void test3(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(9);
        list.add(32);
        list.add(1);
//        Collections.sort(list, Comparator.naturalOrder());
        list.sort((e1, e2) -> {
            if (e1 - e2 > 0) return -1;
            else if (e1 - e2 == 0) {
                return 0;
            } else {
                return 1;
            }
        });
        System.out.println(list);
    }

    //对map排序，第一步把map转换成entrylist 或者entryset
//    List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
    public static void test4(String[] arg) {
        HashMap<String, String> map = new HashMap<>();
    }
//    对value降序
//    public int compare(Map.Entry<Integer,Integer>e1,Map.Entry<Integer,Integer>e2){
//        return e2.getValue().compareTo(e1.getValue());
//    }
//    对值value升序排序
//    public int compare(Map.Entry<Integer,Integer>e1,Map.Entry<Integer,Integer>e2){
//        return e1.getValue().compareTo(e2.getValue());
//    }
//    对键KEY降序排列
//    public int compare(Map.Entry<Integer,Integer>e1,Map.Entry<Integer,Integer>e2){
//        return e2.getKey().compareTo(e1.getKey());
//    }
//    对键KEY升序排列
//    public int compare(Map.Entry<Integer,Integer>e1,Map.Entry<Integer,Integer>e2){
//        return e1.getKey().compareTo(e2.getKey());
//    }
//    优先按值value降序、其次按键key升序排序
//    public int compare(Map.Entry<String,Integer>e1,Map.Entry<String,Integer>e2){
//        int re = e2.getValue().compareTo(e1.getValue());
//        if(re!=0){return re;}
//        else{return e1.getKey().compareTo(e2.getKey());}
//    }
}
