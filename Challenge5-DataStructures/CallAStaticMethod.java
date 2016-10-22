/**
 * Prints out only lines that contain an email address Each printed line is
 * justified to right by prepending the text with '.' characters The minimum
 * width of the line including padding is 40 characters. See the test case for
 * example input and expected output.
 * @author kevinc3
 */
class CallAStaticMethod {

	public static void main(String[] args) {

		while (!TextIO.eof()) {
			String line = TextIO.getln();
			if (ExampleClassMethods.isEmailAddress(line)){
				int dots = 40 - line.length();
				for (int i = dots; i>0; i--){
					System.out.print(".");
				}
				System.out.println(line);
			}
			// Use ExampleClassMethods
			// 'isEmailAddress' and 'createPadding' to complete this method
		}
	}
}
