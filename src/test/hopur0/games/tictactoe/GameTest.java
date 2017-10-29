package hopur0.games.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;

import org.junit.Test;

public class GameTest {
	@Test
    public void testInitializingPlayers() {
		
		String data = "Viktor\nHrafn\n1\n4\n2\n5\n3\n";
		Game g = new Game(new ByteArrayInputStream(data.getBytes()));
			
		Player player0 = new Player("Viktor", 'X');
		Player player1 = new Player("Hrafn", 'O');
			
		assertEquals(g.players[0].getName(), "Viktor");
		assertEquals(g.players[1].getName(), "Hrafn");
		
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
	@Test
	public void testGameLoopDraw() {
		
		String data = "Viktor\nHrafn\n1\n5\n2\n3\n7\n4\n6\n8\n9\n";
		UI ui = new TUI(new ByteArrayInputStream(data.getBytes()));
		
		Game g = new Game(ui);		
			
		assertEquals(g.board.winner(), null);
		
    }
}
