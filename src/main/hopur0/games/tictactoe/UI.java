package hopur0.games.tictactoe;

public abstract class UI {
	public abstract void showMessage(String message);
	public abstract int options(String[] options);
	public abstract String getName();
	public abstract Character getSymbol();
	public abstract int getPlace();
}
