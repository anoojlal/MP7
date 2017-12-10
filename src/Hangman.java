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
		System.out.println(display);
	}
	
}
