import java.util.HashMap;

public class LinkedListDemo{

	public static void main(String [] args){

		LinkedList<Integer> list = new LinkedList<>();

		list.add(1);
		list.add(13);
		list.add(27);
		list.add(13);
		list.add(41);
		list.add(52);
		list.add(41);


		System.out.println("Before operation");
		list.printList();

		/* Testing remove dups
		System.out.println("After removing the duplicates");
		list.removeDups();
		*/

		// testing return kth to returnKthToLast
		int k = 6;
		Integer i = list.returnKthToLast(k);
		list.printList();
		System.out.println(k + "th last element from list: " + i);

	}
}
