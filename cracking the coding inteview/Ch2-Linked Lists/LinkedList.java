public class LinkedList<E>{

    private Node<E> head ;			// first node of linked list

    private Node<E> tail;			// last node of linked list

    private int size;				// size of linked list

    // constructor of LinkedList class
    public LinkedList(){
    	head = null;
    	tail = null;
    	size = 0;
    }

    // adding new node to end of te linked list
    public void add(E data){
    	Node<E> element = new Node(data,null);
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
    public void remove(E data){
    	Node<E> tempNode;
    	if(head.getData().equals(data)){
    		// removing the head
    		tempNode = head.getNext();
    		head.setNext(null);
    		head = tempNode;
    	} else if(tail.getData().equals(data)){
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
    		Node<E> tempNodeNext = head.getNext();
    		while(!tempNodeNext.getData().equals(data)){
    			tempNode = tempNode.getNext();
    			tempNodeNext = tempNodeNext.getNext();
    		}
    		tempNode.setNext(tempNodeNext.getNext());
    	}

    	size--;
    }

    // displaying the content of linked list
    public void printList(){
    	String content = "";
    	Node<E> tempNode = head;
    	while(tempNode != null){
    		if(tempNode == tail){
    			content += tempNode.getData().toString();
    		} else{
    			content += tempNode.getData().toString() + " -> ";
			}
			tempNode = tempNode.getNext();
    	}
    	System.out.println(content);
    }

	// getter and setter methods for instance variables
	public void setHead(Node<E> head){
		this.head = head;
	}

	public Node<E> getHead(){
		return head;
	}

	public void setTail(Node<E> tail){
		this.tail = tail;
	}

	public Node<E> getTail(){
		return tail;
	}

	public int getSize(){
		return size;
	}
}