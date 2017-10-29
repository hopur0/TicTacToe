package hopur0.games.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;

import org.junit.Test;

public class GameTest {
	@Test
    public void testInitializingPlayers() {
		
		
		String data = "Viktor\nHrafn\n";
		Game g = new Game(new ByteArrayInputStream(data.getBytes()));		
		
		
		Player player0 = new Player("Viktor", 'X');
		Player player1 = new Player("Hrafn", 'O');
		
		assertEquals(g.players[0], player0);
		assertEquals(g.players[1], player1);
		
			
		
    }
}
