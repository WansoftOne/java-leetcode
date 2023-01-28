package mx.wansoft.data.structure;

public class Stack {
    private Node top;
    private int height;

    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }

    public Stack(int ...values) {
        for (int v : values) {
            push(v);
        }
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop() {
        if (height == 0) return null;
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }

    public void print() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = top;
        while(temp != null) {
            sb.append(temp.value);
            temp = temp.next;
            if (temp != null) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Stack myStack = new Stack(4, 10, 5);
        System.out.println(myStack.pop().value);
        System.out.println(myStack.pop().value);
        System.out.println(myStack.pop());
    }
}
