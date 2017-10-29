package hopur0.games.tictactoe;

class Game {
	UI ui;
	Board board;
	Player[] players;
	
	public Game(java.io.InputStream in) {
		this.ui = new TUI(in);
		board = new Board();
		initializePlayers();
		gameLoop();
	}

	public Game(UI ui) {
		this.ui = ui;
		board = new Board();
		initializePlayers();
		gameLoop();
	}

	private void initializePlayers() {
		String firstPlayerName = ui.getString("Enter first player name:");
		String secondPlayerName = ui.getString("Enter second player name:");
		players = new Player[] {
			new Player(firstPlayerName, 'X'),
			new Player(secondPlayerName, 'O')
		};
	}

	private void gameLoop() {
		int currentPlayer = 0;

		while (board.winner() == null && !board.full()) {
			ui.showMessage("----------------------------");
			ui.showMessage("Current state:" + System.lineSeparator() + board.toString());
			ui.showMessage(players[currentPlayer].getName() + " plays:");

			int selectedTile = 0;
			do {
				selectedTile = ui.getInt("Enter tile number:");
			} while (!board.validTile(selectedTile) || board.getTile(selectedTile) != null);

			board.setTile(players[currentPlayer], selectedTile);
			currentPlayer = (currentPlayer + 1) % 2;
		}

		ui.showMessage("----------------------------");
		ui.showMessage("Final state:" + System.lineSeparator() + board.toString());

		if (board.winner() == null && board.full()) {
			ui.showMessage("Draw!");
		} else {
			Player winner = board.winner();
			ui.showMessage(winner.getName() + " is the winner!");
		}
	}

	public static void main(String[] args) {
		new Game(new TUI());
  }
}
