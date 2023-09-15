import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import registration.Automobile;
import registration.BlueJurisdiction;
import registration.Boat;
import registration.IJurisdiction;
import registration.IVehicle;
import registration.Motorcycle;


/**
 * Test class of BlueJurisdiction class.
 */
public class BlueJurisdictionTest {
  private IVehicle auto;
  private IVehicle motorcycle;
  private IVehicle boat;
  private IJurisdiction blueJurisdiction;

  /**
   * Initializes three IVehicle objects and a BlueJurisdiction object for use in testing.
   */
  @Before
  public void setUp() {
    auto = new Automobile("Toyota", 2000, 10000.0);
    motorcycle = new Motorcycle("Honda", 2005, 5000.0);
    boat = new Boat("Bayliner", 2015, 50000.0);

    blueJurisdiction = new BlueJurisdiction();
  }

  /**
   * Test exciseTax method.
   */
  @Test
  public void testExciseTax() {
    assertEquals(300.0, blueJurisdiction.exciseTax(auto), 0.01);
    assertEquals(150.0, blueJurisdiction.exciseTax(motorcycle), 0.01);
    assertEquals(1500.0, blueJurisdiction.exciseTax(boat), 0.01);

    // Test edge case where production year is less than 2000.
    IVehicle oldAuto = new Automobile("Old Car", 1999, 5000.0);
    assertEquals(249.0, blueJurisdiction.exciseTax(oldAuto), 0.01);
  }

  /**
   * Test toString method.
   */
  @Test
  public void testToString() {
    assertEquals("Blue Jurisdiction", blueJurisdiction.toString());
  }
}
