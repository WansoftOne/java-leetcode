package mx.wansoft.data.structure;

public class Queue {
    private Node first;
    private Node last;
    private int length;

    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }
    
    public Queue(int ...values) {
        for (int v : values) {
            enqueue(v);
        }
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue() {
        if (length == 0 ) return null;
        Node temp = first;
        if (length == 1) {
            first = null;
            last = null;
        } else {
           first = first.next;
           temp.next = null; 
        }
        length--;
        return temp; 
    }

    public void print() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = first;
        while(temp != null) {
            sb.append(temp.value);
            temp = temp.next;
            if (temp != null) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Queue q = new Queue(5,6);
        System.out.println(q.dequeue().value);
        System.out.println(q.dequeue().value);
        System.out.println(q.dequeue());
    }
}
