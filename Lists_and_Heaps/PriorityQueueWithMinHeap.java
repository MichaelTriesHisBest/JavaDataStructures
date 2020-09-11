package edu.belmont.csc.src.queues;

import java.util.ArrayList;

public class PriorityQueueWithMinHeap {

    private int size;
    private ArrayList<Integer> heap; // use a dynamic array to represent the internal heap data structure

    /**
     * Default constructor for creating a priority queue
     */
    public PriorityQueueWithMinHeap() {
        heap = new ArrayList<>();
    }

    /**
     * Constructor of PQ with initial elements
     *
     * @param data - data to initialize the PQ
     */
    public PriorityQueueWithMinHeap(int[] data) {
        this();
        // size = 0;
        for (int arbitrary : data) {
            add(arbitrary);
        }
    }


    /**
     * Check if the PQ is empty in O(1) time
     *
     * @return true if empty and false otherwise
     */
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    /**
     * Clears everything in the PQ in O(n) time
     */
    public void clear() {
        if (isEmpty()) {
            return;
        }
        heap.clear();
        size = 0;
    }

    /**
     * Returns the size of the PQ
     *
     * @return size of the PQ
     */
    public int size() {
        if (isEmpty())
            return 0;
        return heap.size();
    }

    /**
     * Get element with the highest priority, i.e., the smallest number in the PQ, in O(1) time
     *
     * @return element with the highest priority
     */
    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    /**
     * Removes element with the highest priority, i.e., the smallest number in the PQ, in O(Log(n)) time
     * Make sure the heap invariant is maintained after this method is called
     *
     * @return element with the highest priority
     */
    public Integer poll() {
        if (isEmpty()) return null;
        int a = removeAt(0);
        return a;
    }

    /**
     * Add a single element to the PQ in O(Log(n)) time
     * Make sure the heap invariant is maintained after this method is called
     *
     * @param element
     */
    public void add(int element) {
        heap.add(element);
        bubbleUp(element);
        size++;
    }

