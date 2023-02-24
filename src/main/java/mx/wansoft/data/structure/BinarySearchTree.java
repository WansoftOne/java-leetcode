package mx.wansoft.data.structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public List<Integer> BFS() {
        Queue<Node> queue = new LinkedList<>();
        List<Integer> results = new ArrayList<>();
        Node currentNode = root;
        queue.add(currentNode);
        while (queue.size() > 0) {
            currentNode = queue.remove();
            results.add(currentNode.value);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            } 
        }
        return results;
    }

    public void preOrdeTraverse(List<Integer> results, Node currentNode) {
        results.add(currentNode.value);
        if (currentNode.left != null) {
            preOrdeTraverse(results, currentNode.left);
        }
        if (currentNode.right != null) {
            preOrdeTraverse(results, currentNode.right);
        }
    }

    public List<Integer> DFSPreOrder() {
        List<Integer> result = new ArrayList<>();
        preOrdeTraverse(result, root);;
        return result;
    }

    public void postOrderTraverse(List<Integer> results, Node currentNode) {
        if (currentNode.left != null) {
            postOrderTraverse(results, currentNode.left);
        }
        if (currentNode.right != null) {
            postOrderTraverse(results, currentNode.right);
        }
        results.add(currentNode.value);
    }

    public List<Integer> DFSPostOrder() {
        List<Integer> results = new ArrayList<>();
        postOrderTraverse(results, root);
        return results;
    }

    public void inOrderTraverse(List<Integer> results, Node currentNode) {
        if (currentNode.left != null) {
            inOrderTraverse(results, currentNode.left);
        }
        results.add(currentNode.value);
        if (currentNode.right != null) {
            inOrderTraverse(results, currentNode.right);
        }
    }
        
    public List<Integer> DFSInOrder() {
        List<Integer> results = new ArrayList<>();
        inOrderTraverse(results, root);
        return results;
    }

    public static void main(String[] args) {
        BinarySearchTree binaryTree = new BinarySearchTree();
        binaryTree.insert(47);
        binaryTree.insert(21);
        binaryTree.insert(76);
        binaryTree.insert(18);
        binaryTree.insert(27);
        binaryTree.insert(52);
        binaryTree.insert(82);

        System.out.println(binaryTree.DFSInOrder());
    }
}
