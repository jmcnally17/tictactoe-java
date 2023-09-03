public class Board {
  private Cell[][] cells;

  public Board() {
    this.cells = new Cell[][] { { new Cell("1"), new Cell("2"), new Cell("3") },
        { new Cell("4"), new Cell("5"), new Cell("6") },
        { new Cell("7"), new Cell("8"), new Cell("9") } };
  }

  public void display() {
    String line1 = "     |     |     \n";
    String line2 = "  " + cells[0][0].getValue() + "  |  " + cells[0][1].getValue() + "  |  " + cells[0][2].getValue()
        + "  \n";
    String line3 = "_____|_____|_____\n";
    String line4 = "     |     |     \n";
    String line5 = "  " + cells[1][0].getValue() + "  |  " + cells[1][1].getValue() + "  |  " + cells[1][2].getValue()
        + "  \n";
    String line6 = "_____|_____|_____\n";
    String line7 = "     |     |     \n";
    String line8 = "  " + cells[2][0].getValue() + "  |  " + cells[2][1].getValue() + "  |  " + cells[2][2].getValue()
        + "  \n";
    String line9 = "     |     |     \n";
    System.out.println(line1 + line2 + line3 + line4 + line5 + line6 + line7 + line8 + line9);
  }

  public boolean makeMove(String move, int playerTurn) {
    switch (move) {
      case "1":
        return this.cells[0][0].fill(playerTurn, System.out);
      case "2":
        return this.cells[0][1].fill(playerTurn, System.out);
      case "3":
        return this.cells[0][2].fill(playerTurn, System.out);
      case "4":
        return this.cells[1][0].fill(playerTurn, System.out);
      case "5":
        return this.cells[1][1].fill(playerTurn, System.out);
      case "6":
        return this.cells[1][2].fill(playerTurn, System.out);
      case "7":
        return this.cells[2][0].fill(playerTurn, System.out);
      case "8":
        return this.cells[2][1].fill(playerTurn, System.out);
      case "9":
        return this.cells[2][2].fill(playerTurn, System.out);
      default:
        System.out.println("Invalid cell number!");
        return false;
    }
  }

  public boolean winningTripleFound() {
    boolean condition1 = this.cells[0][0].getValue().equals(this.cells[0][1].getValue())
        && this.cells[0][0].getValue().equals(this.cells[0][2].getValue());
    boolean condition2 = this.cells[1][0].getValue().equals(this.cells[1][1].getValue())
        && this.cells[1][0].getValue().equals(this.cells[1][2].getValue());
    boolean condition3 = this.cells[2][0].getValue().equals(this.cells[2][1].getValue())
        && this.cells[2][0].getValue().equals(this.cells[2][2].getValue());
    boolean condition4 = this.cells[0][0].getValue().equals(this.cells[1][0].getValue())
        && this.cells[0][0].getValue().equals(this.cells[2][0].getValue());
    boolean condition5 = this.cells[0][1].getValue().equals(this.cells[1][1].getValue())
        && this.cells[0][1].getValue().equals(this.cells[2][1].getValue());
    boolean condition6 = this.cells[0][2].getValue().equals(this.cells[1][2].getValue())
        && this.cells[0][2].getValue().equals(this.cells[2][2].getValue());
    boolean condition7 = this.cells[0][0].getValue().equals(this.cells[1][1].getValue())
        && this.cells[0][0].getValue().equals(this.cells[2][2].getValue());
    boolean condition8 = this.cells[0][2].getValue().equals(this.cells[1][1].getValue())
        && this.cells[0][2].getValue().equals(this.cells[2][0].getValue());
    return condition1 || condition2 || condition3 || condition4 || condition5 || condition6 || condition7 || condition8;
  }

  public boolean haveCellsBeenFilled() {
    for (Cell[] row : this.cells) {
      for (Cell cell : row) {
        if (!cell.hasBeenFilled()) {
          return false;
        }
      }
    }
    return true;
  }
}
