import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for the Cell class
 */
public class CellTest {
    private Cell cell;

    @BeforeEach
    public void setUpCell() {
        this.cell = new Cell("4");
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
        Assertions.assertTrue(this.cell.fill(1));
        Assertions.assertEquals("X", this.cell.getValue());
    }

    @Test
    public void fillSetsValueToOForPlayer2Turn() {
        Assertions.assertTrue(this.cell.fill(2));
        Assertions.assertEquals("O", this.cell.getValue());
    }

    @Test
    public void fillSetsIsFilledToTrue() {
        Assertions.assertTrue(this.cell.fill(1));
        Assertions.assertTrue(this.cell.hasBeenFilled());
    }
}
