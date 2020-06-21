public class MyLinkedList<E extends Comparable<E>> {

    private static class LinkedListNode<E> {
        private E data;
        private LinkedListNode<E> next;

        public LinkedListNode(E data, LinkedListNode<E> node){
            this.data = data;
            this.next = node;
        }

        public void setData(E data) { this.data = data; }
        public E getData() { return data; }

        public void setNext(LinkedListNode<E> node) { this.next = node; }
        public LinkedListNode getNext() { return next; }
    }

    private LinkedListNode<E> head = null;
    private LinkedListNode<E> tail = null;
    private int size = 0;

    public void add(E data) {
        if (size == 0) {
            LinkedListNode<E> node = new LinkedListNode<>(data, null);
            head = node;
            tail = node;
            tail.setNext(null);
            size++;
        } else {
            addLast(data);
        }
    }

    public void addFirst(E data) {
        LinkedListNode<E> newNode = new LinkedListNode<>(data, head);
        head = newNode;
        if(size == 0) tail = newNode;
        size++;
    }

    public void addAfter(E data, E source) {
        if(!isExistsInList(source)) {
            return;
        }
        if(tail.getData().equals(source)) addLast(data);

        else {
            LinkedListNode<E> newNode = new LinkedListNode<>(data, null);
            LinkedListNode<E> temp = head;
            while(!temp.getData().equals(source)) {
                temp = temp.getNext();
            }
            LinkedListNode<E> nextNode = temp.getNext();
            temp.setNext(newNode);
            newNode.setNext(nextNode);
            size++;
        }

    }

    public void remove(E data) {

        if(!isExistsInList(data)) {
            return;
        }
        if(head.getData().equals(data)) {
            head = head.getNext();
            size--;
            if(size == 1) tail = head;
        } else if(tail.getData().equals(data)) {
            LinkedListNode<E> temp = head;
            while (temp.getNext() != tail) {
                temp = temp.getNext();
            }
            tail = temp;
            tail.setNext(null);
            size--;
        } else {
            LinkedListNode<E> temp = head;
            LinkedListNode<E> prevNode = null;
            LinkedListNode<E> nextNode = null;

            while(!temp.getData().equals(data)) {
                prevNode = temp;
                temp = temp.getNext();
            }

            nextNode = temp.getNext();
            prevNode.setNext(nextNode);
            size--;
        }


    }

    public void addToIndex(E data, int index) {
        if(index == 0) {
            addFirst(data);
        } else if(index == size){
            addLast(data);
        } else {
            int counter = 0;
            LinkedListNode<E> prev = null;
            LinkedListNode<E> temp = head;
            while (counter < index) {
                prev = temp;
                temp = temp.getNext();
                counter++;
            }
            LinkedListNode<E> newNode = new LinkedListNode<>(data, temp);
            prev.setNext(newNode);
        }
    }

    public MyLinkedList<E> getReverse() {
        MyLinkedList<E> newList = new MyLinkedList<>();
        LinkedListNode temp = head;
        getReverseInner(temp, newList);
        return newList;
    }

    private void getReverseInner(LinkedListNode<E> temp, MyLinkedList newList) {
        if(temp != null) {
            getReverseInner(temp.getNext(), newList);
            newList.add(temp.getData());
        }
    }

    public void sort() {

        if(size == 0 || size == 1) {
            return;
        }

        for(int i=0; i<size; i++) {
            LinkedListNode<E> temp = head;
            while (temp.getNext() != null) {
                if(temp.getData().compareTo((E)(temp.getNext().getData())) == 1) {
                    E tempData = temp.getData();
                    temp.setData((E)temp.getNext().getData());
                    temp.getNext().setData(tempData);
                }
                temp = temp.getNext();
            }
        }
    }

    public void free() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getIndex(E data) {
        if(!isExistsInList(data)) {
            return -1;
        }
        int ind = 0;
        LinkedListNode<E> temp = head;
        while(temp != null) {
            if(temp.getData().equals(data)) {
                break;
            }
            ind++;
            temp = temp.getNext();
        }
        return ind;
    }

    public boolean checkSorted() {
        LinkedListNode<E> temp = head;
        while (temp.getNext() != null) {
            if(temp.getData().compareTo((E)(temp.getNext().getData())) == 1) return false;
            temp = temp.getNext();
        }
        return true;
    }

    public int getSize() { return size; }

    private void addLast(E data) {
        LinkedListNode<E> newNode = new LinkedListNode<>(data, null);
        tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    private boolean isExistsInList(E data) {
        LinkedListNode<E> temp = head;
        while(temp != null) {
            if(temp.getData().equals(data)) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public String toString() {
        String content = "";
        LinkedListNode<E> temp = head;
        while(temp != null) {
            content += temp.getData() + " ";
            temp = temp.getNext();
        }

        return content;
    }

}
