package example.LeetCode;

public class Node {

    Node next;

    int data;

    public Node(int data){
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node nextNode) {
        this.data = data;
        this.next = nextNode;
    }

}
