import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
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
    this.board = Mockito.mock(Board.class);
    this.mockScanner = Mockito.mock(Scanner.class);
    this.ticTacToe = new TicTacToe(this.board, mockScanner);
    this.mockOut = Mockito.mock(PrintStream.class);
  }

  @Test
  public void playerTurnIs1UponInstantiation() {
    Assertions.assertEquals(1, this.ticTacToe.getPlayerTurn());
  }

  @Test
  public void displayBoardCallsDisplayOnBoard() {
    this.ticTacToe.displayBoard();
    Mockito.verify(this.board).display(System.out);
  }

  @Test
  public void switchTurnChangesTurnBetween1And2() {
    this.ticTacToe.switchTurn();
    Assertions.assertEquals(2, this.ticTacToe.getPlayerTurn());

    this.ticTacToe.switchTurn();
    Assertions.assertEquals(1, this.ticTacToe.getPlayerTurn());
  }

  @Test
  public void hasGameFinishedTrueWhenPlayerHasWon() {
    Mockito.when(this.board.winningTripleFound()).thenReturn(true);
    Assertions.assertTrue(this.ticTacToe.hasGameFinished());
  }

  @Test
  public void hasGameFinishedTrueWhenCellsFilled() {
    Mockito.when(this.board.winningTripleFound()).thenReturn(false);
    Mockito.when(this.board.haveCellsBeenFilled()).thenReturn(true);
    Assertions.assertTrue(this.ticTacToe.hasGameFinished());
  }

  @Test
  public void hasGameFinishedTrueWhenPlayerWonAndCellsFilled() {
    Mockito.when(this.board.winningTripleFound()).thenReturn(true);
    Mockito.when(this.board.haveCellsBeenFilled()).thenReturn(true);
    Assertions.assertTrue(this.ticTacToe.hasGameFinished());
  }

  @Test
  public void hasGameFinishedFalseWhenPlayerHasWon() {
    Mockito.when(this.board.winningTripleFound()).thenReturn(false);
    Mockito.when(this.board.haveCellsBeenFilled()).thenReturn(false);
    Assertions.assertFalse(this.ticTacToe.hasGameFinished());
  }

  @Test
  public void takePlayersMoveAsksPlayer1ForInputAndReturnsIt() {
    Mockito.when(this.mockScanner.nextLine()).thenReturn("5");
    Assertions.assertEquals(this.mockScanner.nextLine(), this.ticTacToe.takePlayersMove(mockOut));
    Mockito.verify(this.mockOut).println("Player 1, please pick a cell from 1 to 9:");
  }

  @Test
  public void takePlayersMoveAsksPlayer2ForInputAndReturnsIt() {
    this.ticTacToe.switchTurn();

    Mockito.when(this.mockScanner.nextLine()).thenReturn("5");
    Assertions.assertEquals(this.mockScanner.nextLine(), this.ticTacToe.takePlayersMove(mockOut));
    Mockito.verify(this.mockOut).println("Player 2, please pick a cell from 1 to 9:");
  }

  @Test
  public void declareResultPrintsPlayer2Winner() {
    Mockito.when(this.board.winningTripleFound()).thenReturn(true);
    this.ticTacToe.declareResult(mockOut);
    Mockito.verify(this.mockOut).println("Player 2 wins!");
  }

  @Test
  public void declareResultPrintsPlayer1Winner() {
    this.ticTacToe.switchTurn();

    Mockito.when(this.board.winningTripleFound()).thenReturn(true);
    this.ticTacToe.declareResult(mockOut);
    Mockito.verify(this.mockOut).println("Player 1 wins!");
  }

  @Test
  public void declareResultPrintsADraw() {
    Mockito.when(this.board.winningTripleFound()).thenReturn(false);
    this.ticTacToe.declareResult(mockOut);
    Mockito.verify(this.mockOut).println("It's a draw");
  }
}
