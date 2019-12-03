public class RemoveDups{

	public static void main(String [] args){

		LinkedList<Integer> list = new LinkedList<>();
		list.add(5);
		list.add(12);
		list.add(67);
		list.add(55);
		list.add(989);
		list.add(8987);

		list.remove(55);
		list.remove(12);
		list.remove(989);
		list.remove(5);
		list.remove(8987);
		list.printList();
	}
}