package hopur0.games.tictactoe;

import static spark.Spark.*;

public class WUI implements UI {

	public WUI() {
		get("/", (req, res) -> "Hello World");
	}

	@Override
	public void showMessage(String message) {
		get("/", (req, res) -> message);
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
		return 0;
	}

	@Override
	public String getString(String message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char getChar(String message) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInt(String message) {
		// TODO Auto-generated method stub
		return 0;
	}

}