    private void swap(int i, int j) {
        int t = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, t);
    }

    /**
     * Bubble up the specified element to the proper position in the heap O(Log(n))
     *
     * @param element
     */
    private void bubbleUp(int element) {
        int i = heap.indexOf(element);
        if (i > 0) {
            int parentIdentificationNumber = heap.get(parent(i));
            int theParent = heap.indexOf(parentIdentificationNumber);
            if (parentIdentificationNumber > element) {
                swap(theParent, i);
                bubbleUp(element);
            }
        }
    }

    /**
     * Bubble down the specified element to the proper position in the heap O(Log(n))
     *
     * @param element
     */
    private void bubbleDown(int element) {
        int i = heap.indexOf(element);
        if (i == -1) {
            System.out.println("uWu oopsie!");
            return;
        }
        if (i > 0) {
            if (rightChild(i) != null && leftChild(i) != null) {
                if (rightChild(i) != null || leftChild(i) != null) {
                    int rightyValue = heap.get((2 * i) + 2);
                    int leftyValue = heap.get((2 * i) + 1);
                    if (rightyValue < element && rightyValue < leftyValue) {
                        swap((2 * i) + 2, i);
                        bubbleDown(element);
                    }
                    if (element > leftyValue && leftyValue <= rightyValue) {
                        swap((2 * i) + 1, i);
                        bubbleDown(element);
                    }
                }
            }
        }
        if (rightChild(i) != null && leftChild(i) == null) {
            int rightyValue = heap.get((2 * i) + 2);
            if (element > rightyValue) {
                swap((2 * i) + 2, i);
                bubbleDown(element);
            }
        }
        if (leftChild(i) != null && rightChild(i) == null) {
            int leftyValue = heap.get((2 * i) + 1);
            if (element > leftyValue) {
                swap((2 * i) + 1, i);
                bubbleDown(element);
            }
        }
        if (i == 0) {
            if (rightChild(i) != null || leftChild(i) != null) {
                int rightyValue = heap.get((2 * i) + 2);
                int leftyValue = heap.get((2 * i) + 1);
                if (rightyValue < element && rightyValue < leftyValue) {
                    swap((2 * i) + 2, i);
                    bubbleDown(element);
                }
                if (element > leftyValue && leftyValue < rightyValue) {
                    swap((2 * i) + 1, i);
                    bubbleDown(element);
                }
            }
        }
    }

    // Removes a particular element in the heap, O(n)

    /**
     * Removes the specified element in the PQ in O(n) time
     *
     * @param element
     * @return true if the element was removed successfully and false otherwise
     */
    public boolean remove(int element) {
        if (isEmpty()) return false;
        for (int i = 0; i < size(); i++) {
            if (heap.get(i) == element) {
                int elementToBeRemoved = heap.get(i);
                int lastElement = heap.get(size() - 1);
                swap(elementToBeRemoved, size() - 1);
                heap.remove(size() - 1);
                bubbleDown(lastElement);
                size--;
                return true;
            }
        }

        return false;
    }

    private void errorMessage() {
        System.out.println(".\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n");

    }

    private Integer leftChild(int i) {
        return (heap.size() > (2 * i) + 1) ? heap.get((2 * i) + 1) : null;
    }

    private Integer rightChild(int i) {

        return (heap.size() > (2 * i) + 2) ? heap.get((2 * i) + 2) : null;
    }

    // Return the index of the parent of node i
    // (Parent of root will be -1)
    private Integer parent(int i) {

        return (i % 2 == 0 ? (i - 2) / 2 : (i - 1) / 2);

    }
    // Removes a node at particular index, O(log(n))

    /**
     * Removes element at the specified index
     *
     * @param index
     * @return value of the element or null if PQ is empty
     */
    private Integer removeAt(int index) {
        if (isEmpty() || index > heap.size() || index < 0) {
            System.out.println("Don't worry, I've got this covered.");
            return null;
        }
        if (index == size() - 1) {
            int elementToBeRemoved = heap.get(index);
            heap.remove(elementToBeRemoved);

            size--;
            return elementToBeRemoved;
        }
        int elementToBeRemoved = heap.get(index);

        int lastElement = heap.get(size() - 1);

        swap(index, size() - 1);
        heap.remove(size() - 1);
        bubbleDown(heap.get(index));
        size--;
        return elementToBeRemoved;
    }

    @Override
    public String toString() {
        return heap.toString();
    }

    public static void main(String[] args) {
        // TODO: add your own tests for each method

        int[] arr = {-2, -1, -2, 0, 2, 5, -4, 2, 8, 14, 18, 5};
        PriorityQueueWithMinHeap pq = new PriorityQueueWithMinHeap(arr);
        pq.add(4);
        pq.add(5);
        pq.add(9);
        System.out.println(pq);
        System.out.println("Size of PrioritiyQueueWithMinHeapAttributesBroughtToYouByMichaelMcGaw: " + pq.size()); //works
        System.out.println("I've nothing clever for this: " + pq.poll());
        System.out.println("Please, for the love of God, work: " + pq.removeAt(0));
        System.out.println("Ooga booga!: " + pq.remove(5000000));
        System.out.println("PEEKA-BOO: " + pq.peek());
        System.out.println(pq);
        System.out.println("If this doesn't work I'm turning it in regardless: " + pq.remove(5));
        System.out.println("If this doesn't work I'm turning it in regardless: " + pq.remove(0));
        System.out.println("Size after I've removed stuff: " + pq.size());
        System.out.println("This isn't supposed to work anyways: " + pq.remove(500));
        System.out.println("This isn't supposed to work either: " + pq.removeAt(500));
        System.out.println(pq);
        System.out.println("Ay bro is this empty: " + pq.isEmpty());
        pq.clear();
        System.out.println(pq.poll());
        System.out.println("PEEKA-BOO: " + pq.peek());
        System.out.println("Can you remove what isn't there? " + pq.remove(0));
        System.out.println(pq);
        System.out.println("Yo maybe it's empty now who knows?? " + pq.isEmpty());
        System.out.println("Does it even matter? " + pq.size());
        System.out.println("OwO what's this? " + pq.peek());

//       //  END OF TODO
    }
}