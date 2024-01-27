package org.example.concept;

public class Traversal {
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public void preOrder(Node node) {
        if(node != null) {
            System.out.print(node.data + " ");
            if(node.left != null) preOrder(node.left);
            if(node.right != null) preOrder(node.right);
        }
    }

    //중위 순회 Inorder : Left -> Root -> Right
    public void inOrder(Node node) {
        if(node != null) {
            if(node.left != null) inOrder(node.left);
            System.out.print(node.data + " ");
            if(node.right != null) inOrder(node.right);
        }
    }

    //후위순회 Postorder : Left -> Right -> Root
    public void postOrder(Node node) {
        if(node != null) {
            if(node.left != null) postOrder(node.left);
            if(node.right != null) postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
}
