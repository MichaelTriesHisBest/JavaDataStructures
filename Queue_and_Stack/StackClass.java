package edu.belmont.csc.src.stacks;

import java.util.LinkedList;
public class StackClass<T> {


    public StackClass(){}
    LinkedList<T> stack = new LinkedList<>();

    public int size() {
            return stack.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(T elm) {
       stack.addLast(elm);
    }

    public T pop() {
        if(stack.size() == 0){
            return null;
        }
      return  stack.removeLast();
    }

    public T peek() {
       return stack.peekLast();
    }
}