import java.util.Scanner;

class TicTacToe {
  private Board board;
  private int playerTurn;
  private Scanner scanner;

  public TicTacToe(Board board) {
    this.board = board;
    this.playerTurn = 1;
    this.scanner = new Scanner(System.in);
  }

  public void displayBoard() {
    this.board.display(System.out);
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
      if (this.board.makeMove(move, this.playerTurn, System.out)) {
        this.switchTurn();
      }
      this.displayBoard();
    }

    this.declareResult();
    this.scanner.close();
  }

  public static void main(String[] args) {
    Cell[][] cells = { { new Cell("1"), new Cell("2"), new Cell("3") },
        { new Cell("4"), new Cell("5"), new Cell("6") },
        { new Cell("7"), new Cell("8"), new Cell("9") } };
    Board board = new Board(cells);
    TicTacToe ticTacToe = new TicTacToe(board);
    ticTacToe.play();
  }
}
