public class GivenArrayIsHeap {

    public static void main(String[] args) {
        
        int [] minHeap = {7, 8, 12, 17};
        System.out.println(isMaxHeap(minHeap));

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