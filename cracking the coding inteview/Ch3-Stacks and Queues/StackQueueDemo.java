public class StackQueueDemo{
    public static void main(String[] args) {
        
        MyStack<Integer> stack = new MyStack<>();
        stack.push(5);
        stack.push(12);
        stack.push(34);
        stack.push(76);
        stack.push(65);

        stack.printStack();
    }
}