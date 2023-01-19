package mx.wansoft.data.structure;

import java.util.Objects;

public class DoblyLinkedList {
    
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;
        Node(int value) {
            this.value = value;
        }
    }

    public DoblyLinkedList(int ...values){
        for (int v : values) {
            append(v);
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) return null;
        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    public void getHead() {
        System.out.println("Head: " + head);
    }
    public void getTail() {
        System.out.println("Tail: " + tail);
    }
    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void print() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = head;
        while(temp != null) {
            sb.append(temp.value);
            temp = temp.next;
            if (temp != null) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        DoblyLinkedList dll = new DoblyLinkedList(1,2,3);
        System.out.println(dll.removeLast().value);
        System.out.println(dll.removeLast().value);
        System.out.println(dll.removeLast().value);
        System.out.println(dll.removeLast());
    }
}
