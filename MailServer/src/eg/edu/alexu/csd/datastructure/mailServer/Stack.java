package eg.edu.alexu.csd.datastructure.mailServer;


public class Stack {
    DNode  head = new DNode(null, null, null);
    //DNode  tail = new DNode(null, head, null);
    //head.setNext(tail);
    private DNode top;
    private int size;
    public Stack() {
		top=head;
		size=0;
	}
    /**
	* Removes the element at the top of stack and returns that element.
	* *
	@return top of stack element, or through exception if empty
	*/
	
	public Object pop() {
		if (isEmpty()) {
			throw new RuntimeException("Empty Stack");
		}
		Object temp = top.getElement();
		top=top.getNext();
		size--;
		return temp;
	}
	/**
	* Get the element at the top of stack without removing it from stack.
	* *
	@return top of stack element, or through exception if empty
	*/
	
	public Object peek() {
		if (isEmpty()) {
			throw new RuntimeException("Empty Stack");
		}
		return top.getElement();
	}
	/**
	* Pushes an item onto the top of this stack.
	* *
	@param object
	* to insert
	*/
	
	public void push(Object element) {
		DNode temp=new DNode(element, null, top);
		top=temp;
		size++;
	}
	/**
	* Tests if this stack is empty
	* *
	@return true if stack empty
	*/
	
	public boolean isEmpty() {
		return (size==0);
	}
	/**
	* Returns the number of elements in the stack.
	* *
	@return number of elements in the stack
	*/
	
	public int size() {
		
		return size;
	}

}

