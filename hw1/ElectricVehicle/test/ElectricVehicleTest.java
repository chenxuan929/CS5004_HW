import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the ElectricVehicleTest class.
 * Two test are set: Toyota, Benz.
 */
public class ElectricVehicleTest {
  private ElectricVehicle Toyota;
  private ElectricVehicle Benz;


  /**
   * Set up values for test EV examples.
   */
  @Before
  public void setUp() {
    this.Toyota = new ElectricVehicle("Toyota_Supra", 160.5, 0.14,5);
    this.Benz = new ElectricVehicle("Benz_AMG",100, 0.5, 1 );
  }


  /**
  * Test for range of EV.
  * formula: current efficiency * state of charge * battery size.
  * expected output: Toyota range: 4.5 * 0.15 * 150 = 101.25
  *                  Benz range: 1 * 0.5 * 100 = 50.0
  */
  @org.junit.Test
  public void range_test() {
    assertEquals(101.25, Toyota.range(), 0.01);
    assertEquals(50.0, Benz.range(), 0.01);
  }


  /**
   * Test for updating the efficiency of EV by current temperature.
   * expected output: Toyota in tempe1: 4.5 * 100% = 4.5
   *                  Benz in tempe2: 1(1-(65 - 64)* 0.01) = 0.99
   *                  Toyota in tempe3: 4.5 * 85% = 3.825
   */
  @org.junit.Test
  public void updateEfficiency_test() {
    double tempe1 = 75.0;
    double tempe2 = 64.0;
    double tempe3 = 88.0;

    Toyota.updateEfficiency(tempe1);
    assertEquals(4.5, Toyota.getEfficiency(), 0.01);

    Benz.updateEfficiency(tempe2);
    assertEquals(0.99, Benz.getEfficiency(), 0.01);

    Toyota.updateEfficiency(tempe1);
    assertEquals(3.825, Toyota.getEfficiency(), 0.01);
  }


  /**
  * Test for getting the current efficiency of EV.
  */
  @org.junit.Test
  public void getEfficiency_test() {
    assertEquals(4.5, Toyota.getEfficiency(), 0.01);
    assertEquals(1, Benz.getEfficiency(), 0.01);
  }


  /**
  * Test for getting battery size of EV.
  */
  @org.junit.Test
  public void getBatterySize_test() {
    assertEquals(150, Toyota.getBatterySize(), 0.01);
    assertEquals(100, Benz.getBatterySize(), 0.01);
  }


  /**
  * Test for get the state of charge of EV.
  */
  @org.junit.Test
  public void getStateOfCharge_test() {
    assertEquals(0.15, Toyota.getStateOfCharge(), 0.01);
    assertEquals(0.5, Benz.getStateOfCharge(), 0.01);
  }


  /**
  * Test for getting the name of EV.
  */
  @org.junit.Test
  public void getName_test() {
    assertEquals("Toyota_Supra", Toyota.getName());
    assertEquals("Benz_AMG", Benz.getName());
  }


  /**
  * Test for string output of information of EV.
  */
  @org.junit.Test
  public void testToString_test() {
    assertEquals("Toyota_Supra SOC: 15.0% Range (miles): 101.2", Toyota.toString());
    assertEquals("Benz_AMG SOC: 50.0% Range (miles): 50.0", Benz.toString());
  }
}