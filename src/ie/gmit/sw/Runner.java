package ie.gmit.sw;

import java.util.concurrent.*;

public class Runner {
	
	public static void main(String [] args) {
		BlockingQueue<Task> q = new ArrayBlockingQueue<>(5);
			Producer p = new Producer(q);
			Consumer c = new Consumer(q);
			new Thread(p).start();
			new Thread(c).start();	
	}
}
