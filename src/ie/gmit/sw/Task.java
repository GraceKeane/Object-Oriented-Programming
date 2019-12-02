//Task stores a number
//something tractable
package ie.gmit.sw;

public class Task {
	private int number;
	
	public Task(int number) {
		super();
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "Task [number = " + number + "]";
	}
}
