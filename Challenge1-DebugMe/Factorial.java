
/**
 * A program to calculate a factorial. The given code may contain errors. Fix the
 * given code and add additional code to calculate a factorial and pass the unit
 * tests. Hint sometimes an 'int' just 'aint big enough.
 * 
 * @see Factorial-ReadMe.txt for details on how to complete this program.
 * @author kevinc3
 */
public class Factorial {
	public static void main(String[] args) {
		long max = 0;
		System.out.println("Enter a number between 1 and 20 inclusive.");
		while (max < 1 || max >= 21) {
			max = TextIO.getlnInt();
		}
		long i = 1, given = 1;
		while (max != i ++){
			given = given*i;
		}
		TextIO.putln(given);
	}
}
