import static org.junit.Assert.assertEquals;

import employee.HourlyPaycheck;
import employee.SalariedPaycheck;
import org.junit.Test;


/**
 * Test for Paycheck class.
 */
public class PaycheckTest {
  /**
   * Test for paycheck Constructor.
   */
  @Test
  public void testPaycheckConstructor() {
    try {
      SalariedPaycheck S = new SalariedPaycheck(-1.00, 1);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid pay rate, should be larger than 0", e.getMessage());
    }
    try {
      HourlyPaycheck H = new HourlyPaycheck(-5, 10);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid pay rate, should be larger than 0", e.getMessage());
    }
  }

  /**
   * Test for getPayAfterTaxes() method for both pay check.
   */
  @Test
  public void getPayAfterTaxes() {
    SalariedPaycheck S = new SalariedPaycheck(5200, 1);
    assertEquals(90.00, S.getPayAfterTaxes(), 0.01);
    SalariedPaycheck S2 = new SalariedPaycheck(52000, 1);
    assertEquals(850.00, S2.getPayAfterTaxes(), 0.01);
    SalariedPaycheck S3 = new SalariedPaycheck(0.52, 1);
    assertEquals(0.01, S3.getPayAfterTaxes(), 0.01);

    HourlyPaycheck H = new HourlyPaycheck(10,20);
    assertEquals(180.00, H.getPayAfterTaxes(), 0.01);
    HourlyPaycheck H2 = new HourlyPaycheck(10,50);
    assertEquals(467.50, H2.getPayAfterTaxes(), 0.01);
    HourlyPaycheck H3 = new HourlyPaycheck(0.01,1);
    assertEquals(0.01, H3.getPayAfterTaxes(), 0.01);
  }

  /**
   * Test of getPayRate method.
   */
  @Test
  public void testGetPayRate() {
    SalariedPaycheck S = new SalariedPaycheck(5200, 1);
    assertEquals(5200, S.getPayRate(), 0.01);
    HourlyPaycheck H = new HourlyPaycheck(10,20);
    assertEquals(10, H.getPayRate(), 0.01);
  }
}