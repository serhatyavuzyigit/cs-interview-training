package LinkedList;

public class SinglyLinkedListDemo {

    public static void main(String[] args) {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(5);
        list.add(41);
        list.add(65);
        list.add(14);
        list.add(85);
        list.printList();

        list.removeFirst();
        list.removeLast();
        list.printList();


        list.add(120);
        list.printList();
    }
}
