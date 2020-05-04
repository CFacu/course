package com.solvd.connectionPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {

	private BlockingQueue<String> queue;
	private static final Integer SIZE = 3;
	private static ConnectionPool cp;
	
	private ConnectionPool() {
		queue = new LinkedBlockingQueue<String>(SIZE);
		init();
	}
	
	public void init() {
		for (int i = 0; i < SIZE; i++) {
			queue.add("Connection number " + i);
		}
	}
	
	public String getConnection() throws InterruptedException {
			return queue.take();
	}
	
	public void releaseConnection(String connection) {
		queue.offer(connection);
	}
	
	public static synchronized ConnectionPool getInstance() {
		if (cp == null)
			cp = new ConnectionPool(); 
		return cp;
	}

	public Integer getSize() {
		return SIZE;
	}
}
