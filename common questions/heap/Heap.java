import java.util.ArrayList;
import java.util.List;

public class Heap {
    // min heap implementation
    private List<Integer> heapList;
    private int size;

    public Heap() {
        heapList = new ArrayList<>();
        size = 0;
    }

    private int parent(int j) { return (j-1)/2; }
    private int left(int j) { return (j*2)+1; }
    private int right(int j) { return (j*2)+2; }
    private boolean hasLeft(int j) { return left(j) < size; }
    private boolean hasRight(int j) { return right(j) < size; }

    public void insert(int e) {
        heapList.add(e);
        heapify();
        size++;
    }

    private void heapify() {
        int index = size;
        int temp = heapList.get(index);
        while(index > 0 && temp < heapList.get(parent(index))) {
            heapList.set(index, heapList.get(parent(index)));
            index = parent(index);
        }
        heapList.set(index, temp);
    }

    public int getMin() { return heapList.get(0); }

    public int remove(int i) {
        int temp = heapList.get(i);
        heapList.set(i, heapList.get(size-1));
        size--;
        downHeapify(i);
        return temp;
    }

    private void downHeapify(int ind) {
        int temp = heapList.get(ind);
        int child;
        while(2*ind+1 <size) {
            int leftChild = heapList.get(left(ind));
            int rightChild = heapList.get(right(ind));
            if (leftChild < rightChild) child = left(ind);
            else child = right(ind);

            if (temp > heapList.get(child)) {
                heapList.set(ind, heapList.get(child));
                ind = child;
            } else break;
        }
        heapList.set(ind, temp);

    }

    public void printHeap() {
        String content = "";
        for(int i=0; i<size; i++) {
            content += heapList.get(i) + " ";
        }
        System.out.println(content);

    }
}   