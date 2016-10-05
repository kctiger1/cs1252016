/**
 * Add you netid here..
 * 
 * @author kevinc3
 *
 */
public class PlayListUtil {

	/**
	 * Debug ME! Use the unit tests to reverse engineer how this method should
	 * work. Hint: Fix the formatting (shift-cmd-F) to help debug the following
	 * code
	 * 
	 * @param list
	 * @param maximum
	 */
	public static void list(String[] list, int maximum) {
		int i;
		for (i = 0; (i<list.length && maximum ==-1) || i<maximum;i++)
		{
			TextIO.putln("" + (i+1) + ". " + list[i]);
		}
	}

	/**
	 * Appends or prepends the title
	 * 
	 * @param list
	 * @param title
	 * @param prepend
	 *            if true, prepend the title otherwise append the title
	 * @return a new list with the title prepended or appended to the original
	 *         list
	 */
	public static String[] add(String[] list, String title, boolean prepend) {
		int appendedLength = list.length + 1;
		String[] appended = new String[appendedLength];
		if (prepend){
			appended[0] = title;
			for (int i = 1; i < appendedLength;i++){
				appended[i] = list[i-1];
			}
		}
		else{
			for (int j = 0; j < appendedLength-1; j++){
				appended[j] = list[j];
			}
			appended[appendedLength - 1] = title;
		}
		return appended;
	}

	/**
	 * Returns a new list with the element at index removed.
	 * 
	 * @param list
	 *            the original list
	 * @param index
	 *            the array index to remove.
	 * @return a new list with the String at position 'index', absent.
	 */
	public static String[] discard(String[] list, int index) {
		int discardLength = list.length - 1;
		String[] discard = new String[discardLength];
		for(int i = 0; i < discardLength; i++){
			discard[i] = list[i];
		}
		for (int i = index + 1; i < discardLength+1; i++){
			discard[i-1] = list[i];
		}
		return discard;
	}

}
