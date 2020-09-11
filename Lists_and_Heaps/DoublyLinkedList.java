package edu.belmont.csc.src;

public class DoublyLinkedList {
    // TODO: declare the class variables
    int size;
    // int data;

    public DoublyLinkedList() {

    }

    // END OF TODO
    //thanks for the hint

    // TODO: implement the internal Node class (hint: this should be very similar to SinglyLinkedList's Node class with
    //  an additional pointer)
    class Node {
        int data;
        Node next;
        Node previous;


        Node(int data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    Node head;
    Node tail;

    // END OF TODO
    // Empty the linked list; this should take O(n) time
    public void clear() {
        if (isEmpty()) {
            return;
        }
        if (size == 1) {
            removee(head);
            return;
        }
        while (size > 0)
            removeAt(size);

    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    // Append a node to the tail of the linked list; this should have an O(1) implementation
    public void append(int data) {
        Node new_Node = new Node(data);

        if (tail == null) {
            tail = new_Node;
            size++;
            if (head == null) {
                head = new_Node;
            }
        } else {
            new_Node.previous = tail;
            tail.next = new_Node;
            tail = new_Node;
            size++;
        }
    }

    // Add a new node to the head of the linked list; this should have an O(1) implementation
    public void insertAtHead(int data) {
        Node new_Node = new Node(data);
        if (head == null) {
            head = new_Node;
            tail = head;
            size++;

        } else {
            new_Node.next = head;
            head.previous = new_Node;

            head = new_Node;
            size++;
        }

        }


    // Remove node from the head of this list and return the value of the removed node; should run in O(1) time
    public int removeFromHead() {
        if (isEmpty()) {
            return -1;
        }
        //Edge cases suck, Dr. Z :(
        if (head != null) {
            Node new_Node = head;
            removee(head);
            return new_Node.data;
        }
        Node new_Node = head;
        if (head.next == null) {
            System.out.println("Your list is empty!");
            removee(head);
            return new_Node.data;
        }
        if (tail.previous == null) {
            System.out.println("Your list is empty!");
            removee(tail);
            return new_Node.data;
        } else {
            removee(head);
            return new_Node.data;

        }
    }
    // Remove node from the tail head of this list and return the removed node; should run in O(1) time
    public Node removeFromTail() {
        if (isEmpty()) {
            System.out.println("Your List is Empty!");
            return null;
        }
        //Edge cases suck, Dr. Z :(
        if (tail != null) {
            System.out.println("The tail you've removed is : " + tail.data);
            tail = tail.previous;
            removeAt(size-1);
            System.out.println("Your new tail node is : " + tail.data);
            return tail;

        }
        Node new_Node = tail;
        if (head.next == null) {
            System.out.println("Your list is empty!");
            removee(head);
            return tail;
        }
        if (tail.previous == null) {
            System.out.println("Your list is empty!");
            removee(tail);
            return null;

        } else {
            System.out.print("The tail you've removed is : " + new_Node.data + "==");
            removee(tail);
            return new_Node;
        }
    }

    public void printDoublyLinkedList(Node node) {
        if(node == null){
            System.out.print("Your list is empty!");
        }
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // Remove the specified node from the linked list and return the data of the removed node; should run in O(1) time
    //email about this method
    private boolean removee(Node node) {
        if (isEmpty()) {
            System.out.println("Hehe you tried breaking my assignment!");
            return false;
        }
        if (size == 1) {
            head = null;

        }
        if (head == node) {
            head = node.next;
        }
        if (node.previous != null) {
            node.previous.next = node.next;
        }
        if (node.next != null) {
            node.next.previous = node.previous;
        }
        if(node == tail){
            tail = node.previous;
        }
        size--;
        return true;
    }

    // Remove a node at a given index and return the removed node; this implementation should run in linear time
    public Node removeAt(int index) { //FIXED

        if(head == null) {
            System.out.println("What kind of FOOL wouldn't have this edge case covered!?");
            return null;
        }
        Node node = head;
        for (int i = 0; i < index && node.next != null; i++) {
            node = node.next;
        }
        removee(node);
        return node;
    }

    // Remove the first node with the specified value in the linked list; linear time complexity
    public boolean remove(int data) {

        for (int i = 0; i < size; i++) {
            if(head.data != data){
                head = head.next;
            }
            if(head.data != data && i < size-1)
                return false;
        }
        removeFromHead();
        return true;
    }



    // Find the index of the first node in the linked list that has the specified value
    public int indexOf(int data) {
        if (isEmpty()) {
            System.out.println("Haha you tried breaking my assignment!");
        }
        if(size == 1){
            return 0;
        }
        Node checkerNode = new Node(data);
        Node otherNode =  head;
        for (int i = 0; i < size; i++) {
            if (otherNode.data == checkerNode.data) {
                return i;
            } else {
                otherNode = otherNode.next;
            }
        }
       System.out.println("Haha you forgot that I have my edge cases covered!"); return -1;
    }
}

class runr {

    public static void main(String[] args) {
        DoublyLinkedList DLL = new DoublyLinkedList();
        DLL.insertAtHead(1);
        DLL.insertAtHead(2);
        DLL.insertAtHead(3);
        DLL.insertAtHead(4);
        DLL.insertAtHead(5);
        DLL.insertAtHead(6);
        DLL.insertAtHead(7);
        DLL.append(8);
        DLL.append(9);
        DLL.append(10);
        DLL.printDoublyLinkedList(DLL.head);
        DLL.removeFromTail();
        System.out.println("The head you've removed is : " + DLL.removeFromHead() + ", your new head is " + DLL.head.data);
        DLL.removeFromTail();
        System.out.println("The head you've removed is : " + DLL.removeFromHead() + ", your new head is " + DLL.head.data);
        System.out.println(DLL.isEmpty());
        DLL.printDoublyLinkedList(DLL.head);
        DLL.clear();
        DLL.isEmpty();
        System.out.println( DLL.indexOf(1)); //this returns -1 if not found
        DLL.removeFromHead();
        DLL.removeFromTail();
        DLL.remove(3);
        DLL.removeAt(3);
        DLL.insertAtHead(1);
       System.out.println( DLL.indexOf(1));
       //The remove(Node node) method works cause all of my remove methods use it! Hence why there's no case for it!!!!!
        //I cannot think of any more ways to break this :v
    }

}

