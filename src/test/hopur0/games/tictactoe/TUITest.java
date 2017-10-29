package hopur0.games.tictactoe;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import org.junit.Test;

public class TUITest {

	// tests for getInt
	@Test
	public void testInvalidIntInputThenCorrect() {
		String data = "text\n5";
		TUI tui = new TUI(new ByteArrayInputStream(data.getBytes()));
        assertEquals(5, tui.getInt(""));
	}

	@Test
	public void testCorrectIntInputThenInvalid() {
		String data = "5\ntext";
		TUI tui = new TUI(new ByteArrayInputStream(data.getBytes()));
        assertEquals(5, tui.getInt(""));
	}

	@Test
	public void testCorrectIntInput() {
		String data = "501";
		TUI tui = new TUI(new ByteArrayInputStream(data.getBytes()));
        assertEquals(501, tui.getInt(""));
	}

	// tests for getString
	@Test
	public void testInvalidStringInputThenCorrect() {
		String data = System.lineSeparator() + "Text";
		TUI tui = new TUI(new ByteArrayInputStream(data.getBytes()));
        assertEquals("Text", tui.getString(""));
	}

	@Test
	public void testCorrectStringInputThenInvalid() {
		String data = "Hello\n";
		TUI tui = new TUI(new ByteArrayInputStream(data.getBytes()));
        assertEquals("Hello", tui.getString(""));
	}

	@Test
	public void testCorrectStringInput() {
		String data = "String";
		TUI tui = new TUI(new ByteArrayInputStream(data.getBytes()));
        assertEquals("String", tui.getString(""));
	}

	@Test
	public void testCorrectStringInputNoHasNextLine() {
		String data = "\n\nString";
		TUI tui = new TUI(new ByteArrayInputStream(data.getBytes()));
        assertEquals("String", tui.getString(""));
	}
	
	// tests for getChar
	@Test
	public void testInvalidCharInputThenCorrect() {
		String data = "\nA";
		TUI tui = new TUI(new ByteArrayInputStream(data.getBytes()));
        assertEquals('A', tui.getChar(""));
	}

	@Test
	public void testCorrectCharInputThenInvalid() {
		String data = "C\n555";
		TUI tui = new TUI(new ByteArrayInputStream(data.getBytes()));
        assertEquals('C', tui.getChar(""));
	}

	@Test
	public void testCorrectCharInput() {
		String data = "H";
		TUI tui = new TUI(new ByteArrayInputStream(data.getBytes()));
        assertEquals('H', tui.getChar(""));
	}

	// tests for options
	@Test
	public void testOptions() {
		String data = "1";
		TUI tui = new TUI(new ByteArrayInputStream(data.getBytes()));
		String[] options = new String[5];
        assertEquals(1, tui.options(options));
	}

	@Test
	public void testWrongOptionThenRightOption() {
		String data = "-1\n1";
		TUI tui = new TUI(new ByteArrayInputStream(data.getBytes()));
		String[] options = new String[5];
		assertEquals(1, tui.options(options));
	}

	@Test
	public void testTooHighOptionThenRightOption() {
		String data = "10\n1";
		TUI tui = new TUI(new ByteArrayInputStream(data.getBytes()));
		String[] options = new String[5];
		assertEquals(1, tui.options(options));
	}

}
