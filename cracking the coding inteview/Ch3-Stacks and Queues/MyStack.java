public class MyStack<E> {

    private static class MyStackNode<E> {

        private E data;
        private MyStackNode<E> next;

        public MyStackNode(E data) {
            this.data = data;
            this.next = null;
        }

        public void setData(E data) { data = data; }

        public E getData() { return data; }

        public void setNext(MyStackNode node) { next = node; }

        public MyStackNode getNext() { return next; }
    }

    private MyStackNode<E> head;

    public MyStack() {
        head = new MyStackNode<>(null);
    }

    public void push(E data) {
        MyStackNode<E> node = new MyStackNode<>(data);
        node.setNext(head.getNext());
        head.setNext(node);
    }

    public E pop() {
        if(head.getNext() == null) {
            System.out.println("There is no element in stack");
            return null;
        } else {
            MyStackNode<E> top = head.getNext();
            MyStackNode<E> secondTop = top.getNext();
            head.setNext(secondTop);
            return top.getData();
        }
    }

    public E top() {
        if(head.getNext() == null) {
            System.out.println("There is no element in stack");
            return null;
        } else {
            MyStackNode<E> top = head.getNext();
            return top.getData();
        }
    }

    public void printContent() {
        String content = "";
        MyStackNode<E> temp = head.getNext();
        while(temp != null) {
            content += temp.getData() + " ";
            temp = temp.getNext();
        }

        System.out.println(content);
    }
}