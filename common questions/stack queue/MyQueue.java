public class MyQueue<E>{

    private static class MyQueueNode<E> {

        private E data;
        private MyQueueNode<E> next;

        public MyQueueNode(E data) {
            this.data = data;
            this.next = null;
        }

        public void setData(E data) { data = data; }

        public E getData() { return data; }

        public void setNext(MyQueueNode node) { next = node; }

        public MyQueueNode getNext() { return next; }
    }

    private MyQueueNode<E> head;
    private MyQueueNode<E> tail;

    public MyQueue() {
        head = new MyQueueNode<>(null);
        tail = new MyQueueNode<>(null);
    }

    public void enqueue(E data) {
        MyQueueNode<E> node = new MyQueueNode<>(data);
        if(tail.getData() == null) {
            head.setNext(node);
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    public E dequeue() {
        if(head.getNext() == null) {
            System.out.println("There is no element in queue");
            return null;
        } else {
            MyQueueNode<E> top = head.getNext();
            MyQueueNode<E> secondTop = top.getNext();
            head.setNext(secondTop);
            return top.getData();
        }
    }

    public E peek() {
        if(head.getNext() == null) {
            System.out.println("There is no element in queue");
            return null;
        } else {
            MyQueueNode<E> top = head.getNext();
            return top.getData();
        }
    }

    public void printContent() {
        String content = "";
        MyQueueNode<E> temp = head.getNext();
        while(temp != null) {
            content += temp.getData() + " ";
            temp = temp.getNext();
        }

        System.out.println(content);
    }

    public boolean isEmpty() {
        return head.getNext() == null;
    }
}