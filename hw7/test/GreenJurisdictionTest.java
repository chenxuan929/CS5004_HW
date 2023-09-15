import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import registration.Automobile;
import registration.Boat;
import registration.GreenJurisdiction;
import registration.IJurisdiction;
import registration.IVehicle;
import registration.Motorcycle;


/**
 * Test class of GreenJurisdiction class.
 */
public class GreenJurisdictionTest {
  private IVehicle auto;
  private IVehicle motorcycle;
  private IVehicle boat;
  private IJurisdiction greenJurisdiction;

  /**
   * Initializes three IVehicle objects and a GreenJurisdiction object for use in testing.
   */
  @Before
  public void setUp() {
    auto = new Automobile("Toyota", 2000, 10000.0);
    motorcycle = new Motorcycle("Honda", 2005, 5000.0);
    boat = new Boat("Bayliner", 2015, 50000.0);
    greenJurisdiction = new GreenJurisdiction();
  }

  /**
   * Test exciseTax method.
   */
  @Test
  public void testExciseTax() {
    assertEquals(900.0, greenJurisdiction.exciseTax(auto), 0.01);
    assertEquals(400.0, greenJurisdiction.exciseTax(motorcycle), 0.01);
    assertEquals(3000.0, greenJurisdiction.exciseTax(boat), 0.01);
  }

  /**
   * Test toString method.
   */
  @Test
  public void testToString() {
    assertEquals("Green Jurisdiction", greenJurisdiction.toString());
  }
}
