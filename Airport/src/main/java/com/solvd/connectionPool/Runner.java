package com.solvd.connectionPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

	public static void main(String[] args) throws InterruptedException {

	
		ConnectionPool cp = ConnectionPool.getInstance();
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
		 for (int i = 1; i <= 5; i++) 
	        {
	            MyThread thread = new MyThread(i, cp);	 
	            executor.execute(thread);
	        }
	        executor.shutdown();
		}
	

}
