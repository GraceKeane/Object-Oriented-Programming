//Responsible for removing from the queue
package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private BlockingQueue<Task> queue;
	private volatile boolean keepRunning = true;
	
	public Consumer(BlockingQueue<Task> queue) {
		super();
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while (keepRunning) {
			try {
				Task t = (queue.take()); //Blocking method. Don't call remove() or poll()  
				
				if(t instanceof Poison) 
				{
					keepRunning = false;
					System.out.println("Queue poisoned->" + t);
				}
				
				System.out.println("Removing " + t);
				
				} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
