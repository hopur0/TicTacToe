package hopur0.games.tictactoe;

import static spark.Spark.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.UUID;

public class WebGame {
	HashMap<String, Board> boards;
	Player[] players;

	public WebGame() {
		boards = new HashMap<String, Board>();
		players = new Player[] {
			new Player("Player 1", 'X'),
			new Player("Player 2", 'O')
		};
	}

	public void serve() {
		int port = 4567;
		if (System.getProperty("server.port") != null) {
			port = Integer.parseInt(System.getProperty("server.port"));
		}
		System.out.println(port);
		port(port);
		staticFileLocation("/public");
		get("/", (req, res) -> renderContent("index.html"));

		post("/newgame", (req, res) -> {
				String id = UUID.randomUUID().toString();
				boards.put(id, new Board());
				return id;
			});

		get("/state/:uuid", (req, res) -> {
				return boards.get(req.params("uuid")).toString();
			});

		put("/settile/:uuid/:playerId/:tile", (req, res) -> {
				String id = req.params("uuid");
				Board board = boards.get(id);
				if (board == null)
					return null;
				int playerId = Integer.parseInt(req.params("playerId"));
				int tile = Integer.parseInt(req.params("tile"));
				if (!board.validTile(tile)) {
					res.status(400);
					return "Invalid tile";
				}
				if (board.getTile(tile) != null) {
					res.status(400);
					return "Tile occupied";
				}
				board.setTile(players[playerId], tile);

				String result = board.toString();
				// Check if winner or board full
				if (board.winner() == null && board.full()) {
					result += "\nDraw!";
					boards.remove(id);
					return result;
				} else if (board.winner() != null) {
					Player winner = board.winner();
					result +=  "\n" + winner.getSymbol() + " is the winner!";
					boards.remove(id);
					return result;
				} else {
					return result;
				}
			});
	}

	private String renderContent(String htmlFile) {
		try {
			URL url = getClass().getResource(htmlFile);

			// Return a String which has all
			// the contents of the file.
			Path path = Paths.get(url.toURI());
			return new String(Files.readAllBytes(path), Charset.defaultCharset());
		} catch (IOException | URISyntaxException e) {
			return "404 Error";
		}
	}

	public static void main(String[] args) {
		WebGame wg = new WebGame();
		wg.serve();
	}

}
