package StackAndQueue;

public class QueueDemo {

    public static void main(String []args) {
        Queue<Integer> myQueue = new Queue<>();
        myQueue.enqueue(35);
        myQueue.enqueue(45);
        myQueue.enqueue(25);
        System.out.println(myQueue);

        myQueue.dequeue();
        System.out.println(myQueue);

    }
}
