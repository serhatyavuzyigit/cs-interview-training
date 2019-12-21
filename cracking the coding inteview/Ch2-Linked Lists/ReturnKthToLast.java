public class ReturnKthToLast{
    
    public static void main(String []args){
        LinkedList list = new LinkedList();

		list.add(1);
		list.add(13);
		list.add(27);
		list.add(13);
		list.add(41);
		list.add(52);
		list.add(41);
		list.add(34);
		list.add(61);
		list.add(99);

		// testing return kth to returnKthToLast
		int k = 6;
		Integer i = returnKthToLast(list,k);
		list.printList();
		System.out.println(k + "th last element from list: " + i);
    }

    // returns the last k'th element from list
    private static int returnKthToLast(LinkedList list, int k){
      Node p1 = list.getHead();
      Node p2 = list.getHead();

      for(int i=0;i<k;i++){
        p1 = p1.getNext();
      }

      while(p1 != null){
        p1 = p1.getNext();
        p2 = p2.getNext();
      }

      return p2.getData();
    }
}