import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import registration.Automobile;

/**
 * Test class of Automobile class.
 */
public class AutomobileTest {
  private Automobile automobile1;
  private Automobile automobile2;
  private Automobile automobile3;

  /**
   * Initializes three Automobile objects for use in testing.
   */
  @Before
  public void setUp() {
    automobile1 = new Automobile("Honda", 2020, 25000.0);
    automobile2 = new Automobile("Toyota", 2019, 20000.0);
    automobile3 = new Automobile("Ford", 2022, 30000.0);
  }

  /**
   * Test GetVehicleType class.
   */
  @Test
  public void testGetVehicleType() {
    assertEquals("Automobiles", automobile1.getVehicleType());
    assertEquals("Automobiles", automobile2.getVehicleType());
    assertEquals("Automobiles", automobile3.getVehicleType());
  }

  /**
   * Test GetMake class.
   */
  @Test
  public void testGetMake() {
    assertEquals("Honda", automobile1.getMake());
    assertEquals("Toyota", automobile2.getMake());
    assertEquals("Ford", automobile3.getMake());
  }

  /**
   * Test GetProductionYear class.
   */
  @Test
  public void testGetProductionYear() {
    assertEquals(2020, automobile1.getProductionYear());
    assertEquals(2019, automobile2.getProductionYear());
    assertEquals(2022, automobile3.getProductionYear());
  }

  /**
   * Test GetPurchasePrice class.
   */
  @Test
  public void testGetPurchasePrice() {
    assertEquals(25000.0, automobile1.getPurchasePrice(), 0.001);
    assertEquals(20000.0, automobile2.getPurchasePrice(), 0.001);
    assertEquals(30000.0, automobile3.getPurchasePrice(), 0.001);
  }

  /**
   * Test GetMaxPassenger class.
   */
  @Test
  public void testGetMaxPassenger() {
    assertEquals(5, automobile1.getMaxPassenger());
    assertEquals(5, automobile2.getMaxPassenger());
    assertEquals(5, automobile3.getMaxPassenger());
  }
}

