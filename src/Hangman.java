import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Play a game of Hangman right from your Java console! Have the option of either guessing a 
 * word of your choice, or a randomly generated word from a list of over 300,000. Enjoy!
 * 
 * @author Anooj Lal (anoojl2)
 * @author Thomas Yang (thomasy4)
 **/
public class Hangman {

	/**
	 * The secret word that the player must guess each letter.
	 **/
	private String word;
	
	/**
	 * An ArrayList of each letter the player has guessed so far.
	 **/
	private ArrayList<Character> guessed= new ArrayList<Character>();
	
	/**
	 * The blank tiles and correctly guessed letters of the secret 
	 * word displayed to the player.
	 **/
	private char[] display;
	
	/**
	 * The number of wrong guesses a player is allowed to make per game.
	 **/
	private int wrongGuesses = 4;
	
	/**
	 * Scanner object to read user input.
	 **/
	private Scanner input = new Scanner(System.in);
	
	/**
	 * Create a Hangman game with a word of your choice. If the inputed word is empty or consists 
	 * of non-letter characters, then a random word will be generated instead.
	 * 
	 * @param word - a word of your choice
	 **/
	public Hangman(final String word) {
		if (word.isEmpty()) {
			System.out.println("Inputted empty word. Generating random word instead.");
			this.word = generateRandomWord().toUpperCase();
			display = new char[this.word.length()];
			Arrays.fill(display, '_');
			return;
		}
		for (int i = 0; i < word.length(); i++) {
			if (!Character.isLetter(word.charAt(i))) {
				System.out.println("Inputted word consisted of non-letter characters. Generating random word instead.");
				this.word = generateRandomWord().toUpperCase();
				display = new char[this.word.length()];
				Arrays.fill(display, '_');
				return;
			}
		}
		this.word = word.toUpperCase();
		display = new char[word.length()];
		Arrays.fill(display, '_');
	}
	
	/**
	 * Create a game of Hangman with a randomly generated word.
	 **/
	public Hangman() {
		System.out.println("Generating random word.");
		word = generateRandomWord().toUpperCase();
		display = new char[word.length()];
		Arrays.fill(display, '_');
	}
	
	/**
	 * Generates a random word from a .txt file of words.
	 * 
	 * @return a random word
	 **/
	private String generateRandomWord() {
		ArrayList<String> words = new ArrayList<String>();
        BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("words.txt"));
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
                words.add(sCurrentLine);
            }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Random rand = new Random();
        String randomWord;
        do {
        	randomWord = words.get(rand.nextInt(370098)).toUpperCase();
        } while (randomWord.length() < 4 || randomWord.length() >= 7);
        return randomWord;
	}
	
	/**
	 * Calling this instance method on your Hangman object will start the game. Enjoy!
	 **/
	public void play() {
		while (!isWinner() && wrongGuesses > 0) {
			draw();
			guess();
		}
		draw();
		replay();
	}
	
	/**
	 * Determines whether the player has successfully guessed each letter of the secret word.
	 * 
	 * @return true if the player has won, false if the player has yet to win or lose
	 **/
	private boolean isWinner() {
		if (Arrays.equals(display, word.toCharArray())) {
			// finish this
			return true;
		}
		return false;
	}
	
	/**
	 * Draws the Hangman game in the console, which includes the letters the player has guessed 
	 * so far, the noose and Hangman body parts, and the display.
	 **/
	private void draw() {
		if (!isWinner()) {
			System.out.print("\nGuessed letters: ");
			for (int letter = 0; letter < guessed.size(); letter++) {
				System.out.print(guessed.get(letter) + " ");
			}
			System.out.println();
			switch (wrongGuesses) {
				case 4:
					System.out.println("_______");
					System.out.println("|/    |");
					System.out.println("|");
					System.out.println("|");
					System.out.println("|");
					System.out.println("|");
					System.out.println("|_________");
					break;
				case 3:
					System.out.println("_______");
					System.out.println("|/    |");
					System.out.println("|   (\'-\')");
					System.out.println("|");
					System.out.println("|");
					System.out.println("|");
					System.out.println("|_________");
					break;
				case 2:
					System.out.println("_______");
					System.out.println("|/    |");
					System.out.println("|   (\'-\')");
					System.out.println("|     |");
					System.out.println("|     |");
					System.out.println("|");
					System.out.println("|_________");
					break;
				case 1:
					System.out.println("_______");
					System.out.println("|/    |");
					System.out.println("|   (\'-\')");
					System.out.println("|   __|__");
					System.out.println("|     |");
					System.out.println("|");
					System.out.println("|_________");
					break;
				case 0:
					System.out.println("_______   You lost... Yikes!");
					System.out.println("|/    |  /");
					System.out.println("|   (x-x)");
					System.out.println("|   __|__");
					System.out.println("|     |");
					System.out.println("|    / \\");
					System.out.println("|_________");
					break;
				default:
					System.out.println("Something went wrong...");
					break;
			}
		} else {
			System.out.println("_______");
			System.out.println("|/    |         You guessed the word! Awesome job.");
			System.out.println("|              /");
			System.out.println("|         ('u')");
			System.out.println("|         ~~|~~");
			System.out.println("|           |");
			System.out.println("|_________ / \\");
		}
		if (wrongGuesses == 0) {
			for (int i = 0; i < word.length(); i++) {
				System.out.print(word.charAt(i) + " ");
			}
			System.out.println();
		} else {
			for (int i = 0; i < display.length; i++) {
				System.out.print(display[i] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Prompts the player to guess a letter. Ensures that the user input is a single letter 
	 * and updates the display accordingly.
	 **/
	private void guess() {
		System.out.print("Guess a letter: ");
		String guess = input.nextLine().toUpperCase();
		if (guess.length() == 1) {
			if (guessed.contains(guess.charAt(0))) {
				System.out.println("Already guessed " + guess.charAt(0) + ". Try again.");
				guess();
			} else if (Character.isLetter(guess.charAt(0))) {
				boolean correct = false;
				for (int index = 0; index < word.length(); index++) {
					if (word.charAt(index) == guess.charAt(0)) {
						display[index] = guess.charAt(0);
						correct = true;
					}
				}
				guessed.add(guess.charAt(0));
				if (!correct) {
					wrongGuesses--;
				}
			}
		} else {
			System.out.println("Must guess a single letter. Try again.");
			guess();
		}
	}
	
	/**
	 * Gives the option for the player to replay after completing a game. Generates a random 
	 * word for the next game.
	 **/
	private void replay() {
		System.out.print("Would you like to play again? (Y/N): ");
		String answer = input.nextLine().toUpperCase();
		if (answer.length() == 1) {
			if (answer.charAt(0) == 'Y') {
				System.out.println("\nGenerating random word.");
				guessed= new ArrayList<Character>();
				wrongGuesses = 4;
				word = generateRandomWord().toUpperCase();
				display = new char[word.length()];
				Arrays.fill(display, '_');
				play();
			} else if (answer.charAt(0) == 'N') {
				System.out.println("\nThanks for playing!");
			} else {
				System.out.println("Please input either 'Y' for Yes and 'N' for No.");
				replay();
			}
		} else {
			System.out.println("Please input either 'Y' for Yes and 'N' for No.");
			replay();
		}
	}
}