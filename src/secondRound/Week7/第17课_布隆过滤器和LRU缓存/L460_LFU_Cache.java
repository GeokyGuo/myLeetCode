package secondRound.Week7.第17课_布隆过滤器和LRU缓存;

import java.util.HashMap;
import java.util.LinkedList;


class L460_LFU_Cache {
    public static void main(String[] args) {
        L460_LFU_Cache cache = new L460_LFU_Cache(0);
        cache.put(0, 0);
//        cache.put(2, 2);
        int a = cache.get(0);       // 返回 1
        System.out.println("0"+a);

//        cache.put(3, 3);    // 去除 key 2
//        a = cache.get(2);       // 返回 -1 (未找到key 2)
//        System.out.println("-1"+a);
//        a = cache.get(3);       // 返回 3
//        System.out.println("3"+a);


    }
    HashMap<Integer, Node> keyTable = new HashMap<>();
    HashMap<Integer, LinkedList<Node>> freqTable = new HashMap<>();
    int capacity;
    int minFreq = 0;

    public L460_LFU_Cache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (keyTable.containsKey(key)) {
            Node temp = keyTable.get(key);
            delOldNode(temp);

            temp.freq += 1;
            addNewNode(temp);
            return temp.val;
        } else {
            return -1;
        }
    }


    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }//防止 还没有生成任何一个链表的时候，就因为容量不够要删除导致的空指针  59行
        if (keyTable.containsKey(key)) {
            Node temp = keyTable.get(key);
            delOldNode(temp);

            temp.val = value;
            temp.freq += 1;
            addNewNode(temp);
        } else {
            if (keyTable.size() == capacity) {
                Node node = freqTable.get(minFreq).peekLast();
                keyTable.remove(node.key);//完全删除  容易忘
                delOldNode(node);
            }
            Node temp = new Node(key, value, 1);
            keyTable.put(key, temp);
            addNewNode(temp);//完全添加 容易忘
            minFreq = 1;
        }
    }

    private void addNewNode(Node node) {
        LinkedList<Node> list = freqTable.getOrDefault(node.freq, new LinkedList<Node>());
        list.offerFirst(node);
        freqTable.put(node.freq, list);//容易忘
    }

    private void delOldNode(Node node) {
        int freq = node.freq;
        freqTable.get(freq).remove(node);
        if (freqTable.get(freq).size() == 0) {
            freqTable.remove(freq);
            if (minFreq == freq) {
                minFreq += 1;
            }
        }
    }

    class Node {
        int key;
        int val;
        int freq;

        Node(int k, int v, int f) {
            key = k;
            val = v;
            freq = f;
        }
    }

}

/**
 * Your L460_LFU_Cache object will be instantiated and called as such:
 * L460_LFU_Cache obj = new L460_LFU_Cache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */