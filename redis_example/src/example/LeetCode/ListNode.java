package example.LeetCode;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(){};

    public ListNode(int data) {

        this.val = data;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void addListNode(int... dataList) {
        ListNode temp = this;
        for (int data : dataList) {
            temp.next = new ListNode(data);
            temp = temp.next;
        }
    }
}
