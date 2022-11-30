package example.LeetCode;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Map<Integer, ListNode> listNodeMap;
    ListNode head;
    ListNode tail;
    int sum;

    int current;
    class ListNode {

        int k;
        int value;
        ListNode next;
        ListNode pre;

        public ListNode(int k, int value) {
            this.k = k;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }

    public LRUCache(int capacity) {
        listNodeMap = new HashMap<>(capacity);
        head = null;
        tail = null;
        sum = capacity;
        current = 0;
    }

    public int get(int key) {
        if (listNodeMap.containsKey(key)) {
            ListNode tempNode = listNodeMap.get(key);
            ListNode preNode = tempNode.pre;
            ListNode nextNode = tempNode.next;
            if (preNode == null && nextNode != null) {
                nextNode.pre = null;
                tail.next = tempNode;
                tempNode.pre = tail;
                tempNode.next = null;
                head = nextNode;
                tail = tempNode;
            }else if (preNode != null && nextNode != null) {
                preNode.next = nextNode;
                nextNode.pre = preNode;
                tail.next = tempNode;
                tempNode.pre = tail;
                tempNode.next = null;
                tail = tempNode;
            }
            System.out.println(tempNode.value);
            return tempNode.value;
        }
        System.out.println(-1);
        return -1;
    }

    public void put(int key, int value) {
        if (listNodeMap.containsKey(key)) {
            get(key);
            ListNode tempNode = listNodeMap.get(key);
            tempNode.value = value;
            return;
        }
        if (current >= sum) {
            ListNode nextNode = head.next;
            listNodeMap.remove(head.k);
            if (nextNode == null) {
                ListNode node = new ListNode(key, value);
                head = node;
                tail = node;
                listNodeMap.put(key, node);
            }else {
                head.next = null;
                nextNode.pre = null;
                ListNode node = new ListNode(key, value);
                tail.next = node;
                node.pre = tail;
                head = nextNode;
                tail = node;
                listNodeMap.put(key, node);
            }
        }else {
            if (head == null) {
                ListNode node = new ListNode(key, value);
                head = node;
                tail = node;
                listNodeMap.put(key, node);
            } else {
                ListNode node = new ListNode(key, value);
                tail.next = node;
                node.pre = tail;
                tail = node;
                listNodeMap.put(key, node);
            }
            current++;
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4

    }
}
