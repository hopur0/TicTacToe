package hopur0.games.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class BoardTest {

    @Test
    public void testSettingUnoccupiedTile() {
        Board b = new Board();
        Player p = new Player("Test", 'x');
        int tile = 1;
        b.setTile(p, tile);
        assertEquals(b.getTile(tile).getName(), p.getName());
    }

    @Test
    public void testAlternatingTiles() {
        Board b = new Board();
        Player p1 = new Player("Tester1", 'x');
        Player p2 = new Player("Tester2", 'o');
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0)
                b.setTile(p1, i);
            else
                b.setTile(p2, i);
        }

        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0)
                assertEquals(b.getTile(i), p1);
            else
                assertEquals(b.getTile(i), p2);
        }
    }

    @Test
    public void testInvalidTile() {
        try {
            Board b = new Board();
            Player p = new Player("Test", 'x');
            b.setTile(p, 10);
            fail("Did not throw error");
        }
        catch (IllegalArgumentException ex) {
            String expectedMessage = "Picked tile not on board";
            assertEquals(expectedMessage, ex.getMessage());
        }

    }

    @Test
    public void testOccupiedTile() {
        try {
            Board b = new Board();
            Player p = new Player("Test", 'x');
            b.setTile(p, 1);
            b.setTile(p, 1);
            fail("Did not throw error");
        }
        catch (IllegalArgumentException ex) {
            String expectedMessage = "Tile is already occupied";
            assertEquals(expectedMessage, ex.getMessage());
        }

    }

}
