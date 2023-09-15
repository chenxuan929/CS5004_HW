import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import registration.Automobile;
import registration.Boat;
import registration.IJurisdiction;
import registration.IVehicle;
import registration.Motorcycle;
import registration.RedJurisdiction;


/**
 * Test class of RedJurisdiction class.
 */
public class RedJurisdictionTest {
  private IVehicle auto;
  private IVehicle motorcycle;
  private IVehicle boat;
  private IJurisdiction redJurisdiction;

  /**
   * Initializes three IVehicle objects and a RedJurisdiction object for use in testing.
   */
  @Before
  public void setUp() {
    auto = new Automobile("Toyota", 2000, 10000.0);
    motorcycle = new Motorcycle("Honda", 2005, 5000.0);
    boat = new Boat("Bayliner", 2015, 50000.0);

    redJurisdiction = new RedJurisdiction();
  }

  /**
   * Test exciseTax method.
   */
  @Test
  public void testExciseTax() {
    assertEquals(500.0, redJurisdiction.exciseTax(auto), 0.01);
    assertEquals(250.0, redJurisdiction.exciseTax(motorcycle), 0.01);
    assertEquals(2500.0, redJurisdiction.exciseTax(boat), 0.01);
  }

  /**
   * Test toString method.
   */
  @Test
  public void testToString() {
    assertEquals("Red Jurisdiction", redJurisdiction.toString());
  }
}
