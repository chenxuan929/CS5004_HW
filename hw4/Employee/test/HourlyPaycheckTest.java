import static org.junit.Assert.assertEquals;

import employee.HourlyPaycheck;
import org.junit.Test;

/**
 * Test SalariedPaycheck class.
 */
public class HourlyPaycheckTest {
  /**
   * Test constructor of SalariedPaycheck class.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor() {
    HourlyPaycheck H = new HourlyPaycheck(-1,10);
    HourlyPaycheck H2 = new HourlyPaycheck(10,-1);
  }

  /**
   * Test getTotalPay method.
   */
  @Test
  public void testGetTotalPay() {
    HourlyPaycheck H = new HourlyPaycheck(100,30);
    assertEquals(3000.00, H.getTotalPay(), 0.01);
    HourlyPaycheck H2 = new HourlyPaycheck(10,50);
    assertEquals(550.00, H2.getTotalPay(), 0.01);
  }

  /**
   * Test of AddHoursWorked method.
   */
  @Test
  public void testAddHoursWorked() {
    HourlyPaycheck H = new HourlyPaycheck(100, 30);
    H.addHoursWorked(10);
    assertEquals(40, H.getHoursWorked(), 0.01);

    HourlyPaycheck H2 = new HourlyPaycheck(100, 30);
    H2.addHoursWorked(-10);
    assertEquals(20, H2.getHoursWorked(), 0.01);

    HourlyPaycheck H3 = new HourlyPaycheck(100, 30);
    H3.addHoursWorked(-40);
    assertEquals(0, H3.getHoursWorked(), 0.10);

    HourlyPaycheck H4 = new HourlyPaycheck(100, 30);
    H4.addHoursWorked(-30);
    assertEquals(0, H4.getHoursWorked(), 0.01);
  }

  /**
   * Test of resetHoursWorked method.
   */
  @Test
  public void testResetHoursWorked() {
    HourlyPaycheck H = new HourlyPaycheck(100, 30);
    H.resetHoursWorked();
    assertEquals(0, H.getHoursWorked(), 0.01);

    HourlyPaycheck H2 = new HourlyPaycheck(10, 0);
    H2.resetHoursWorked();
    assertEquals(0, H2.getHoursWorked(), 0.01);
  }

  /**
   * Test of getHoursWorked method.
   */
  @Test
  public void testGetHoursWorked() {
    HourlyPaycheck H = new HourlyPaycheck(100, 30);
    assertEquals(30, H.getHoursWorked(),0.01);
    HourlyPaycheck H2 = new HourlyPaycheck(10, 0);
    assertEquals(0, H2.getHoursWorked(),0.01);
  }
}