/**
 * A program to search for to encrypt and decrypt lines of text. See
 * CaesarCipher.txt
 * Hints: line.charAt( int ) is useful.
 * You'll need loops, and conditions and variables
 * You'll need to read the Test cases to understand how your program should work.
 * Good Programming Hints: "DRY: Don't Repeat Yourself"
 * Try to make your program as short as possible.
 * TODO: add your netid to the line below
 * @author kevinc3
 */
public class CaesarCipher {

	public static void main(String[] strings) {
		
		int offset = 0;
		
		while ((offset == 0 || offset > 25 || offset<-25) && offset != 999 && offset != -999){
			TextIO.putln("Please enter the shift value (between -25..-1 and 1..25)");
			offset = TextIO.getlnInt();
			if ((offset == 0 || offset > 25 || offset<-25) && offset != 999 && offset != -999){
				System.out.println(offset + " is not a valid shift value.");
			}
			
		}
		
		if ((offset != 0 || offset < 25 || offset > -25) && offset != 999 && offset != -999){
		System.out.println("Using shift value of " + offset);
		}
		
		if (offset == 999 || offset == -999){
			System.out.println("Using position shift");
		}
		
		boolean loop = true;
		String sourceText;
		
		while(loop){
			TextIO.putln("Please enter the source text (empty line to quit)");
			sourceText = TextIO.getlnString();
			if (sourceText.equals("")){
				System.out.print("Bye.");
				loop = false;
			}
			else{
				System.out.println("Source   :" + sourceText);
				sourceText = sourceText.toUpperCase();
				String encrypted = "";
				for(int i = 0; i < sourceText.length(); i++)
					        {
					            int c = sourceText.charAt(i);
					            if (Character.isLetter(c)){
					            if (c != ' ' ){
					            	if (c >= 32 && c<= 127&& offset != 999 && offset != -999){
					            c = c + (offset % 26);
					                 if (c > 'Z'){
					                 c = c - 26;
					                 }
					                 if (c < 'A'){
					                	 c = c + 26;
					                 }
					            	}
					            	else if (offset == 999){
					            		for(int j=0;j<sourceText.length();j++){
					            		c = c + j;
					            		}
					            	}
					            	else if(offset == -999){
					            		for(int k=0;k<sourceText.length();k++){
					            		c = c - k;
					            		if (c > 'Z'){
							                 c = c - 26;
							                 }
							                 if (c < 'A'){
							                	 c = c + 26;
							                 }
					            		}
					            	}	
					            	}
					            }
					            
					        encrypted += (char) c;   
					        }
				sourceText = encrypted;
				System.out.println("Processed:" + sourceText);
				
				
				if (sourceText.equals("")){
				System.out.print("Bye.");
				loop = false;
				}
			}
		
		}	//end of while																
		
	}

}
