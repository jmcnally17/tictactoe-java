public class Cell {
  private String value;
  private boolean isFilled;

  public Cell(String value) {
    this.value = value;
    this.isFilled = false;
  }

  public String getValue() {
    return this.value;
  }

  public boolean hasBeenFilled() {
    return this.isFilled;
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
    this.isFilled = true;
  }
}
