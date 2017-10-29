package hopur0.games.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;

import org.junit.Test;

public class GameTest {

	@Test
  public void testInitializingPlayers() {
		String data = "Viktor\nHrafn\n1\n4\n2\n5\n3\n3\n";
		Game g = new Game(new ByteArrayInputStream(data.getBytes()));
		assertEquals(g.players[0].getName(), "Viktor");
		assertEquals(g.players[1].getName(), "Hrafn");
  }

	@Test
	public void testEnteringWrongTile() {
		String data = "Viktor\nHrafn\n1\n1\n4\n2\n5\n3\n3\n";
		Game g = new Game(new ByteArrayInputStream(data.getBytes()));
		assertEquals(g.board.winner().getName(), "Viktor");
	}

	@Test
	public void testMultipleGamesInARow() {
		String data = "Viktor\nHrafn\n1\n1\n4\n2\n5\n3\n1\n4\n1\n5\n2\n7\n3\n3\n";
		Game g = new Game(new ByteArrayInputStream(data.getBytes()));
		assertEquals(g.board.winner().getName(), "Hrafn");
	}
	
	@Test
  public void testGameLoopWinner() {
		
		String data = "Viktor\nHrafn\n1\n4\n2\n5\n3\n";
		Game g = new Game(new ByteArrayInputStream(data.getBytes()));
			
			
		assertEquals(g.board.winner().getName(), "Viktor");
		
  }
	
	@Test
  public void testDefaultGameConstructor() {
		
		String data = "Viktor\nHrafn\n1\n4\n2\n5\n3\n";
		UI ui = new TUI(new ByteArrayInputStream(data.getBytes()));
		
		Game g = new Game(ui);		
			
		assertEquals(g.board.winner().getName(), "Viktor");
		
  }
}
