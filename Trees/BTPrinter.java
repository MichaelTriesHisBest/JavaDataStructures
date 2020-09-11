package edu.belmont.csc.src.trees;

import edu.belmont.csc.src.search.BinarySearchTree;

import java.io.PrintStream;

public class BTPrinter {
    public static String RPOINTER="└──";
    public static String LPOINTER="├──(L) ";

    private BinarySearchTree tree;

    public BTPrinter(BinarySearchTree tree) {
        this.tree = tree;
    }

    private String traversePreOrder(BinarySearchTree.BSTNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.data);

        String pointerLeft = (root.right != null) ? LPOINTER : RPOINTER+"(L) ";

        traverseNodes(sb, "", pointerLeft, root.left, root.right != null);
        traverseNodes(sb, "", RPOINTER+"(R) ", root.right, false);

        return sb.toString();
    }

    private void traverseNodes(StringBuilder sb, String padding, String pointer, BinarySearchTree.BSTNode node,
                               boolean hasRightSibling) {

        if (node != null) {

            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.data);

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│   ");
            } else {
                paddingBuilder.append("    ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerLeft = (node.right != null) ? LPOINTER : RPOINTER+"(L) ";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
            traverseNodes(sb, paddingForBoth, RPOINTER+("(R) "), node.right, false);

        }

    }

    public void print(PrintStream os) {
        os.print(traversePreOrder(tree.root));
    }

}