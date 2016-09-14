/**
 * A program to run a simple survey and report the results. See MovieSurvey.txt
 * for more information. TODO: add your netid to the line below
 * 
 * @author kevinc3
 */
public class MovieSurvey {
	public static void main(String[] arg) {
		// TODO: Write your program here
		
		//INTRO LINES
		System.out.println("Welcome. We're interested in how people are watching movies this year.");
		System.out.println("Thanks for your time. - The WRITERS GUILD OF AMERICA.");
		System.out.println("Please tell us about how you've watched movies in the last month.");
		//ask for 3 quantities: number of movies watched at 1.cinema 2.dvd player 3.computer
		int cinemaMovies;
			System.out.println("How many movies have you seen at the cinema?");
			cinemaMovies = TextIO.getlnInt();
		int dvdPlayer;
			System.out.println("How many movies have you seen using a DVD or VHS player?");
			dvdPlayer = TextIO.getlnInt();
		int computerMovie;
				System.out.println("How many movies have you seen using a Computer?");
				computerMovie = TextIO.getlnInt();
		//print summary of input values
		System.out.println("Summary: " + cinemaMovies + " Cinema movies, " + dvdPlayer + " DVD/VHS movies, " + computerMovie + " Computer movies");
		//print out total movies watched in one month
		int total = cinemaMovies + dvdPlayer + computerMovie;
			System.out.println("Total: " + total + " movies");
		//print out percent of movies watched at cinema--2decimal places
		float percentCinema = (float)((cinemaMovies*100.00f)/total);
			System.out.print("Fraction of movies seen at a cinema: ");
			TextIO.putf("%.2f", percentCinema);
			System.out.print("%\n");
		//print out percent of movies watched outside of cinema--2decimal places
		float percentNotCinema = (float)(((dvdPlayer + computerMovie)*100.00f)/total);
			System.out.print("Fraction of movies seen outside of a cinema: ");
			TextIO.putf("%.2f",  percentNotCinema);
			System.out.print("%");
		
		// Hints :
		// Formatted output
		// http://math.hws.edu/javanotes/c2/s4.html#basics.4.4
		
		// Don't just copy paste the expected output
		// For grading purposes your code may be tested
		// with other input values.
	}
}
