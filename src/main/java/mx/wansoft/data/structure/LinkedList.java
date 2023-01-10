package mx.wansoft.data.structure;

/**
 * Append: O(1)
 * Remove Last: O(n)
 * Prepend: O(1)
 * Remove First: O(1)
 * Insert: O(n)
 * Remove: O(n)
 * Lookup by index O(n)
 * Lookup by value O(n)
 */
public class LinkedList {
    public static void main(String[] args) {
        LinkedList myLinkedList =  new LinkedList(4);
        myLinkedList.append(1);
        myLinkedList.append(80);
        myLinkedList.printList();
        myLinkedList.removeLast();
        myLinkedList.printList();
        myLinkedList.removeLast();
        myLinkedList.printList();
        myLinkedList.removeLast();
        myLinkedList.printList();
    }


    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int value) {
        Node node = new Node(value);
        if (length == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        length++;
    }

    public void printList() {
        Node temp = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(temp != null) {
            sb.append(temp.value);
            temp = temp.next;
            if (temp != null) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public Node removeLast() {
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;
        while(temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        pre.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public Node getHead() {
        System.out.println("Head: " + head.value);
        return head;
    }

    public Node getTail() {
        System.out.println("Tail: " + tail.value);
        return tail;
    }

    public int getLength() {
        System.out.println("Length: " + length);
        return length;
    }
}
