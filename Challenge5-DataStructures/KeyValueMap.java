//@author kevinc3
import java.awt.Color;

public class KeyValueMap { // aka Dictionary or Map
	private String[] string1 = new String [0];
	private int size = 0;
	private Color[] color = new Color[0];
	/**
	 * Adds a key and value. If the key already exists, it replaces the original
	 * entry.
	 */
	public void add(String key, Color value) {
		size++;
		String[] old = string1;
		string1 = new String[size];
		string1[0] = key;
		for (int i = 1; i < string1.length; i++){
			string1[i] = old[i-1];
		}
		Color[] old2 = color;
		color = new Color[size];
		color[0] = value;
		for (int i = 1; i< color.length; i++){
			color[i] = old2[i-1];
		}
	}

	/**
	 * Returns particular Color object previously added to this map.
	 */
	public Color find(String key) {
		for (int i = 0; i< size; i++){
			if(key.equals(string1[i])){
				return color[i];
			}
		}
		return null;
	}

	/**
	 * Returns true if the key exists in this map.
	 */
	public boolean exists(String key) {
		for (int i = 0; i < size; i++) {
			if (key.equals(string1[i])){
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes the key (and the color) from this map.
	 */
	public void remove(String key) {
		int found = 0;
		for (int i = 0; i < size; i++){
			if (key.equals(string1[i])){
				found = i;
			}
		}
		size--;
		String[] old = string1;
		string1 = new String[size];
		for (int i = 0; i < found; i++) {
			string1[i] = old[i];
		}
		for (int i = found+1; i < size; i++) {
			string1[i-1] = old[i];
		} 	
	}

}
