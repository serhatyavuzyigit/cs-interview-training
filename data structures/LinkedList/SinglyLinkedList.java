package LinkedList;

import javax.sound.midi.SysexMessage;
import java.util.List;

public class SinglyLinkedList<E> {

    private static class ListNode<E> {

        private E data;             // data stored in list node

        private ListNode<E> next;   // the address stored of the next list node

        /*
            Constructor for the inner ListNode class
        */

        public ListNode(E data, ListNode<E> next) {
            this.data = data;
            this.next = next;
        }

        /*
            getting data of the current node
        */
        public E getData() {
            return data;
        }

        /*
            getting next node of current node
        */
        public ListNode<E> getNext() {
            return next;
        }

        /*
            setting next node of current node
        */
        public void setNext(ListNode<E> node) {
            this.next = node;
        }

        /*
            toString() method for displaying the data
        */
        public String toString() {
            return data.toString();
        }
    }


    private ListNode<E> head = null;   // first node of list

    private ListNode<E> tail = null;   // last node of list

    private int size = 0;

    /*
        adding new node to the list
    */
    public void add(E data) {
        ListNode<E> node = new ListNode<>(data, null);
        if (size == 0) {
            head = node;
            tail = node;
            tail.setNext(null);
            size++;
        } else {
            addLast(data);
        }

    }

    /*
        adding node to the beginning of the list
    */
    public void addFirst(E data) {
        ListNode<E> newNode = new ListNode<>(data, head);
        head = newNode;
        size++;
    }

    /*
        adding node to the end of the list
    */
    public void addLast(E data) {
        ListNode<E> newNode = new ListNode<>(data, null);
        tail.setNext(newNode);
        tail = newNode;
        size++;

    }

    /*
        removing given data to the list
    */
    public void remove(E data) {
        int index = findIndexInList(data);
        if (index == -1) {
            return;
        } else if (index == 0) {
            // data is in the head
            removeFirst();
        } else if (index == size - 1) {
            // data is in the tail
            removeLast();
        } else {
            // data is in somewhere middle
            ListNode<E> tempNode = head;
            ListNode<E> prev = null;
            ListNode<E> next = null;
            for (int i = 0; i < size; i++) {
                if (i == index - 1) {
                    prev = tempNode;
                } else if (i == index + 1) {
                    next = tempNode;
                }
                tempNode = tempNode.getNext();
            }

            prev.setNext(next);
            size--;
        }

    }

    /*
        removing from beginning of the list
    */
    public void removeFirst() {
        ListNode<E> tempNode = head.getNext();
        head.setNext(null);
        head = tempNode;
        size--;
    }

    /*
        removing from end of the list
    */
    public void removeLast() {
        ListNode<E> tempNode = head;
        for (int i = 0; i < size - 2; i++) {
            tempNode = tempNode.getNext();
        }
        tempNode.setNext(null);
        tail = tempNode;
        size--;
    }

    /*
        finding index in the list of given data
    */
    public int findIndexInList(E data) {
        int index = 0;
        if (head.getData().equals(data)) {
            return 0;
        } else if (tail.getData().equals(data)) {
            return size - 1;
        } else {
            ListNode<E> tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.getData().equals(data)) {
                    return i;
                }
                tempNode = tempNode.getNext();
            }
            return -1;
        }
    }

    /*
        getting size of the list
    */
    public int getSize() {
        return size;
    }

    /*
        displaying the values in the list
    */
    public void printList() {
        ListNode<E> tempNode = head;
        String content = "";
        while(true) {
            if(tempNode == tail){
                content += tempNode.getData();
                break;
            }
            content+=tempNode.getData() + " -> ";
            tempNode = tempNode.getNext();
        }
        System.out.println(content);
    }
}
