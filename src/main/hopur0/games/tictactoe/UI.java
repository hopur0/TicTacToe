package hopur0.games.tictactoe;

public abstract class UI {
	public abstract int options(String[] options);
	public abstract String getString(String message);
	public abstract Character getCharacter(String message);
	public abstract int getInt(String message);
}
