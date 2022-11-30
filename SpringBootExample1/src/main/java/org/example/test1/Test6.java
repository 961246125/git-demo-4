package org.example.test1;

import java.util.List;

public class Test6 {

    class ListNode{
        int val;
        ListNode next;
        public ListNode(){}
        public ListNode(int val) {this.val = val;}
    }

    public int loopLength(ListNode root) {
        if (root == null) {
            return 0;
        }
        ListNode fast = root.next;
        ListNode slow = root;
        while(fast != null && fast.next != null) {
            if (slow == fast) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        int count = 0;
        if (slow == fast) {
            ListNode temp = slow;
            while(temp.next != slow) {
                count++;
                temp = temp.next;
            }
            count++;
        }
        return count;
    }
}
