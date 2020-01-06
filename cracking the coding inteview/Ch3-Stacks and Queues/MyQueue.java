import java.util.List;
import java.util.ArrayList;

public class MyQueue<E>{

    private List<E> queueList;      // used list to store elements
    private int size;               // size of queue

    public MyQueue(){
        queueList = new ArrayList<>();
        size = 0;
    }

    public void add(E data){
        queueList.add(data);
        size ++;
    }

    public E remove(){
        E data = queueList.get(0);
        queueList.remove(0);
        size--;
        return data;
    }

    public E peek(){
        return queueList.get(0);
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void printQueue(){
        for(int i=0; i<size; i++){
            System.out.print(queueList.get(i) + " ");
        }
        System.out.println();
    }

}