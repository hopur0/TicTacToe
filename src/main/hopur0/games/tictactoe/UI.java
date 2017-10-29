package hopur0.games.tictactoe;

public interface UI {
	public void showMessage(String message);
	public int options(String[] options);
	public String getString(String message);
	public char getChar(String message);
	public int getInt(String message);
}
