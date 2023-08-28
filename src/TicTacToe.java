import java.util.Scanner;

class TicTacToe {
  private Board board;
  private int playerTurn;

  public TicTacToe() {
    this.board = new Board();
    this.playerTurn = 1;
  }

  public void displayBoard() {
    this.board.display();
  }

  public void switchTurn() {
    this.playerTurn = this.playerTurn == 1 ? 2 : 1;
  }

  public void play() {
    System.out.println("Welcome to Tic-Tac-Toe!\n");
    this.displayBoard();

    int playerTurn = 1;
    Scanner scanner = new Scanner(System.in);

    System.out.println("Player " + playerTurn + ", please pick a cell from 1 to 9:");
    String move = scanner.nextLine();
    this.board.makeMove(move, playerTurn);
    this.displayBoard();
    this.switchTurn();

    scanner.close();
  }

  public static void main(String[] args) {
    TicTacToe ticTacToe = new TicTacToe();
    ticTacToe.play();
  }
}
