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
public class LinkedList<E> {
    public static void main(String[] args) {
        LinkedList<Integer> myLinkedList =  new LinkedList<Integer>(4, 5, 3);
        System.out.println("At the index 1 we have: " + myLinkedList.get(1));
        myLinkedList.printList();
    }

    private Node<E> head;
    private Node<E> tail;
    private int length;

    class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    public LinkedList(E ...values) {
        for (E value : values) {
            append(value);
        }
    }

    public void append(E value) {
        Node<E> node = new Node<E>(value);
        if (length == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        length++;
    }

    public E get(int index) {
        Node<E> node = getNode(index);
        return node.value;
    }

    public Node<E> getNode(int index) {
        if (index < 0 || index >= length || length == 0) {
            return null;
        }
        Node<E> temp = head;
        for (int i=0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean insert(int index, E value) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
        } else if (index == length) {
            append(value);
        } else {
            Node<E> temp = getNode(index - 1);
            Node<E> newNode = new Node<E>(value);
            newNode.next = temp.next;
            temp.next = newNode;
            length++;
        }

        return true;
    }
 
    public void prepend(E value) {
        Node<E> newNode = new Node<E>(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public void printList() {
        Node<E> temp = head;
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

    public E removeFirst() {
        if (length == 0) return null;
        Node<E> temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0 ) {
            tail = null;
        }
        return temp != null ? temp.value : null;
    }

    public E removeLast() {
        if (length == 0) return null;
        Node<E> temp = head;
        Node<E> pre = head;
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

        return temp != null ? temp.value : null;
    }

    public boolean set(int index, E value) {
        Node<E> node = getNode(index);
        if (node != null) {
            node.value = value;
            return true;
        }
        return false;
    }

    public E getHead() {
        return head != null ? head.value : null;
    }

    public E getTail() {
        return tail != null ? tail.value : null;
    }

    public int getLength() {
        return length;
    }
}
