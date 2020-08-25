public class GivenArrayIsHeap {

    public static void main(String[] args) {
        
        int [] minHeap = {2, 7, 3, 9, 15, 6, 27, 30, 25, 52, 55, 21, 12, 33, 28};
        System.out.println(isMinHeap(minHeap));

    }

    private static boolean isMinHeap(int [] heap) {
        int size = heap.length;
        for(int i=0; 2*i+2<size; i++) {
            int leftChild = heap[i*2+1];
            int rightChild = heap[i*2+2];
            if(!(heap[i]<leftChild && heap[i]<rightChild)) return false;
        }
        return true;
    }

    private static boolean isMaxHeap(int [] heap) {
        int size = heap.length;
        for(int i=0; 2*i+2<size; i++) {
            int leftChild = heap[i*2+1];
            int rightChild = heap[i*2+2];
            if(!(heap[i]>leftChild && heap[i]>rightChild)) return false;
        }
        return true;
    }
}