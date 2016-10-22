//@author kevinc3
public class Stack {
	private String[] stack = new String[1];
	private int size = 0;
	/** Adds a value to the top of the stack.*/
	public void push(String value){
		size++;
		String[] old = new String[size - 1];
		for (int i = 0; i < size-1; i++){
			old[i] = stack[i];
		}
		stack = new String[size];
		stack[0] = value;
		for (int i = 1; i<stack.length; i++){
			stack[i] = old[i-1];
		}
	}
	
	/** Removes the topmost string. If the stack is empty, returns null. */
	public String pop() {
		if (size == 0) return null;
		String last = stack[0];
		size--;
		String[] old = stack;
		for (int i = 0; i < size; i++){
			this.stack[i] = old[i+1];
		}
		return last;
	}
	
	/** Returns the topmost string but does not remove it. If the stack is empty, returns null. */
	public String peek() {
		return this.stack[0];
	}
	
	/** Returns true iff the stack is empty */
	public boolean isEmpty() {
		return size==0;
	}

	/** Returns the number of items in the stack. */
	public int length() {
		return size;
	}
	
	/** Returns a string representation of the stack. Each string is separated by a newline. Returns an empty string if the stack is empty. */
	public String toString() {
		String result = "";
		for (int i = this.size - 1; i >= 0; i--){
			result = result + this.stack[i] + "\n";
		}
		return result;
	}
}
