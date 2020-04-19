package com.solvd.LinkedList;

public class Node<T>{
	Node<T> previous;
	Node<T> next;
	T element;
	
	public Node(Node<T> previous, Node<T> next, T element) {
		this.previous = previous;
		this.next = next;
		this.element = element;
	}

	public Node<T> getPrevious() {
		return previous;
	}

	public void setPrevious(Node<T> node) {
		this.previous = node;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}
}