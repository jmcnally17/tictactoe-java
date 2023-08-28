public class Cell {
  private String value;

  public Cell(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public void fill(int playerTurn) {
    if (playerTurn == 1) {
      this.setValue("X");
    } else if (playerTurn == 2) {
      this.setValue("O");
    }
  }
}
