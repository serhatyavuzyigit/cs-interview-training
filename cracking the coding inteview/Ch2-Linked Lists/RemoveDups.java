import java.util.HashMap;

public class RemoveDups{

  public static void main(String[] args) {
    LinkedList list = new LinkedList();

		list.add(1);
		list.add(13);
		list.add(27);
		list.add(13);
		list.add(41);
		list.add(52);
		list.add(41);
    
    System.out.println("Before operation");
		list.printList();

		//Testing remove dups
		System.out.println("After removing the duplicates");
		removeDups(list);

    list.printList();
		
  }

  private static void removeDups(LinkedList list){
      HashMap<Integer,Node> map = new HashMap<>();
      Node tempNode = list.getHead();
      Node prevNode = null;
      while(tempNode != null){
        if(!map.containsKey(tempNode.getData())){
          map.put(tempNode.getData(),tempNode);
          prevNode = tempNode;
        } else{
          prevNode.setNext(tempNode.getNext());
        }
        tempNode = tempNode.getNext();
      }
  }
}
