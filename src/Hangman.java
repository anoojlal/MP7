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
		String inp = input.next();
		if (inp.length() == 1 && Character.isLetter(inp.charAt(0))) {
			char guess = inp.charAt(0);
			for (int index = 0; index < word.length(); index++) {
				if (word.charAt(index) == guess) {
					display[index] = guess;
					guessed.add(guess);
				} else {
					guessed.add(guess);
					wrongGuesses -= 1;
				}
			}
		} else {
			System.out.print("Invalid guess. Try again.");
			guess();
		}		
	}
	
	// Draw the hangman based on how many guesses player took
	public void draw() {
		
	}
	
	// Checks if player successfully guessed word
	public boolean isWinner() {
		return false;
	}
	
}
