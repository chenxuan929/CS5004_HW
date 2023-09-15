import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import registration.Motorcycle;

/**
 * Test class of Motorcycle class.
 */
public class MotorcycleTest {
  private Motorcycle motorcycle1;
  private Motorcycle motorcycle2;
  private Motorcycle motorcycle3;

  /**
   * Initializes three Motorcycle objects for use in testing.
   */
  @Before
  public void setUp() {
    motorcycle1 = new Motorcycle("Harley-Davidson", 2015, 20000.0);
    motorcycle2 = new Motorcycle("Ducati", 2018, 25000.0);
    motorcycle3 = new Motorcycle("Kawasaki", 2021, 30000.0);
  }

  /**
   * Test GetVehicleType method.
   */
  @Test
  public void testGetVehicleType() {
    assertEquals("Motorcycles", motorcycle1.getVehicleType());
    assertEquals("Motorcycles", motorcycle2.getVehicleType());
    assertEquals("Motorcycles", motorcycle3.getVehicleType());
  }

  /**
   * Test GetMake method.
   */
  @Test
  public void testGetMake() {
    assertEquals("Harley-Davidson", motorcycle1.getMake());
    assertEquals("Ducati", motorcycle2.getMake());
    assertEquals("Kawasaki", motorcycle3.getMake());
  }

  /**
   * Test GetProductionYear method.
   */
  @Test
  public void testGetProductionYear() {
    assertEquals(2015, motorcycle1.getProductionYear());
    assertEquals(2018, motorcycle2.getProductionYear());
    assertEquals(2021, motorcycle3.getProductionYear());
  }

  /**
   * Test GetPurchasePrice method.
   */
  @Test
  public void testGetPurchasePrice() {
    assertEquals(20000.0, motorcycle1.getPurchasePrice(), 0.0);
    assertEquals(25000.0, motorcycle2.getPurchasePrice(), 0.0);
    assertEquals(30000.0, motorcycle3.getPurchasePrice(), 0.0);
  }

  /**
   * Test GetMaxPassenger method.
   */
  @Test
  public void testGetMaxPassenger() {
    assertEquals(2, motorcycle1.getMaxPassenger());
    assertEquals(2, motorcycle2.getMaxPassenger());
    assertEquals(2, motorcycle3.getMaxPassenger());
  }
}
