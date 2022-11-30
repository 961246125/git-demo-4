package example.LeetCode;

public class MyLink {

    Node head = null;

    public void addData(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        }else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void addNode(Node node) {
        if (head == null) {
            head = node;
        }
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public int getLength() {
        if (head == null) {
            return 0;
        }
        Node temp = head;
        int count = 1;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        MyLink myLink = new MyLink();
        Node node1 = new Node(3);
        Node node2 = new Node(1);
        Node node3 = new Node(0);
        Node node4 = new Node(-4);
        myLink.addNode(node1);
        myLink.addNode(node2);
        myLink.addNode(node3);
        myLink.addNode(node4);
        myLink.addNode(node2);
        System.out.println(myLink.getLength());
        int data = myLink.head.data;
    }
}
