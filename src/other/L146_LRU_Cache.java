package other;

import java.util.HashMap;

class L146_LRU_Cache {
    public static void main(String[] args) {
        L146_LRU_Cache cache = new L146_LRU_Cache(0);
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
    class Node{
        Node pre;
        Node next;
        int key;
        int val;
        Node(int k, int v){
            key = k;
            val = v;
        }
    }

    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    public L146_LRU_Cache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            del(node);
            refresh(node);
            return node.val;

        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }//防止 还没有生成任何一个链表的时候，就因为容量不够要删除导致的空指针  59行
        if(map.containsKey(key)){
            Node node = map.get(key);
            del(node);
            node.val = value;
            refresh(node);
        }else{
            if(map.size() == capacity){
                map.remove(tail.pre.key);
                del(tail.pre);
            }
            Node node = new Node(key, value);
            map.put(key,node);
            refresh(node);
        }
    }

    private void refresh(Node node){
//        node.next.pre = node.pre;
//        node.pre.next = node.next;

        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }
    private void del(Node node){
        // tail.pre.pre.next = tail;
        // tail.pre = tail.pre.pre;


//        Node node = tail.pre;
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */