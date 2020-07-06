package StackAndQueue;

import java.util.ArrayList;
import java.util.List;

public class Stack<E> {

    // LAST IN FIRST OUT

    private List<E> stackList;
    private boolean sizeFlag;
    private int exactSize;

    public Stack() {
        stackList = new ArrayList<>();
        sizeFlag = false;
        exactSize = -1;
    }

    public Stack(int size) {
        stackList = new ArrayList<>(size);
        sizeFlag = true;
        exactSize = size;
    }

    public void push(E data) {
        if (!sizeFlag) {
            stackList.add(data);
        } else if(sizeFlag && size() < exactSize) {
            stackList.add(data);
        } else{
            // no operation
        }
    }
    public E pop() {
        E data = stackList.get(stackList.size()-1);
        stackList.remove(stackList.size()-1);
        return  data;
    }

    public E top() {
        E data = stackList.get(stackList.size()-1);
        return data;
    }
    public int size() { return stackList.size(); }

    public boolean isEmpty() {
        return stackList.size() == 0;
    }

    public boolean isFull() {
        return stackList.size() == exactSize;
    }
    public String toString() {
        return stackList.toString();
    }

}
