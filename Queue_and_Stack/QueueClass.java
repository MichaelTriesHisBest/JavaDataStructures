package edu.belmont.csc.src.queues;

import java.util.LinkedList;

public class QueueClass<T> {
    LinkedList<T> list;

    public QueueClass(){
        list = new LinkedList();
    }

    public QueueClass(T firstElement) {
        this();
        list.add(firstElement);
    }

    // TODO: implement the following 5 methods. Hint: refer to the Stack class from our last lecture to help you define the method headers

    // enqueue
    public void enqueueQueue(T data){
        list.addFirst(data);
    }
    // dequeue
    public T dequeueQueue(){
        if(size() == 0){
            return null;
        }
        //list.removeFirst();
        return list.removeFirst();
    }

    // peek
    public T seeQueue(){
        if(size() == 0){
            return null;
        }
        return list.get(0);
    }
    // size
    public int size(){
        return list.size();
    }
    // isE
    public boolean isYouEmpty(){
        return size()==0;
    }
    // END OF TODO

}