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
    public void testNoWinner() {
    	Player p1 = new Player("Tester1", 'x');
        Player p2 = new Player("Tester2", 'o');
        
        // no winner
    	Board b = new Board();
        b.setTile(p1, 1);
        b.setTile(p2, 2);
        b.setTile(p1, 3);
        assertEquals(b.winner(), null);
        
        // board full no winner
    	b = new Board();
        b.setTile(p1, 1);
        b.setTile(p2, 2);
        b.setTile(p1, 3);
        b.setTile(p1, 5);
        b.setTile(p2, 4);
        b.setTile(p1, 6);
        b.setTile(p2, 7);
        b.setTile(p1, 8);
        b.setTile(p2, 9);
        assertEquals(b.winner(), null);
        
    }
    
    @Test
    public void testHorizontalWinners() {
        Player p = new Player("Tester", 'x');

        // First horizontal
        Board b = new Board();
        b.setTile(p, 1);
        b.setTile(p, 2);
        b.setTile(p, 3);
        assertEquals(b.winner(), p);

        // Second horizontal
        b = new Board();
        b.setTile(p, 4);
        b.setTile(p, 5);
        b.setTile(p, 6);
        assertEquals(b.winner(), p);

        // Third horizontal
        b = new Board();
        b.setTile(p, 7);
        b.setTile(p, 8);
        b.setTile(p, 9);
        assertEquals(b.winner(), p);
    }

    @Test
    public void testVerticalWinners() {
        Player p = new Player("Tester", 'x');

        // First vertical
        Board b = new Board();
        b.setTile(p, 1);
        b.setTile(p, 4);
        b.setTile(p, 7);
        assertEquals(b.winner(), p);

        // Second vertical
        b = new Board();
        b.setTile(p, 2);
        b.setTile(p, 5);
        b.setTile(p, 8);
        assertEquals(b.winner(), p);

        // Third vertical
        b = new Board();
        b.setTile(p, 3);
        b.setTile(p, 6);
        b.setTile(p, 9);
        assertEquals(b.winner(), p);
    }

    @Test
    public void testDiagonalWinners() {
        Player p = new Player("Tester", 'x');

        // First diagonal
        Board b = new Board();
        b.setTile(p, 1);
        b.setTile(p, 5);
        b.setTile(p, 9);
        assertEquals(b.winner(), p);

        // Second diagonal
        b = new Board();
        b.setTile(p, 3);
        b.setTile(p, 5);
        b.setTile(p, 7);
        assertEquals(b.winner(), p);
    }

    @Test
    public void testBoardFull() {
        Board b = new Board();
        Player p = new Player("Tester", 'x');

        b.setTile(p, 1);
        b.setTile(p, 2);
        b.setTile(p, 3);
        b.setTile(p, 4);
        b.setTile(p, 5);
        b.setTile(p, 6);
        b.setTile(p, 7);
        b.setTile(p, 8);
        b.setTile(p, 9);

        assertEquals(b.full(), true);
    }

    @Test
    public void testBoardEmpty() {
        Board b = new Board();
        assertEquals(b.full(), false);
    }

    @Test
    public void testBoardHalfFull() {
        Board b = new Board();
        Player p = new Player("Tester", 'x');

        b.setTile(p, 1);
        b.setTile(p, 3);
        b.setTile(p, 5);
        b.setTile(p, 7);
        b.setTile(p, 9);

        assertEquals(b.full(), false);
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
    public void testNegativeTile() {
        try {
            Board b = new Board();
            Player p = new Player("Test", 'x');
            b.setTile(p, -1);
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

    @Test
    public void testToString() {
        Board b = new Board();
        Player p1 = new Player("Tester1", 'x');
        Player p2 = new Player("Tester2", 'o');

        assertEquals(b.toString(),
                     "1 2 3" + System.lineSeparator()
                     + "4 5 6" + System.lineSeparator()
                     + "7 8 9");

        b.setTile(p1, 1);
        b.setTile(p2, 2);

        assertEquals(b.toString(),
                     "x o 3" + System.lineSeparator()
                     + "4 5 6" + System.lineSeparator()
                     + "7 8 9");
    }
    
    @Test
    public void testgetInvalidTile() {
    	try {
            Board b = new Board();
            b.getTile(10);
            fail("Did not throw error");
        }
        catch (IllegalArgumentException ex) {
            String expectedMessage = "Picked tile not on board";
            assertEquals(expectedMessage, ex.getMessage());
        }
    }
}
