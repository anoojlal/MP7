
public class Hangman {

	private word;
	private ArrayList<char> guessed;
	private char[] display;
	
	public Hangman(final String word) {
		this.word = word;
		guessed = new ArrayList<char>;
		display = new char[word.length()];
		Arrays.fill(display, '_');
	}
	
	public Hangman() {
		//random word
	}
	
}
