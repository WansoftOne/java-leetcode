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

    public Node get(int index) {
        if (index < 0 || index > length) return null;
        Node temp = head;
        if (index < length / 2) {
            for (int i=0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i=length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        } else if (index == length) {
            append(value);
            return true;
        } 
        Node newNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.next;
        newNode.next = after;
        newNode.prev = before;
        before.next = newNode;
        after.prev = newNode;
        length++;
        return true;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node remove(int index) {
        if (index < 0 || index > length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node temp = get(index);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
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

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp == null) return false;
        
        temp.value = value;
        return true;
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
        DoblyLinkedList dll = new DoblyLinkedList(2,0,10, 15, 1, -5);
        System.out.println(dll.get(4).value);
        System.out.println(dll.get(1).value);
    }
}
