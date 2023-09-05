import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for TicTacToe class
 */
public class TicTacToeTest {
  private TicTacToe ticTacToe;
  private Board board;
  private PrintStream mockOut;
  private Scanner mockScanner;

  @BeforeEach
  public void beforeEach() {
    board = mock(Board.class);
    mockScanner = mock(Scanner.class);
    ticTacToe = new TicTacToe(board, mockScanner);
    mockOut = mock(PrintStream.class);
  }

  @Nested
  class UponInstantiation {
    @Test
    public void playerTurnIs1() {
      assertEquals(1, ticTacToe.getPlayerTurn());
    }
  }

  @Nested
  class DisplayBoard {
    @Test
    public void callsDisplayOnBoard() {
      ticTacToe.displayBoard();
      verify(board).display(System.out);
    }
  }

  @Nested
  class SwitchTurn {
    @Test
    public void changesTurnBetween1And2() {
      ticTacToe.switchTurn();
      assertEquals(2, ticTacToe.getPlayerTurn());

      ticTacToe.switchTurn();
      assertEquals(1, ticTacToe.getPlayerTurn());
    }
  }

  @Nested
  class HasGameFinished {
    @Test
    public void trueWhenPlayerHasWon() {
      when(board.winningTripleFound()).thenReturn(true);
      assertTrue(ticTacToe.hasGameFinished());
      verify(board).winningTripleFound();
    }

    @Test
    public void trueWhenCellsFilled() {
      when(board.winningTripleFound()).thenReturn(false);
      when(board.haveCellsBeenFilled()).thenReturn(true);
      assertTrue(ticTacToe.hasGameFinished());
      verify(board).winningTripleFound();
      verify(board).haveCellsBeenFilled();
    }

    @Test
    public void trueWhenPlayerWonAndCellsFilled() {
      when(board.winningTripleFound()).thenReturn(true);
      when(board.haveCellsBeenFilled()).thenReturn(true);
      assertTrue(ticTacToe.hasGameFinished());
      verify(board).winningTripleFound();
      verify(board, times(0)).haveCellsBeenFilled();
    }

    @Test
    public void falseWhenPlayerHasWon() {
      when(board.winningTripleFound()).thenReturn(false);
      when(board.haveCellsBeenFilled()).thenReturn(false);
      assertFalse(ticTacToe.hasGameFinished());
      verify(board).winningTripleFound();
      verify(board).haveCellsBeenFilled();
    }
  }

  @Nested
  class TakePlayersMove {
    @Test
    public void asksPlayer1ForInputAndReturnsIt() {
      when(mockScanner.nextLine()).thenReturn("5");
      assertEquals("5", ticTacToe.takePlayersMove(mockOut));
      verify(mockOut).println("Player 1, please pick a cell from 1 to 9:");
      verify(mockScanner).nextLine();
    }

    @Test
    public void asksPlayer2ForInputAndReturnsIt() {
      ticTacToe.switchTurn();

      when(mockScanner.nextLine()).thenReturn("5");
      assertEquals("5", ticTacToe.takePlayersMove(mockOut));
      verify(mockOut).println("Player 2, please pick a cell from 1 to 9:");
      verify(mockScanner).nextLine();
    }
  }

  @Nested
  class DeclareResult {
    @Test
    public void printsPlayer2Winner() {
      when(board.winningTripleFound()).thenReturn(true);
      ticTacToe.declareResult(mockOut);
      verify(board).winningTripleFound();
      verify(mockOut).println("Player 2 wins!");
    }

    @Test
    public void printsPlayer1Winner() {
      ticTacToe.switchTurn();

      when(board.winningTripleFound()).thenReturn(true);
      ticTacToe.declareResult(mockOut);
      verify(board).winningTripleFound();
      verify(mockOut).println("Player 1 wins!");
    }

    @Test
    public void printsADraw() {
      when(board.winningTripleFound()).thenReturn(false);
      ticTacToe.declareResult(mockOut);
      verify(board).winningTripleFound();
      verify(mockOut).println("It's a draw");
    }
  }
}
