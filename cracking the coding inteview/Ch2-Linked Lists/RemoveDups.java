import java.util.HashMap;

public class RemoveDups{

	public static void main(String [] args){

		LinkedList<Integer> list = new LinkedList<>();
		System.out.println("Before removing the duplicates");
		list.add(1);
		list.add(13);
		list.add(27);
		list.add(13);
		list.add(41);
		list.add(52);
		list.add(41);
		list.printList();

		System.out.println("After removing the duplicates");
		// removing operation
		HashMap<Integer,Node<Integer>> map = new HashMap<>();
		Node<Integer> tempNode = list.getHead();
		Node<Integer> prevNode = null;
		while(tempNode != null){
			if(!map.containsKey(tempNode.getData())){
				map.put(tempNode.getData(),tempNode);
				prevNode = tempNode;
			} else{
				prevNode.setNext(tempNode.getNext());
			}
			tempNode = tempNode.getNext();
		}
		list.printList();
	}
}