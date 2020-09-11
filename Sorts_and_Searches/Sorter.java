package edu.belmont.csc.src.sorting;

import java.lang.reflect.Array;
import java.util.Vector;

public class Sorter {

    static class BubbleSort extends AbstractSorter {
        public void sort(int[] arr) {
            int i, j, temp, n;
            n = arr.length;
            boolean swapped;
            for (i = 0; i < n - 1; i++) {
                swapped = false;
                for (j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // swap arr[j] and arr[j+1]
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        swapped = true;
                    }
                }
            }
        }
    }
        static class SelectionSort extends AbstractSorter {
            public void sort(int[] arr) {
                int min;
                int temp = 0;
                for (int i = 0; i < arr.length; i++) {
                    min = arr[i];
                    for (int j = i; j < arr.length; j++) {
                        //swapping?
                        if (arr[j] < min) {
                            min = arr[j];
                            temp = arr[j];
                            arr[j] = arr[i];
                            arr[i] = temp;
                        }
                    }
                }
            }
        }


        //time complexity of n^2
        static class InsertionSort extends AbstractSorter {

            public void sort(int[] arr) {
                for (int i = 1; i < arr.length; i++) {

                    int j = i - 1;
                    int key = arr[i];

                    while (j >= 0 && arr[j] > key) {
                        arr[j + 1] = arr[j];
                        j--;
                    }
                    arr[j + 1] = key;
                }
            }
        }

        static class ShellSort extends AbstractSorter {
            public void sort(int[] arr) {
                for (int gap = arr.length / 2; gap > 0; gap /= 2) {
                    for (int i = 0; i < arr.length; i++) {
                        int temp = arr[i];
                        int idx;
                        for (idx = i; idx >= gap && arr[idx - gap] > temp; idx -= gap) {
                            arr[idx] = arr[idx - gap];
                        }
                        arr[idx] = temp;
                    }
                }
            }
        }


        static class BucketSort extends AbstractSorter {
            public void sort(int[] arr) {
                Vector<Integer> bucket = new Vector<>();
                for (int i = 1; i < arr.length; i++) {
                    int bi = 10 * arr[i];
                    bucket.add(bi);

                }
            }
//            for i in [0,n-1]
//            int bi = n*arr[i]
//                    bucket[bi] .add(arr[i]);
//                    for(i in 0,n-1)
//                       insertionSort(arr)
//                    index = 0;
//                            for i in [i,n-1]
//            for j in [0,bucket[i].size()-1]]
//            arr[index++] = b[i][j]
        }


        // Driver code
        public static void main(String[] args) {
            int[] arr1 = {8, 4, 5, 3, 2, 7, 1, 0, 10, 9};

            AbstractSorter insertionSort = new InsertionSort();
            insertionSort.runSorter(arr1);

            int[] arr2 = {10, 9, 8, 4, 5, 3, 2, 7, 1};

            AbstractSorter selectionSort = new SelectionSort();
            selectionSort.runSorter(arr2);
            int[] arr3 = {9, 2, 8, 10, 4, 5, 3, 2, 7, 1};

            AbstractSorter bubbleSort = new BubbleSort();
            bubbleSort.runSorter(arr3);


//        AbstractSorter bucketSort = new BucketSort();
//        bucketSort.runSorter(arr2);
//        int[] arr4 = {9, 2, 8, 10, 4, 5, 3, 2, 7, 1};


        }

    }
