import java.util.Arrays;

/**
 * See CipherBreaker.txt for instructions.
 * TODO: add your netid to the line below
 * 
 * @author kevinc3
 */
public class CipherBreaker {

	public static void main(String[] args) {
		TextIO.putln("Text?");
		String line = TextIO.getln();
		TextIO.putln(line);
		line = line.toUpperCase();
		
		char[] cipher = line.toCharArray();
		int s=0,f=-1;
		Arrays.sort(cipher);
		int space = 0, punc = 0, digit = 0;
		
		for (int i = 0; i< line.length(); i++){		//initial for
			for (int j = 0; j<line.length();j++){	//frequency
				if(cipher[i] == cipher[j])
					s++;
			}	//end frequency for
			for (int k = 0; k<i;k++){	//check duplicates
			if(cipher[i]==cipher[k])
				f = 1;
			}	//end duplicate for
			
			if(f==-1 && cipher[i]>=65 && cipher[i]<=90){
			   System.out.println(cipher[i] +":" + s);
			}
			  
			  if (cipher[i] == ' '){
				 space +=1;
			 }
			  if (cipher[i] == '"' || cipher[i] == '\'' || cipher[i] == '.' || cipher[i] == '-' || cipher[i] == '!' || cipher[i] == ','){
					 punc +=1;
				 }
			  if (cipher[i]>=48 && cipher[i]<=57){
				  digit +=1;
			  }
			 
			 
			  s=0;
			  f=-1;
			
			
		}	//end initial for
		if (digit != 0){
			System.out.println("DIGITS" + ":" + digit);
		}
		if (space != 0)	{
			System.out.println("SPACES" +  ":" + space);
		}
		if (punc != 0){
			System.out.println("PUNCTUATION" +  ":" + punc);
		}
		
			// Print the letter's frequency
		  /*if(f==-1 && line.charAt(i) != ' ' && line.charAt(i) != '"' && line.charAt(i) != '.' && line.charAt(i) != '-' && line.charAt(i) != '!' && line.charAt(i) != ',' 
				  && line.charAt(i) != '\'')
		   System.out.println(line.charAt(i) +":" + s);
		  
		  if (line.charAt(i) == ' '){
			 System.out.println("SPACES" +  ":" + s);
		 }
		  if (line.charAt(i) == '"' || line.charAt(i) == '\'' || line.charAt(i) == '.' || line.charAt(i) == '-' || line.charAt(i) == '!' || line.charAt(i) == ','){
				 System.out.println("PUNCTUATION" +  ":" + s);
			 }
		  if (Character.isDigit(i)){
			  System.out.println("DIGITS" + ":" + s);
		  }
		 
		  s=0;
		  f=-1;
		 
		}*/
	}
}