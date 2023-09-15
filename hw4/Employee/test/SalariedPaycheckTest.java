import static org.junit.Assert.assertEquals;

import employee.SalariedPaycheck;
import org.junit.Test;

/**
 * Test SalariedPaycheck class.
 */
public class SalariedPaycheckTest {
  /**
   * Test constructor of SalariedPaycheck class.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor() {
    SalariedPaycheck S = new SalariedPaycheck(-10, 4);
    SalariedPaycheck S2 = new SalariedPaycheck(10, 3);
    SalariedPaycheck S3 = new SalariedPaycheck(60, 0);
  }

  /**
   * Test getTotalPay method.
   */
  @Test
  public void testGetTotalPay() {
    SalariedPaycheck S = new SalariedPaycheck(520, 4);
    assertEquals(40.00, S.getTotalPay(), 0.01);
    SalariedPaycheck S2 = new SalariedPaycheck(0, 4);
    assertEquals(0.00, S2.getTotalPay(), 0.01);
    SalariedPaycheck S3 = new SalariedPaycheck(52, 1);
    assertEquals(1.00, S3.getTotalPay(), 0.01);
  }

  /**
   * Test getPayInterval method.
   */
  @Test
  public void testGetPayInterval() {
    SalariedPaycheck S = new SalariedPaycheck(520, 4);
    assertEquals(4, S.getPayInterval());
    SalariedPaycheck S2 = new SalariedPaycheck(520, 1);
    assertEquals(1, S2.getPayInterval());
  }
}