package mx.wansoft.data.structure;

public class BinarySearchTree {
    Node root;
    
    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
        }
        Node temp = root;
        while(true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        Node temp = root;
        while(temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearchTree binaryTree = new BinarySearchTree();
        binaryTree.insert(47);
        binaryTree.insert(21);
        binaryTree.insert(76);
        binaryTree.insert(18);
        binaryTree.insert(52);
        binaryTree.insert(82);

        binaryTree.insert(27);
        System.out.println(binaryTree.contains(27));
        System.out.println(binaryTree.contains(80));
    }
}
