public class Palindrome{

  public static void main(String[] args) {

    LinkedList l1 = new LinkedList();
    l1.add(6);
    l1.add(8);
    l1.add(5);
    l1.add(8);
    l1.add(6);

    if(isPalindrome(l1)){
      System.out.println("Given list is palindrome");
    } else {
      System.out.println("Given list is not palindrome");
    }
  }

  private static boolean isPalindrome(LinkedList list){
    LinkedList copied_list = copyList(list);
    reverseList(list);

    Node tempNode1 = copied_list.getHead();
    Node tempNode2 = list.getHead();

    while(tempNode1 != null){
      if(tempNode1.getData() != tempNode2.getData()){
        return false;
      }
      tempNode1 = tempNode1.getNext();
      tempNode2 = tempNode2.getNext();
    }
    return true;
  }

  private static void reverseList(LinkedList list){


    Node tempNode = list.getHead();
    Node prevNode = null;

    while(tempNode != null){
      Node successor = tempNode.getNext();
      tempNode.setNext(prevNode);
      prevNode = tempNode;
      tempNode = successor;
    }

    Node tempHead = list.getHead();
    Node tempTail = list.getTail();
    list.setHead(tempTail);
    list.setTail(tempHead);
  }

  private static LinkedList copyList(LinkedList list){
    LinkedList result = new LinkedList();

    Node tempNode = list.getHead();
    while(tempNode != null){
      result.add(tempNode.getData());
      tempNode = tempNode.getNext();
    }
    return result;
  }
}
