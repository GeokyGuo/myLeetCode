package secondRound.Week7.第17课_布隆过滤器和LRU缓存;

import java.util.HashMap;
import java.util.Map;

class L146_LRU_Cache {
    public static void main(String[] args) {
        L146_LRU_Cache cache = new L146_LRU_Cache(0);
        cache.put(0, 0);
//        cache.put(2, 2);
        int a = cache.get(0);       // 返回 1
        System.out.println("0" + a);

//        cache.put(3, 3);    // 去除 key 2
//        a = cache.get(2);       // 返回 -1 (未找到key 2)
//        System.out.println("-1"+a);
//        a = cache.get(3);       // 返回 3
//        System.out.println("3"+a);


    }

    class Node {
        Node pre;
        Node next;
        int key;
        int val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            pre = this;
            next = this;
        }
    }

    Map<Integer, Node> map;
    Node head;
    int capacity;

    public L146_LRU_Cache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            del(node);
            refresh(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            del(node);
            refresh(node);
        } else {
            Node node = new Node(key, value);
            refresh(node);
            map.put(key, node);
            if (map.size() > capacity) {
                node = head.pre;
                del(node);
                map.remove(node.key);
            }
        }
    }

    private void del(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    private void refresh(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

//https://www.bilibili.com/video/BV1mE411S7kp?t=2
//理解两点，第一为啥要用双向链表，在摘除当前node的时候方便查找前序节点，
//            第二为node节点要同时包含 key 和val， 因为map中删除key时，这个key的值来源与node