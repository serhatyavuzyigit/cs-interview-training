
public class LinkedList{

    private Node head ;			// first node of linked list

    private Node tail;			// last node of linked list

    private int size;				// size of linked list

    // constructor of LinkedList class
    public LinkedList(){
    	head = null;
    	tail = null;
    	size = 0;
    }

    // adding new node to end of te linked list
    public void add(int data){
    	Node element = new Node(data,null);
    	if(size == 0){
    		head = element;
    		tail = element;
    		head.setNext(null);
    		tail.setNext(null);
    		size++;
    	} else{
    		tail.setNext(element);
    		tail = element;
    		size++;
    	}

    }

    // removing the node from linked list with given data
    public void remove(int data){
    	Node tempNode;
    	if(head.getData() == data){
    		// removing the head
    		tempNode = head.getNext();
    		head.setNext(null);
    		head = tempNode;
    	} else if(tail.getData() == data){
    		// removing the tail
    		tempNode = head;
    		while(tempNode.getNext() != tail){
    			tempNode = tempNode.getNext();
    		}
    		tempNode.setNext(null);
    		tail = tempNode;
    	} else{
    		// removing the node from somewhere that is not head and tail
    		tempNode = head;
    		Node tempNodeNext = head.getNext();
    		while(tempNodeNext.getData() != data){
    			tempNode = tempNode.getNext();
    			tempNodeNext = tempNodeNext.getNext();
    		}
    		tempNode.setNext(tempNodeNext.getNext());
    	}

    	size--;
    }
/*
    // returns the last k'th element from list
    public int returnKthToLast(int k){
      Node p1 = head;
      Node p2 = head;

      for(int i=0;i<k;i++){
        p1 = p1.getNext();
      }

      while(p1 != null){
        p1 = p1.getNext();
        p2 = p2.getNext();
      }

      return p2.getData();
    }
*/
    // displaying the content of linked list
    public void printList(){
    	String content = "";
    	Node tempNode = head;
    	while(tempNode != null){
    		if(tempNode == tail){
    			content += tempNode.getData() + "";
    		} else{
    			content += tempNode.getData() + " -> ";
			}
			tempNode = tempNode.getNext();
    	}
    	System.out.println(content);
    }


  	// getter and setter methods for instance variables
  	public void setHead(Node head){
  		this.head = head;
  	}

  	public Node getHead(){
  		return head;
  	}

  	public void setTail(Node tail){
  		this.tail = tail;
  	}

  	public Node getTail(){
  		return tail;
  	}

  	public int getSize(){
  		return size;
  	}
}
