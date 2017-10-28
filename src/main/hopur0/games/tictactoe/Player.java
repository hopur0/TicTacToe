package hopur0.games.tictactoe;

class Player {
	
	private String name;
	private char symbol;
	
	public Player(String name, char symbol)
	{
		setName(name);
		setSymbol(symbol);
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public char getSymbol()
	{
		return symbol;
	}
	
	public void setSymbol(char symbol)
	{
		this.symbol = symbol;
	}
}
