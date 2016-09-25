/**
 * Prints sum of odd numbers in a specific format.
 * TODO: add your netid to the line below
 * @author kevinc3
 */
public class OddSum { 
/**
Example output if user enters 10:
Max?
1 + 3 + 5 + 7 + 9 = 25
25 = 9 + 7 + 5 + 3 + 1

Example output if user enters 11:
Max?
1 + 3 + 5 + 7 + 9 + 11 = 36
36 = 11 + 9 + 7 + 5 + 3 + 1

 */
 public static void main(String[] args) { 
	 int input = 0;
	 TextIO.putln("Max?");
	 input = TextIO.getlnInt();
	 int odd = 0;
	 int add;
	 int sum = 0;
	 for (;odd<=input;odd++){
		 if (odd == 1){
			 TextIO.put("1");
		 }
		 if (odd % 2 == 1 && odd > 1){
	 		add = odd;
	 		sum += add;
	 		
	 		TextIO.put(" + " + add);
	 		
	 	
	 }
		 
	 }
	 sum += 1;
	 TextIO.putln(" = " + sum);
	 TextIO.put(sum + " = ");
	 for(;odd != 1;){
		 if (odd %2 == 1){
			 odd-=2;
			 if (odd != 1){
			 TextIO.put(odd + " + ");
			 }
		 }
		 if (odd%2 != 1){
			odd--;
			TextIO.put(odd + " + ");
		 }
		 
	 }
	 
	
	 System.out.println(odd); 
	 
	 
  } // end of main method
} // end of class 
