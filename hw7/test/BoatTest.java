import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import registration.Boat;

/**
 * Test class of Automobile class.
 */
public class BoatTest {
  private Boat boat1;
  private Boat boat2;
  private Boat boat3;

  /**
   * Initializes three Boat objects for use in testing.
   */
  @Before
  public void setUp() {
    boat1 = new Boat("Bayliner", 2015, 50000.0);
    boat2 = new Boat("Mastercraft", 2018, 70000.0);
    boat3 = new Boat("Sea Ray", 2021, 90000.0);
  }

  /**
   * Test GetVehicleType class.
   */
  @Test
  public void testGetVehicleType() {
    assertEquals("Boat", boat1.getVehicleType());
    assertEquals("Boat", boat2.getVehicleType());
    assertEquals("Boat", boat3.getVehicleType());
  }

  /**
   * Test GetMake class.
   */
  @Test
  public void testGetMake() {
    assertEquals("Bayliner", boat1.getMake());
    assertEquals("Mastercraft", boat2.getMake());
    assertEquals("Sea Ray", boat3.getMake());
  }

  /**
   * Test GetProductionYear class.
   */
  @Test
  public void testGetProductionYear() {
    assertEquals(2015, boat1.getProductionYear());
    assertEquals(2018, boat2.getProductionYear());
    assertEquals(2021, boat3.getProductionYear());
  }

  /**
   * Test GetPurchasePrice class.
   */
  @Test
  public void testGetPurchasePrice() {
    assertEquals(50000.0, boat1.getPurchasePrice(), 0.0);
    assertEquals(70000.0, boat2.getPurchasePrice(), 0.0);
    assertEquals(90000.0, boat3.getPurchasePrice(), 0.0);
  }

  /**
   * Test GetMaxPassenger class.
   */
  @Test
  public void testGetMaxPassenger() {
    assertEquals(10, boat1.getMaxPassenger());
    assertEquals(10, boat2.getMaxPassenger());
    assertEquals(10, boat3.getMaxPassenger());
  }
}