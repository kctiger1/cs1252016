import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

/**
 * A program to search for specific lines and print their line number.
 * See FindScriptLine.txt for more details
 * TODO: add your netid to the line below
 * @author kevinc3
 */
public class FindScriptLine {

	public static void main(String[] args) {
		
// TODO: Implement the functionality described in FindScriptLine.txt
// TODO: Test your code manually and using the automated unit tests in FindScriptLineTest		
		boolean output = false;
		String word = "";
		
		TextIO.putln("Please enter the word(s) to search for");
		word = TextIO.getln();
		

		
		TextIO.readFile("thematrix.txt");
		
		System.out.println("Searching for " + "'" + word + "'");
		word = word.toLowerCase();
		output = false;
		int counter = 0;
		while (false == TextIO.eof()){
			
			String line = TextIO.getln();
			counter++;
			
			if (line.isEmpty())
				output = false;
			
			if (line.indexOf(word) >= 0)
				output = true;				
			
			if (output){
				line = line.trim();
				if (line.contains(word))
					TextIO.putln(counter + " - " + line);					
				
					
			}
			
		}
		System.out.println("Done Searching for " + "'" + word + "'");
	
	}
}
