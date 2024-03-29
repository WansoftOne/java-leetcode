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

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
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
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value)  {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node next = temp.next;
        Node before = null;

        for (int i=0; i < length; i++) {
            next = temp.next;
            temp.next = before;
            before = temp;
            temp = next;
        }
    }

    public void merge(LinkedList otherList) {
        Node n1;
        Node n2;
        if (head.value > otherList.head.value) {
            n1 = head;
            n2 = otherList.head.next;
            head = otherList.head;
        }else {
            n1 = head.next;
            n2 = otherList.head;
        }
        Node temp = head;
        while (n1 != null && n2 != null) {
            if (n1.value < n2.value) {
                temp.next = n1;
                temp = n1;
                n1 = n1.next;
            } else {
                temp.next = n2;
                temp = n2;
                n2 = n2.next;
            }
        }
        
        if (n1 != null) {
            temp.next = n1;
        }
        if (n2 != null) {
            temp.next = n2;
        }
        
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList(1);
        l1.append(3);
        l1.append(5);
 
        LinkedList l2 = new LinkedList(2);
        l2.append(4);
        l2.append(6);

        l1.merge(l2);

        l1.printList();
        l2.printList();
    }

}
