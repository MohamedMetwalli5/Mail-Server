package eg.edu.alexu.csd.datastructure.mailServer;

class PQNode {
	private PQNode next,prev;
	private int key;
	private Object element;
	public PQNode(Object  e, final int k, PQNode n,PQNode p) {
		element = e;
		key = k;
		next = n;
		prev= p;
		    }
	/** Returns the element of this node */
	public Object getElement() {return element;}
	/** Returns the previous node of this node */
	public PQNode getPrev() {return prev;}
	/** Returns the next node of this node */
	public PQNode getNext() {return next;}
	/** Returns the key of this node */
	public int getkey() {return key;}
	/** Sets the element of this node */
	public void setElement(Object  newElem) {element = newElem;}
	/** Sets the previous node of this node */
	public void setPrev(PQNode newPrev) {prev = newPrev;}
	/** Sets the next node of this node */
	public void setNext(PQNode newNext) {next = newNext;}
	/** Sets the key of this node */
	public void setkey(int newkey) {key = newkey;}
}
public class PriorityQueue implements IPriorityQueue {
	/**
	 * head node .
	 */
	private PQNode head;
	/**
	 * tail node .
	 */
	private PQNode tail;
	/**
	 * size .
	 */
	private int size ;
    public PriorityQueue() {
		head=null;
		tail=null;
		size=0;
	}
	@Override
	public void insert(Object item, int key) {
		if (key <= 0) {
			throw new RuntimeException();
		}
		if (size == 0) {
			head = new PQNode(item, key, null,null);
			tail = head;
            size++;
		}else if (size>0) {
			PQNode node = new PQNode(item, key, null,null);
			PQNode temp=head;
			if(key<head.getkey()) {
				node.setNext(head);
				head.setPrev(node);
				head=node;
			}else if (key>tail.getkey()) {
				tail.setNext(node);
				node.setPrev(tail);
				tail=node;
			}
			else { 
				while (key > temp.getkey()) {
				temp=temp.getNext();
					}
				node.setNext(temp);
				node.setPrev(temp.getPrev());
				temp.getPrev().setNext(node);
				temp.setPrev(node);
			}
			size++;
	}}

	@Override
	public Object removeMin() {
		 if (size == 0) {
	            throw new RuntimeException("empty queue");
	        }
		 Object min=head.getElement();
		 head=head.getNext();
		 head.setPrev(null);
		return min;
	}

	@Override
	public Object min() {
		 if (size == 0) {
	            throw new RuntimeException("empty queue");
	        }
		 Object min=head.getElement();
		return min;
	}

	@Override
	public boolean isEmpty() {
		return (size==0);
	}

	@Override
	public int size() {
		return size;
	}

}
