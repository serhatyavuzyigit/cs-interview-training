import java.util.List;
import java.util.ArrayList;

public class Partition{

  public static void main(String[] args) {

    LinkedList list = new LinkedList();
    list.add(3);
		list.add(5);
		list.add(8);
		list.add(5);
		list.add(10);
		list.add(2);
		list.add(1);

    System.out.println("Before partition");
    list.printList();
    partition(list, 5);

    System.out.println("After partition");
    list.printList();
  }

  private static void partition(LinkedList list, int partition){
    // assume that partition is exists in given linked list
    List<Node> small_nodes = new ArrayList<>();

    Node tempNode = list.getHead();
    Node prevNode = new Node(0, null);
    int partitionFlag = 0;    // holds the status of iterate over partition in for loop
    while(tempNode != null ){
      if(partitionFlag == 1){
        if(tempNode.getData() < partition){
          small_nodes.add(tempNode);
          // remove Node
          Node successor = tempNode.getNext();
          tempNode.setNext(null);
          prevNode.setNext(successor);
          tempNode = successor;
        }

        // if tempnode == tailnode
        if(tempNode.equals(list.getTail())){
          if(tempNode.getData() < partition){
            small_nodes.add(tempNode);
            prevNode.setNext(null);
            list.setTail(prevNode);

            break;
          }

        }
      }
      if(tempNode.getData() == partition){
        partitionFlag = 1;
      }

      prevNode = tempNode;
      tempNode = tempNode.getNext();
    }

    addNodesToBeginningOfList(list, small_nodes);
  }

  private static void addNodesToBeginningOfList(LinkedList list, List<Node> small_nodes){

    for(int i=0; i<small_nodes.size(); i++ ){
      Node newNode = small_nodes.get(i);

      Node headNode = list.getHead();
      newNode.setNext(headNode);
      list.setHead(newNode);
    }
  }
}
