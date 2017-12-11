import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

	private String word;
	private ArrayList<Character> guessed;
	private char[] display;
	private int wrongGuesses = 4;
	
	private Scanner input = new Scanner(System.in);
	
	public Hangman(final String word) {
		this.word = word.toUpperCase();
		guessed = new ArrayList<Character>();
		display = new char[word.length()];
		Arrays.fill(display, '_');
	}
	
	public Hangman() {
		//random word

        ArrayList<String> arr = new ArrayList<String>();
        BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("words.txt"));
			
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                arr.add(sCurrentLine);
            }

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		Random rand = new Random();
		
		
		 this.word = arr.get(rand.nextInt(370098)).toUpperCase();
		 guessed = new ArrayList<Character>();
		 display = new char[word.length()];
		 Arrays.fill(display, '_');
	}
	
	public void play() {
		while (!isWinner()) {
			draw();
			guess();
		}
	}
	
	// Prompt the user for letter. Keep prompting until user inputs single letter
	private void guess() {
		System.out.print("Guess a letter: ");
		String inp = input.nextLine().toUpperCase();
		if (inp.length() == 1 && guessed.contains(inp.charAt(0))) {
			System.out.println("Already guessed " + inp.charAt(0) + ". Try again.");
			guess();
		} else if (inp.length() == 1 && Character.isLetter(inp.charAt(0))) {
			char guess = inp.toUpperCase().charAt(0);
			boolean correct = false;
			for (int index = 0; index < word.length(); index++) {
				if (word.charAt(index) == guess) {
					display[index] = guess;
					correct = true;
				}
			}
			guessed.add(guess);
			if (!correct) {
				wrongGuesses--;
			}
		} else {
			System.out.print("Invalid guess. Try again.\n");
			guess();
		}
	}
	
	// Draw the hangman based on how many guesses player took
	private void draw() {
		System.out.print("Guessed letters: ");
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
			default:
				System.out.println("_______");
				System.out.println("|/    |");
				System.out.println("|   (x-x)");
				System.out.println("|   __|__");
				System.out.println("|     |");
				System.out.println("|    / \\");
				System.out.println("|_________");
				break;
		}
		for (int i = 0; i < display.length; i++) {
			System.out.print(display[i] + " ");
		}
		System.out.println();
	}
	
	// Checks if player successfully guessed word
	public boolean isWinner() {
		return false;
	}
	
}
