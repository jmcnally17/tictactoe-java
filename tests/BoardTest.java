import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for the Board class
 */
public class BoardTest {
  private Board board;
  private Cell[][] cells;
  private PrintStream mockOut;

  @BeforeEach
  public void beforeEach() {
    Cell cell1 = Mockito.mock(Cell.class);
    Cell cell2 = Mockito.mock(Cell.class);
    Cell cell3 = Mockito.mock(Cell.class);
    Cell cell4 = Mockito.mock(Cell.class);
    Cell cell5 = Mockito.mock(Cell.class);
    Cell cell6 = Mockito.mock(Cell.class);
    Cell cell7 = Mockito.mock(Cell.class);
    Cell cell8 = Mockito.mock(Cell.class);
    Cell cell9 = Mockito.mock(Cell.class);
    this.cells = new Cell[][] { { cell1, cell2, cell3 }, { cell4, cell5, cell6 }, { cell7, cell8, cell9 } };
    this.board = new Board(this.cells);
    this.mockOut = Mockito.mock(PrintStream.class);
  }

  @Test
  public void displayPrintsTheBoardToTerminal() {
    // Set up mocks
    int value = 1;
    for (Cell[] row : this.cells) {
      for (Cell cell : row) {
        Mockito.when(cell.getValue()).thenReturn(Integer.toString(value));
        value++;
      }
    }

    String line1 = "     |     |\n";
    String line2 = "  1  |  2  |  3\n";
    String line3 = "_____|_____|_____\n";
    String line4 = "     |     |\n";
    String line5 = "  4  |  5  |  6\n";
    String line6 = "_____|_____|_____\n";
    String line7 = "     |     |\n";
    String line8 = "  7  |  8  |  9\n";
    String line9 = "     |     |\n";
    String displayString = line1 + line2 + line3 + line4 + line5 + line6 + line7 + line8 + line9;

    this.board.display(this.mockOut);
    for (Cell[] row : this.cells) {
      for (Cell cell : row) {
        Mockito.verify(cell).getValue();
      }
    }
    Mockito.verify(this.mockOut).println(displayString);
  }

  @Test
  public void makeMoveFillsFirstCell() {
    Mockito.when(this.cells[0][0].fill(1, this.mockOut)).thenReturn(true);
    Assertions.assertTrue(this.board.makeMove("1", 1, this.mockOut));
    Mockito.verify(this.cells[0][0]).fill(1, this.mockOut);
  }

  @Test
  public void makeMoveFillsSecondCell() {
    Mockito.when(this.cells[0][1].fill(1, this.mockOut)).thenReturn(true);
    Assertions.assertTrue(this.board.makeMove("2", 1, this.mockOut));
    Mockito.verify(this.cells[0][1]).fill(1, this.mockOut);
  }

  @Test
  public void makeMoveFillsThirdCell() {
    Mockito.when(this.cells[0][2].fill(1, this.mockOut)).thenReturn(true);
    Assertions.assertTrue(this.board.makeMove("3", 1, this.mockOut));
    Mockito.verify(this.cells[0][2]).fill(1, this.mockOut);
  }

  @Test
  public void makeMoveFillsFourthCell() {
    Mockito.when(this.cells[1][0].fill(1, this.mockOut)).thenReturn(true);
    Assertions.assertTrue(this.board.makeMove("4", 1, this.mockOut));
    Mockito.verify(this.cells[1][0]).fill(1, this.mockOut);
  }

  @Test
  public void makeMoveFillsFifthCell() {
    Mockito.when(this.cells[1][1].fill(1, this.mockOut)).thenReturn(true);
    Assertions.assertTrue(this.board.makeMove("5", 1, this.mockOut));
    Mockito.verify(this.cells[1][1]).fill(1, this.mockOut);
  }

  @Test
  public void makeMoveFillsSixthCell() {
    Mockito.when(this.cells[1][2].fill(1, this.mockOut)).thenReturn(true);
    Assertions.assertTrue(this.board.makeMove("6", 1, this.mockOut));
    Mockito.verify(this.cells[1][2]).fill(1, this.mockOut);
  }

  @Test
  public void makeMoveFillsSeventhCell() {
    Mockito.when(this.cells[2][0].fill(1, this.mockOut)).thenReturn(true);
    Assertions.assertTrue(this.board.makeMove("7", 1, this.mockOut));
    Mockito.verify(this.cells[2][0]).fill(1, this.mockOut);
  }

  @Test
  public void makeMoveFillsEigthCell() {
    Mockito.when(this.cells[2][1].fill(1, this.mockOut)).thenReturn(true);
    Assertions.assertTrue(this.board.makeMove("8", 1, this.mockOut));
    Mockito.verify(this.cells[2][1]).fill(1, this.mockOut);
  }

  @Test
  public void makeMoveFillsNinthCell() {
    Mockito.when(this.cells[2][2].fill(1, this.mockOut)).thenReturn(true);
    Assertions.assertTrue(this.board.makeMove("9", 1, this.mockOut));
    Mockito.verify(this.cells[2][2]).fill(1, this.mockOut);
  }

  @Test
  public void makeMovePrintsInvalidNumber() {
    Assertions.assertFalse(this.board.makeMove("25", 1, this.mockOut));
    Mockito.verify(this.mockOut).println("Invalid cell number!");
  }
}
