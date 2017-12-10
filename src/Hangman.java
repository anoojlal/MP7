import java.util.ArrayList;
import java.util.Arrays;

public class Hangman {

	private String word;
	private ArrayList<Character> guessed;
	private static char[] display;
	
	public Hangman(final String word) {
		this.word = word;
		guessed = new ArrayList<Character>();
		display = new char[word.length()];
		Arrays.fill(display, '_');
	}
	
	public Hangman() {
		//random word
	}
	
	public static void play() {
		System.out.println("asdasd");
	}
	
	// Prompt the user for letter. Keep prompting until user inputs single letter
	public void guess() {
		
	}
	
	// Draw the hangman based on how many guesses player took
	public void draw() {
		
	}
	
	// Checks if player successfully guessed word
	public boolean isWinner() {
		return false;
	}
	
}