package edu.belmont.csc.src.search;

import Cedu.belmont.csc.src.queues.QueueClass;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;
    // TODO: Add the internal data according to the driver (main) method so that the compile errors are gone

    // END OF TODO

    // TODO: implement the following traversal methods

    public void preorder(Node root) {
        //if(node == null) return
        //print(node.value)
        //preorder(node.left)
        //preorder(node.right)
        if(root == null) return;
        System.out.print(root.data +  " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder(Node root) {
//            if(node == null) return
//            inorder(node.left);
//            print(node.value);
//            inorder(node.right);
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data +  " ");

        inorder(root.right);
    }


    public void postorder(Node root) {
//        if(node == null) return;
//        postorder(node.left);
//        postorder(node.right);
//        print(node.value)
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data +  " ");
    }

    public void levelorder(Node root) {

        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (true) {
            int nodeCount = queue.size();
            if (nodeCount == 0)
                //      return;
                break;

            while (nodeCount > 0) {
                Node node = queue.peek();
                System.out.print(node.data + " ");
                queue.remove();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                nodeCount--;
            }
            System.out.println();
        }

    }


    // END OF TODO

    // Driver method
    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.preorder(tree.root);

        System.out.println("\nInorder traversal of binary tree is ");
        tree.inorder(tree.root);

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.postorder(tree.root);

        System.out.println("\nLevelorder traversal of binary tree is ");
        tree.levelorder(tree.root);
    }
}