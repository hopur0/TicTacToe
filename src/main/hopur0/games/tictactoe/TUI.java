package hopur0.games.tictactoe;

import java.util.Scanner;

public class TUI implements UI {
	private Scanner scanner;

	public TUI() {
		scanner = new Scanner(System.in);
	}

	public TUI(java.io.InputStream inputStream) {
		scanner = new Scanner(inputStream);
	}

	@Override
	public int options(String[] options) {
		for (int option = 0; option < options.length; option++) {
			StringBuilder sb = new StringBuilder();
			sb.append(option + 1);
			sb.append(": ");
			sb.append(options[option]);
			showMessage(sb.toString());
		}
		int choose = getInt("Enter number:");
		while (choose < 1 || choose > options.length) {
			showMessage("Invalid input!");
			choose = getInt("Enter number:");
		}
		return choose;
	}

	@Override
	public String getString(String message) {
		showMessage(message);
		String s = "";
		while (s.isEmpty()) {
			while (!scanner.hasNextLine()) {
				showMessage("Please enter some text!");
			    scanner.next();
			}
			s = scanner.nextLine();
		}
		return s;
	}

	@Override
	public char getChar(String message) {
		return getString(message).charAt(0);
	}

	@Override
	public int getInt(String message) {
		showMessage(message);
		while (!scanner.hasNextInt()) {
			showMessage("Please enter a number!");
		    scanner.next();
		}
		int n = scanner.nextInt();
		return n;
	}

	@Override
	public void showMessage(String message) {
		System.out.println(message);
	}

}
