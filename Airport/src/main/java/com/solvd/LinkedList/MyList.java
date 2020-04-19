package com.solvd.LinkedList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyList {
	
	private final static Logger LOGGER = LogManager.getLogger(MyList.class);

	private Node first;
	private Node last;
	private Integer size;
	
	public MyList() {
		this.size = 0;
		this.first = null;
		this.last = null;
	}
	
	public Integer getSize() {
		return this.size;
	}
	
	public boolean isEmpty() {
		if (this.size == 0)
			return true;
		return false;
	}
	
	public void addFirst(Integer element) {
		Node n;
		if (!this.isEmpty()) {
			n = new Node(null, this.first, element);
			this.first.setPrevious(n);
		}
		else {
			n = new Node(null, null, element);
			this.last= n;
		}
		this.first = n;
		this.size += 1;
		LOGGER.info("Element " + n.getElement() + " added at top of the list");
	};
	
	public void addLast(Integer element) {
		Node n;
		if (!this.isEmpty()) {
			n = new Node(this.last, null, element);
			this.last.setNext(n);
		}
		else {
			n = new Node(null, null, element);
			this.first = n;
		}
		this.last = n;
		this.size += 1;
		LOGGER.info("Element " + n.getElement() + " added at end of the list");

	};
	
	public void addElementAt(Integer element, Integer pos){
		Node n = new Node(null, null, element);
		if (pos == this.size + 1) {
			addLast(element);
		}
		else
			if (pos == 1) {
				addFirst(element);	
			}
			else
				if (pos <= this.size) {
					Node temp = this.first;
					Integer count = 1;
					while (count < pos) {
						temp =  temp.getNext();
						count ++;
					}
					n.setNext(temp);
					n.setPrevious(temp.previous);
					n.getPrevious().setNext(n);
					temp.setPrevious(n);
					this.size ++;
					LOGGER.info("Element " + n.getElement() + " added at position " + pos);
				}					
		};
			
	public void iterateForward() {
		Node temp = this.first;
		while (temp != null) {
			LOGGER.info("Element " + temp.getElement());
			temp =  temp.getNext();
		}
	};
	
	public void iterateBackward() {
		Node temp = this.last;
		while (temp != null) {
			LOGGER.info("Element " + temp.getElement());
			temp = temp.getPrevious();
		}
	};
	
	public boolean contains(Integer element) {
		Node temp = this.first;
		while (temp != null) {
			if (temp.element == element)
				return true;
			temp =  temp.getNext();
		}
		return false;
	}
	
	public Integer get(Integer position) {
		if (position <= this.size) {			
			Integer counter = 0;
			Node temp = this.first;
			while (counter < position) {
				temp =  temp.getNext();
				counter ++;
			}
			LOGGER.info("Element at position "+ position + ": " + temp.getElement());
			return temp.getElement();
		}
		else {
			LOGGER.error("Position "+ position +" out of range.");
			return position;
		}
	}
	
	public void remove(Integer position) {
		if (position <= this.size) {			
			Integer counter = 0;
			Node temp = this.first;
			while (counter < position) {
				temp =  temp.getNext();
				counter ++;
			}
			temp.getPrevious().setNext(temp.getNext());
			temp.getNext().setPrevious(temp.getPrevious());
			LOGGER.info("Element at position " + position + " removed");
		}
		else
			LOGGER.error("Position "+ position +" out of range.");
	}
	
	public Node getFirst() {
		return first;
	}

	public Node getLast() {
		return last;
	}

}
