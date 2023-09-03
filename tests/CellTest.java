import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for the Cell class
 */
public class CellTest {
  private Cell cell;
  private PrintStream outMock;

  @BeforeEach
  public void beforeEach() {
    this.cell = new Cell("4");
    this.outMock = Mockito.mock(PrintStream.class);
  }

  @Test
  public void isFilledIsFalseUponInstantiation() {
    Assertions.assertFalse(this.cell.hasBeenFilled());
  }

  @Test
  public void valueIsInstantiatedWithParameterInConstructor() {
    Assertions.assertEquals("4", this.cell.getValue());
  }

  @Test
  public void setValueChangesValueProperty() {
    this.cell.setValue("X");
    Assertions.assertEquals("X", this.cell.getValue());
  }

  @Test
  public void fillSetsValueToXForPlayer1Turn() {
    Assertions.assertTrue(this.cell.fill(1, this.outMock));
    Assertions.assertEquals("X", this.cell.getValue());
  }

  @Test
  public void fillSetsValueToOForPlayer2Turn() {
    Assertions.assertTrue(this.cell.fill(2, this.outMock));
    Assertions.assertEquals("O", this.cell.getValue());
  }

  @Test
  public void fillSetsIsFilledToTrue() {
    Assertions.assertTrue(this.cell.fill(1, this.outMock));
    Assertions.assertTrue(this.cell.hasBeenFilled());
  }

  @Test
  public void fillDoesNotChangeValueIfIsFilledIsTrue() {
    this.cell.fill(1, this.outMock); // call fill initially to set isFilled to true

    Assertions.assertFalse(this.cell.fill(2, this.outMock));
    Mockito.verify(outMock).println("Cell already taken!");
  }
}
