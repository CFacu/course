package com.solvd.LinkedList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
	
	private final static Logger LOGGER = LogManager.getLogger(Runner.class);

	public static void main(String[] args) {

		MyList<Integer> list = new MyList<Integer>();
		list.addElementAt(1, 1);
		list.addElementAt(2, 2);
		list.addElementAt(3, 3);
		list.addLast(9);
		list.addElementAt(8,4);
		list.addElementAt(4,4);
		list.addElementAt(5,5);
		list.addFirst(0);
		list.addElementAt(6,6);
		list.addElementAt(7,8);
		list.addLast(99);
		list.iterateForward();
		LOGGER.info(list.contains(89));
		list.get(83);
		list.remove(9);
		list.get(9);
	}

}
