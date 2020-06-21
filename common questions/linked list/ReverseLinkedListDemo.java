import java.util.LinkedList;

public class ReverseLinkedListDemo{
    public static void main(String[] args) {
        
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println(list);

        MyLinkedList<Integer> reverseList = list.getReverse();
        System.out.println(reverseList);
    }
}