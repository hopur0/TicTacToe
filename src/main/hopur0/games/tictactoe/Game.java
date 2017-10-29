package hopur0.games.tictactoe;

class Game {
  UI ui;
  Board board;
  Player[] players;

  public Game(UI ui) {
    this.ui = ui;
    board = new Board();
    initializePlayers();
  }

  private void initializePlayers() {
    String firstPlayerName = ui.getString("Enter first player name:");
    String secondPlayerName = ui.getString("Enter second player name:");
    players = new Player[] {
      new Player(firstPlayerName, 'x'),
      new Player(secondPlayerName, 'o')
    };
  }

  private void gameLoop() {
    int currentPlayer = 0;

    while (board.winner() == null && !board.full()) {
      ui.showMessage("Current state:" + System.lineSeparator() + board.toString());
      ui.showMessage(players[currentPlayer].getName() + " plays:");
      int selectedTile = ui.getInt("Enter tile number:");
      board.setTile(players[currentPlayer], selectedTile);
      currentPlayer = (currentPlayer + 1) % 2;
    }

    if (board.full()) {
      ui.showMessage("Draw!");
    } else {
      Player winner = board.winner();
      ui.showMessage(winner.getName() + " is the winner!");
    }
  }

  public static void main(String[] args) {
  }
}
