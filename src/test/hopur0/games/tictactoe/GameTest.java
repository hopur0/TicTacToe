package hopur0.games.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class GameTest {
	@Test
    public void testInitializingPlayers() {
		UI ui = new TUI();
		Game g = new Game(ui);		
		
		assertEquals(g.players[0], 'X');
		assertEquals(g.players[1], 'O');	
		
    }
}
