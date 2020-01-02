public class SumLists{

  public static void main(String[] args) {

    LinkedList l1 = new LinkedList();
    l1.add(9);
    l1.add(7);
    l1.add(8);

    LinkedList l2 = new LinkedList();
    l2.add(6);
    l2.add(8);
    l2.add(5);
    l2.add(2);

    LinkedList sum_list = sumLists(l1, l2);
    sum_list.printList();
  }

  private static LinkedList sumLists(LinkedList l1, LinkedList l2){
    LinkedList result = new LinkedList();

    Node temp_l1 = l1.getHead();
    Node temp_l2 = l2.getHead();
    int carry = 0;
    int sum = 0;
    int val = 0;
    while(temp_l1!= null && temp_l2!=null){
      sum = temp_l1.getData() + temp_l2.getData() + carry;
      val = sum % 10;
      carry = sum / 10;

      result.add(val);

      temp_l1 = temp_l1.getNext();
      temp_l2 = temp_l2.getNext();
    }

    if(temp_l1 != null){
      while(temp_l1 != null){
        sum = temp_l1.getData() + carry;
        val = sum % 10;
        carry = sum / 10;

        result.add(val);

        temp_l1 = temp_l1.getNext();
      }
    } else if (temp_l2 != null){
      while(temp_l2 != null){
        sum = temp_l2.getData() + carry;
        val = sum % 10;
        carry = sum / 10;

        result.add(val);

        temp_l2 = temp_l2.getNext();
      }
    }

    // if carry exists
    if(carry != 0){
      result.add(1);
    }
    return result;
  }
}
