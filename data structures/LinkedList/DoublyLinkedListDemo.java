package LinkedList;

public class DoublyLinkedListDemo {

    public static void main(String [] args) {

        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.add(20);
        dll.add(140);
        dll.add(145);
        dll.add(245);
        dll.add(165);
        dll.add(95);
        dll.add(74);
        dll.add(65);

        dll.printList();

        dll.remove(245);
        dll.remove(95);
        dll.remove(20);

        dll.printList();

    }
}
