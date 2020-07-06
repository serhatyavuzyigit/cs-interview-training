package LinkedList;

public class DoublyLinkedList<E> {

    private static class ListNode<E> {
        private E data;             // data stored in list node

        private ListNode<E> next;   // the address stored of the next list node

        private ListNode<E> prev;   // the address stored of the previous list node

        /*
            Constructor for the inner ListNode class
        */
        public ListNode(E data, ListNode<E> prev, ListNode<E> next) {
            this.data = data;
            this.prev = prev;
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
            getting previous node of current node
        */
        public ListNode<E> getPrev() {
            return prev;
        }

        /*
            setting previous node of current node
        */
        public void setPrev(ListNode<E> node) {
            this.prev = node;
        }

        /*
            toString() method for displaying the data
        */
        public String toString() {
            return data.toString();
        }
    }

    private ListNode<E> header = null;  // first node of the list

    private ListNode<E> trailer = null; // last node of the lisr

    private int size = 0;   // size of the list

    /*
        adding new node to the list
    */
    public void add(E data) {
        if (size == 0) {
            // list is empty
            ListNode<E> newNode = new ListNode<>(data, null, null);
            newNode.setNext(null);
            newNode.setPrev(null);
            header = newNode;
            trailer = newNode;
        } else {
            ListNode<E> newNode = new ListNode<>(data, trailer, null);
            trailer.setNext(newNode);
            trailer = newNode;
        }
        size++;
    }

    /*
        adding new node to the beginning of list
    */
    public void addFirst(E data) {
        ListNode<E> newNode = new ListNode<>(data,null,header);
        header.setPrev(newNode);
        header = newNode;
        size++;
    }


    /*
        removing a node from the list
    */
    public void remove(E data) {
        int index = findIndexInList(data);
        if(index == -1) {
            return;
        } else {
            if(index == 0) {
                // removing header
                removeFirst();
            } else if(index == size-1) {
                // removing trailer
                removeLast();
            } else {
                ListNode<E> node = getNodeWithIndex(index);
                ListNode<E> predecessor = node.getPrev();
                ListNode<E> successor = node.getNext();
                node.setPrev(null);
                node.setNext(null);
                predecessor.setNext(successor);
                successor.setPrev(predecessor);
                size--;
            }
        }
    }

    /*
        removing first element of list
    */
    public void removeFirst() {
        ListNode<E> nextNode = header.getNext();
        nextNode.setPrev(null);
        header.setNext(null);
        header = nextNode;
        size--;
    }

    /*
        removing last element of list
    */
    public void removeLast() {
        ListNode<E> prevNode = trailer.getPrev();
        prevNode.setNext(null);
        trailer.setPrev(null);
        trailer = prevNode;
        size--;
    }

    private ListNode<E> getNodeWithIndex(int index) {
        if(index == 0) {
            return header;
        } else if(index == size-1) {
            return  trailer;
        } else {
            ListNode<E> tempNode = header;
            for (int i = 0; i < index; i++) {
                tempNode = tempNode.getNext();
            }
            return tempNode;
        }
    }
    /*
        finding index in the list of given data
    */
    public int findIndexInList(E data) {
        int index = 0;
        if (header.getData().equals(data)) {
            return 0;
        } else if (trailer.getData().equals(data)) {
            return size - 1;
        } else {
            ListNode<E> tempNode = header;
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
        printing content of list
    */
    public void printList() {
        ListNode<E> tempNode = header;
        String content = "";
        while (true) {
            if (tempNode == trailer) {
                content += tempNode.getData();
                break;
            }
            content += tempNode.getData() + " <-> ";
            tempNode = tempNode.getNext();
        }
        System.out.println(content);
    }

}
