import java.util.Scanner;

class TicTacToe {
  private Board board;
  private int playerTurn;
  private Scanner scanner;

  public TicTacToe() {
    this.board = new Board();
    this.playerTurn = 1;
    this.scanner = new Scanner(System.in);
  }

  public void displayBoard() {
    this.board.display();
  }

  public void switchTurn() {
    this.playerTurn = this.playerTurn == 1 ? 2 : 1;
  }

  public boolean hasGameFinished() {
    return this.board.winningTripleFound() || this.board.haveCellsBeenFilled();
  }

  public void declareResult() {
    if (this.board.winningTripleFound()) {
      System.out.println("Player " + (this.playerTurn % 2 + 1) + " wins!");
    } else {
      System.out.println("It's a draw");
    }
  }

  public void play() {
    System.out.println("Welcome to Tic-Tac-Toe!\n");
    this.displayBoard();

    while (!this.hasGameFinished()) {
      System.out.println("Player " + this.playerTurn + ", please pick a cell from 1 to 9:");
      String move = this.scanner.nextLine();
      this.board.makeMove(move, this.playerTurn);
      this.displayBoard();
      this.switchTurn();
    }

    this.declareResult();
    this.scanner.close();
  }

  public static void main(String[] args) {
    TicTacToe ticTacToe = new TicTacToe();
    ticTacToe.play();
  }
}
