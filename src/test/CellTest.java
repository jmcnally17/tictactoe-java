import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Unit test for Cell class
 */
public class CellTest {
  private Cell cell;

  @BeforeEach
  public void beforeEach() {
    cell = new Cell("4");
  }

  @Nested
  class UponInstantiation {
    @Test
    public void isFilledIsFalse() {
      assertFalse(cell.hasBeenFilled());
    }

    @Test
    public void valueIsSetToConstructorParameter() {
      assertEquals("4", cell.getValue());
    }
  }

  @Nested
  class SetValue {
    @Test
    public void changesValueProperty() {
      cell.setValue("X");
      assertEquals("X", cell.getValue());
    }
  }

  @Nested
  class Fill {
    private PrintStream outMock;

    @BeforeEach
    public void beforeEach() {
      outMock = mock(PrintStream.class);
    }

    @Test
    public void setsValueToXForPlayer1Turn() {
      assertTrue(cell.fill(1, outMock));
      assertEquals("X", cell.getValue());
    }

    @Test
    public void setsValueToOForPlayer2Turn() {
      assertTrue(cell.fill(2, outMock));
      assertEquals("O", cell.getValue());
    }

    @Test
    public void setsIsFilledToTrue() {
      assertTrue(cell.fill(1, outMock));
      assertTrue(cell.hasBeenFilled());
    }

    @Test
    public void doesNotChangeValueIfIsFilledIsTrue() {
      cell.fill(1, outMock); // call fill initially to set isFilled to true

      assertFalse(cell.fill(2, outMock));
      verify(outMock).println("Cell already taken!");
    }
  }
}
