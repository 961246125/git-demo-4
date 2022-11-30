package example.LeetCode;

import java.util.PriorityQueue;

/**
 * k个升序链表排序
 * 方法：优先队列PriorityQueue, 重载比较器(o1, o2) -> o1.val - o2.val
 */
public class MergeKList {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for(ListNode listNode : lists) {
            if (listNode != null) {
                queue.offer(listNode);
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            tail.next = temp;
            tail = temp;
            if (temp.next != null) {
                queue.offer(temp.next);
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        MergeKList mergeKList = new MergeKList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        node1.addListNode(10,13,15);
        node2.addListNode(3,5,9);
        node3.addListNode(6,6,6);
        ListNode[] lists = new ListNode[4];
        lists[0] = node1;
        lists[1] = node2;
        lists[2] = node3;
        ListNode result = mergeKList.mergeKLists(lists);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
