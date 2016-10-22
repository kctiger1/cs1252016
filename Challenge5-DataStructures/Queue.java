//@author kevinc3
public class Queue {
	private double[] queue = new double[0];
	private int size = 0;
	/** Adds the value to the front of the queue.
	 * Note the queue automatically resizes as more items are added. */
	public void add(double value) {
		size ++;
		double[] old = queue;
		queue = new double[size];
		queue[0] = value;
		for (int i = 1; i < queue.length; i++){
			queue[i] = old[i-1];
		}
	}
	/** Removes the value from the end of the queue. If the queue is empty, returns 0 */
	public double remove() {
		if (size == 0){
			return 0.0;
		}
		size --;
		double[] old = queue;
		for (int i = 0; i < size; i++){
			queue[i] = old[i];
		}
		return queue[size];
	}
	
	/** Returns the number of items in the queue. */
	public int length() {
		return size;
	}
	
	/** Returns true iff the queue is empty */
	public boolean isEmpty() {
		if(size == 0){
			return true;
		}
		return false;
	}
	
	/** Returns a comma separated string representation of the queue. */
	public String toString() {
		String result = "";
		result = result + this.queue[this.size-1];
		for (int i = this.size - 2; i >= 0; i--){
			result = result + "," + this.queue[i];
		}
		return result;
	}
}
