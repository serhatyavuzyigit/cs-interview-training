import java.util.List;
import java.util.ArrayList;

public class MyStack<E>{

    private List<E> stackList;      // used list to store elements
    private int size;               // size of stack

    public MyStack(){
        stackList = new ArrayList<>();
        size = 0;
    }

    public void push(E data){
        stackList.add(data);
        size++;
    }

    public E pop(){
        E data = stackList.get(size - 1);
        stackList.remove(size - 1);
        size--;
        return data;
    }

    public E peek(){
        return stackList.get(size - 1);
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void printStack(){
        for(int i=size-1; i>=0; i--){
            System.out.print(stackList.get(i) + " ");
        }
        System.out.println();
    }

}