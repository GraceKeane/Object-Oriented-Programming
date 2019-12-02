//Responsible for adding to the queue
package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue<Task> queue;

	public Producer(BlockingQueue<Task> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		int counter = 0;
			while (counter < 100) {
				Task t = new Task(counter);
			
				try {
					System.out.println("Added ->" + t);
					queue.put(t); //Put method blocks 
				}catch (InterruptedException e) {
				e.printStackTrace();
			}
			counter++;
		}
			
		try {
			queue.put(new Poison(-1)); //Poison the blocking queue
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
