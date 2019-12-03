public class Node<E>{

	    private E data;				// The data that node stores.

        private Node<E> next;		// The address of next node 


       	// constructor for Node class
        public Node(E data, Node<E> next) {
        	this.data = data;
        	this.next = next;
        }

        // getter and setter methods for instance variables
        public void setData(E data){
        	this.data = data;
        }

        public E getData(){
        	return data;
        }

        public void setNext(Node<E> next){
        	this.next = next;
        }

        public Node<E> getNext(){
        	return next;
        }

        // toString for displaying the data in node
        public String toString(){
        	return data.toString();
        }
}