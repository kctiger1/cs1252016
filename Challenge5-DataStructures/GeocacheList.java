/**
 * Complete the following GeocacheList, to ensure all unit tests pass.
 * There are several errors in the code below
 *
 * Hint: Get the Geocache class working and passing its tests first.
 * @author kevinc3
 */
public class GeocacheList {
	private Geocache[] data = new Geocache[0];
	private int size = 0;

	public Geocache getGeocache(int i) {
		return data[i];
	}

	public int getSize() {
		return size;
	}

	public GeocacheList() {
	}

	public GeocacheList(GeocacheList other, boolean deepCopy) {
		if (deepCopy){
			for (int i = 0; i < other.data.length; i++){
				add(other.data[i]);
				data[i] = new Geocache(other.data[i].getX(), other.data[i].getY());
			}
		}
		else {
			for (int j = 0; j < other.data.length; j++){
				add(other.data[j]);
				data[j].setX(other.data[j].getX());
				data[j].setY(other.data[j].getY());
			}
		}
		size = other.getSize();
	}

	public void add(Geocache p) {
		size++;
		if (size > data.length) {
			Geocache[] old = data;
			data = new Geocache[size * 2];
			for (int i = 0; i < old.length; i++)
				data[i] = old[i];
		}
		data[size-1] = p;
	}

	public GeocacheList removeFromTop() {
		this.size--;
		GeocacheList result = new GeocacheList();
		for (int i = 0; i < result.getSize(); i++){
			result.data[i] = this.data[i+1];
		}
		return result;
	}

	public String toString() {
		StringBuffer s = new StringBuffer("GeocacheList:");
		for (int i = 0; i < size; i++) {
			if (i > 0)
				s.append(',');
			s.append(data[i]);
		}
		return s.toString();
	}
}