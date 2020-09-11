package edu.belmont.csc.src.search;


import edu.belmont.csc.src.trees.BTPrinter;

public class BinarySearchTree {
    public static class BSTNode {

        // TODO: Add the internal data members
        public BSTNode left;
        public BSTNode right;

        public int data;
        int height;
        int bf;



        public BSTNode(Integer data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.bf = 0;
            this.height = 0;

        }
        // END OF TODO
    }

    public BSTNode root;
    private int nodeCount = 1; // # of nodes in the tree
    //method to get height because I'm gonna be calling on this alot
    private int height(BSTNode Nodie) {
        return Nodie == null ? -1 : Nodie.height;
    }

    //method that'll return the greater value???

    public int size() {
        return nodeCount;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Return whether a value exists in the tree
     *
     * @param value
     * @return
     */
    public boolean contains(int value) {
        if (isEmpty()) return false;
        return contains(root, value);
    }

    /**
     * A recursive helper method to check if a value exists in the tree
     *
     * @param node  - current node
     * @param value - value to search for
     * @return true if found and false otherwise
     */

    private boolean contains(BSTNode node, int value) {
        // TODO: implement this method
        if (node == null) {
            return false;
        }
        if (value < node.data && node.left != null) {
            return contains(node.left, value);
        }
        if (value > node.data && node.right != null) {
            return contains(node.right, value);
        }
        if (value == node.data) {
            return true;
        }
        return false;
    }

    /**
     * Insert a value to the AVL tree. Duplicates are not allowed
     *
     * @param value - value to be added
     * @return true if insertion is successful and false otherwise
     */
    public boolean insert(int value) {
        if (!contains(root, value)) {
            root = insert(root, value);
            nodeCount++;
            return true;
        }
        return false;
    }

    /**
     * Recursive helper method to insert the given value to the tree while maintaining the BST invariant
     *
     * @param node  - root node of current subtree
     * @param value - value to be inserted
     * @return root node of current balanced subtree
     */
    private BSTNode insert(BSTNode node, int value) {
//        // TODO: implement this method
        if(node == null){
           return new BSTNode(value);
        }
        if (value < node.data) {
            node.left = insert(node.left, value);

        } else
            node.right = insert(node.right, value);


        update(node);
         return balance(node);
    }


    /**
     * Update a node's internal data when modified (hint: needed during insertion and removal)
     *
     * @param node - node to be updated
     */
    private void update(BSTNode node) {
        // TODO: implement this method
           int temp =  node.left == null ? -1 : node.left.height;
           int temp1 =  node.right == null ? -1 : node.right.height;
            node.height = 1 + Math.max(temp, temp1);
            node.bf = temp1 - temp;
    }

    /**
     * Print's out the tree by level order
     *
     * @param tree- root of the tree
     * @return aint returnin NOTHIN bruh
     */

    private static void printTree(BinarySearchTree tree) {
        BTPrinter printee = new BTPrinter(tree);
        printee.print(System.out);
    }

    /**
     * Performs left rotation on the specified node
     *
     * @param node - root of subtree
     * @return new root of subtree
     */
    private BSTNode leftRotate(BSTNode node) {
        // TODO: implement this method - make sure it calls the private remove helper method
        BSTNode rootRightChild = node.right;

            node.right = rootRightChild.left;
            rootRightChild.left = node;

            update(node);
            update(rootRightChild);

            return rootRightChild;

    }

    /**
     * Performs right rotation on the specified node
     *
     * @param node - root of subtree
     * @return new root of subtree
     */
    private BSTNode rightRotate(BSTNode node) {
        // TODO: implement this method - make sure it calls the private remove helper method
       // if(node.right != null && node.left != null) {
            BSTNode rootLeftChild = node.left;
            node.left = rootLeftChild.right;
            rootLeftChild.right = node;

            update(node);
            update(rootLeftChild);

            return rootLeftChild;

    }

    // Remove a value from this binary tree if it exists, O(log(n))
    /**
     * Removes the specified value from the tree
     *
     * @param element - element to be removed
     * @return true if successfully removed and false otherwise
     */
    public boolean remove(int element) {
        // TODO: implement this method - make sure it calls the private remove helper method
        if (contains(root, element)) {
            remove(root, element);
            nodeCount--;
            return true;
        }
        return false;
    }

    private int minValue(BSTNode noode) {
        int minv = noode.data;
        while (noode.left != null) {
            minv = noode.left.data;
            noode = noode.left;
        }
        return minv;
    }

   public BSTNode balance(BSTNode node) {
       //getBalance is just the bf u goof
   //     int balance = getBalance(node);
        if (node.bf > 1) {
            // r r case
            if(node.right.right.height >= node.right.left.height){
                leftRotate(node);
            }
            } else {
            //right left case
                node.right = rightRotate(node.right);
                node = leftRotate(node);
            }
            if (node.bf < -1) {
                // l l case
            if (node.left.left.height > node.left.right.height)
                node = rightRotate(node);
            else {
                //left right case
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }
        }
        return node;
    }
    /**
     * A recursive helper method to remove the element from the specified tree
     *
     * @param node    - root of current subtree
     * @param element - element to be removed
     * @return root of balanced subtree
     */
    private BSTNode remove(BSTNode node, int element) {
        if (node == null)
            return node;
         else if (node.data > element)
            node.left = remove(node.left, element);
         else if (node.data < element)
            node.right = remove(node.right, element);
         else {
            if (node.left == null || node.right == null) node = (node.left == null) ? node.right : node.left;
            else {
                BSTNode Leftest = new BSTNode(minValue(node.right));
                node.data = Leftest.data;
                node.right = remove(node.right, node.data);
            }
        }
        if (node != null)
            node = balance(node);

        return node;
    }


    /**
     * A recursive method to check if a given tree is a valid binary search tree
     *
     * @param node - root of tree
     * @return true if valid and false otherwise
     */
    public boolean isValid(BSTNode node) {
        if (node.right != null && node.left == null) {
            if (node.right.data > node.data) {
                isValid(node.right);
            } else return false;
        }
        if (node.right == null && node.left != null) {
            if (node.left.data < node.data) {
                isValid(node.left);
            } else return false;
        }
        if (node.right != null && node.left != null) {
            if (node.right.data > node.left.data) {
                isValid(node.right);
            } else return false;
        }
        return true;
    }

    // Driver method
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        System.out.println(tree.isEmpty());
        tree.root = new BSTNode(8);
        System.out.println(tree.size());
        tree.insert(5);
        tree.insert(11);
        tree.insert(2);
       tree.insert(3);
       // tree.insert(1);
      //  tree.insert(0);
        tree.insert(9);
        tree.insert(9);
        //tree.insert(-3);
       //  System.out.println(  tree.remove(2));
//        tree.remove(-3);
//        tree.remove(1);
//        tree.remove(0);
//        tree.remove(-4);
       // tree.insert(-3);
        System.out.println(tree.size());
        System.out.println("If this works, this should return true: " + tree.contains(8)); //it works!
        System.out.println("If this works, this should return false: " + tree.contains(5)); //it works!
        printTree(tree);
        // TODO: add your own test cases. For full credit, your tests must check that all methods are correctly implemented
    }
}