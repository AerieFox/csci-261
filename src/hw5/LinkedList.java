package hw5;
/*
public class LinkedList {
    Node head;
    int size;
    public LinkedList(int head) {
        this.head = new Node(head);
        this.size = 1;
    }
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(int data) {
        Node new_node = new Node(data);
        if (this.head == null) {
            this.head = new_node;
        }
        else {
            Node last = this.head;
            while (last.nextNode != null) {
                last = last.nextNode;
            }

            last.nextNode = new_node;
        }
        this.size += 1;
    }

    public int get(int index) {
        Node iterateNode = this.head;
        for(int i = 0; i < index; i++) {
            iterateNode = iterateNode.nextNode;
        }

        return iterateNode.data;
    }
    public int poll() {
        int val = this.head.data;
        this.head = this.head.nextNode;
        this.size--;

        return val;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int getSize() {
        return this.size;
    }
}
*/