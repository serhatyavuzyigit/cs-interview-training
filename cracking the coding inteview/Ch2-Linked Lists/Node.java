public class Node{

	    private int data;				// The data that node stores.

        private Node next;		// The address of next node


       	// constructor for Node class
        public Node(int data, Node next) {
        	this.data = data;
        	this.next = next;
        }

        // getter and setter methods for instance variables
        public void setData(int data){
        	this.data = data;
        }

        public int getData(){
        	return data;
        }

        public void setNext(Node next){
        	this.next = next;
        }

        public Node getNext(){
        	return next;
        }

}
