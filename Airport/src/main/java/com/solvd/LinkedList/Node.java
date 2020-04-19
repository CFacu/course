package com.solvd.LinkedList;

public class Node{
	Node previous;
	Node next;
	Integer element;
	
	public Node(Node previous, Node next, Integer element) {
		this.previous = previous;
		this.next = next;
		this.element = element;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Integer getElement() {
		return element;
	}

	public void setElement(Integer element) {
		this.element = element;
	}
}