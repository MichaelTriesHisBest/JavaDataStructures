
package edu.belmont.csc.src.search;

public class BinaryTree {
    public static class Node{
         int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    /**
     * Given two trees, check to see if they are identical (nodes with identical values and are positioned
     * the same)
     * @param n1 - the first tree
     * @param n2 - the second tree
     * @return true if identical and false otherwise
     */
    public static boolean isIdentical(Node n1, Node n2) {

        if (n1 == null && n2 == null)
            return true;


        if (n1 != null && n2 != null)
            return (n1.data == n2.data
                    && isIdentical(n1.left, n2.left)
                    && isIdentical(n1.right, n2.right));


        return false;
    }

    /**
     * Get the height of a given tree
     * @param root - root of the tree
     * @return height of the tree (note that a tree with only one node is considered of height 0)
     */
    public static int height(Node root) {
        {
            if (root == null)
                return 0;
            else
            {

                int leftDepth =height(root.left);
                int rightDepth = height(root.right);


                if (leftDepth > rightDepth)
                    return (leftDepth + 1);
                else
                    return (rightDepth + 1);
            }
        }
    }


    /**
     * Check if given binary tree is a height balanced tree, i.e., |balance factor| <= 1
     * @param root - root of tree
     * @return true if height balanced and false otherwise
     */
    public static boolean isHeightBalanced(Node root)
    {
        int leftHeight;

        int rightHeight;


        if (root == null)
            return true;


        leftHeight = height(root.left);
        rightHeight = height(root.right);

        return Math.abs(leftHeight - rightHeight) <= 1
                && isHeightBalanced(root.left)
                && isHeightBalanced(root.right);

    }

    // driver function
    public static void main(String[] args) {
        // construct first tree
        Node x = new Node(15);
        x.left = new Node(10);
        x.right = new Node(20);
        x.left.left = new Node(8);
        x.left.right = new Node(12);
        x.right.left = new Node(16);
        x.right.right = new Node(25);

        // construct second tree
        Node y = new Node(15);
        y.left = new Node(10);
        y.right = new Node(20);
        y.left.left = new Node(8);
        y.left.right = new Node(12);
        y.right.left = new Node(16);
        y.right.right = new Node(25);

        if (isIdentical(x, y)) {
            System.out.print("Given binary Trees are identical");
        } else {
            System.out.print("Given binary Trees are not identical");
        }


        System.out.print("The height of the second binary tree is " + height(y));

        if (isHeightBalanced(x)) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }

    }
}