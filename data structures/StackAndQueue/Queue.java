package StackAndQueue;

import java.util.ArrayList;
import java.util.List;

public class Queue<E> {

    // FIRST IN FIRST OUT

    private List<E> queueList;
    private int exactSize;
    private boolean sizeFlag;

    public Queue() {
        queueList = new ArrayList<>();
        exactSize = -1;
        sizeFlag = false;
    }

    public Queue(int size) {
        queueList = new ArrayList<>(size);
        exactSize = size;
        sizeFlag = true;
    }

    public void enqueue(E data) {
        if(!sizeFlag) {
            queueList.add(data);
        } else if(sizeFlag && size() < exactSize) {
            queueList.add(data);
        } else {
            // no operation
        }
    }

    public E dequeue() {
        E data = queueList.get(0);
        queueList.remove(0);
        return data;
    }

    public E peek() {
        E data = queueList.get(0);
        return  data;
    }

    public boolean isEmpty() {
        return queueList.size() == 0;
    }

    public boolean isFull() {
        return queueList.size() == exactSize;
    }

    public int size() { return queueList.size(); }


    public String toString() {
        return queueList.toString();
    }
}
