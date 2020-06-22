public class HeapDemo {
    public static void main(String[] args) {
        Heap h = new Heap();
        /*
        h.insert(25);
        h.insert(12);
        h.insert(9);
        h.insert(2);
        h.insert(15);
        h.insert(6);
        h.insert(28);
        h.insert(30);
        h.insert(7);
        h.insert(52);
        h.insert(55);
        h.insert(21);
        h.insert(3);
        h.insert(33);
        h.insert(27);        
        */
        h.insert(7);
        h.insert(8);
        h.insert(12);
        h.insert(17);
        h.insert(16);
        h.insert(15);
        h.insert(18);
        h.printHeap();
        h.remove(0);
        h.printHeap();

    }
}