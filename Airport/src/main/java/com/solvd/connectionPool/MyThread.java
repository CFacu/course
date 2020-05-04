package com.solvd.connectionPool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyThread implements Runnable{
	
	private final static Logger LOGGER = LogManager.getLogger(MyThread.class);

	private Integer number;
	private ConnectionPool cp;
	
	public MyThread(Integer number, ConnectionPool cp) {
		this.number = number;
		this.cp = cp;
	}
	
	@Override
	public synchronized void run() {
		String connection = null;
		try {
			connection = cp.getConnection();
		} catch (InterruptedException e) {
			LOGGER.error("No connection available");
		}
		LOGGER.info("Thread " + number + " assigned at " + connection);
		try {
			wait(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cp.releaseConnection(connection);

	}

}
