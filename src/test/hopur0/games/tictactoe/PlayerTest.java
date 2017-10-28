package hopur0.games.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class PlayerTest {
    @Test
    public void setName() {
    	Player player = new Player("Viktor", 'x');
    	player.setName("Siggi");
        assertEquals("Siggi", player.getName());
    }
    
    @Test
    public void getName() {
    	Player player = new Player("Viktor", 'x');
        assertEquals("Viktor", player.getName());
    }
    
    @Test
    public void setSymbol() {
    	Player player = new Player("Viktor", 'x');
    	player.setSymbol('o');
        assertEquals('o', player.getSymbol());
    }
    
    @Test
    public void getSymbol() {
    	Player player = new Player("Viktor", 'x');
        assertEquals('x', player.getSymbol());
    }
}
