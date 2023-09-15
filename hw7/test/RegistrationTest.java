import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import registration.Automobile;
import registration.BlueJurisdiction;
import registration.Boat;
import registration.GreenJurisdiction;
import registration.IJurisdiction;
import registration.IVehicle;
import registration.Motorcycle;
import registration.Person;
import registration.RedJurisdiction;
import registration.Registration;


/**
 * Test Registration class.
 */
public class RegistrationTest {
  private Registration registration1;
  private Registration registration2;
  private Registration registration3;
  private Registration registration4;
  private Person owner1;
  private Person owner2;
  private Person owner3;

  /**
   * Initializes Person and Registration objects for use in testing.
   */
  @Before
  public void setUp() {
    owner1 = new Person("Ashley", "30 florence");
    owner2 = new Person("Jane", "19 brookline");
    owner3 = new Person("Kate", "NEU");

    IJurisdiction blue = new BlueJurisdiction();
    IJurisdiction red = new RedJurisdiction();
    IJurisdiction green = new GreenJurisdiction();
    IVehicle auto = new Automobile("Ford", 2000, 10000);
    IVehicle boat = new Boat("Some", 1990, 3000);
    IVehicle moto = new Motorcycle("Any", 2020, 1000);

    registration1 = new Registration(auto, blue, 2023, Arrays.asList(owner1));
    registration2 = new Registration(boat, red, 2012, Arrays.asList(owner1, owner2));
    registration3 = new Registration(moto, green, 2000, Arrays.asList(owner3, owner2));

    registration4 = new Registration(boat, red, 2012, Arrays.asList(owner1, owner2));
  }

  /**
   * Test GetRegistrationYear function.
   */
  @Test
  public void testGetRegistrationYear() {
    assertEquals(2023, registration1.getRegistrationYear());
    assertEquals(2012, registration2.getRegistrationYear());
    assertEquals(2000, registration3.getRegistrationYear());
  }

  /**
   * Test GetProductionYear function.
   */
  @Test
  public void testGetProductionYear() {
    assertEquals(2000, registration1.getProductionYear());
    assertEquals(1990, registration2.getProductionYear());
    assertEquals(2020, registration3.getProductionYear());
  }

  /**
   * Test GetJurisdiction function.
   */
  @Test
  public void testGetJurisdiction() {
    assertEquals("Blue Jurisdiction", registration1.getJurisdiction().toString());
    assertEquals("Red Jurisdiction", registration2.getJurisdiction().toString());
    assertEquals("Green Jurisdiction", registration3.getJurisdiction().toString());
  }

  /**
   * Test GetOwners function.
   */
  @Test
  public void testGetOwners() {
    List<Person> owners1 = registration1.getOwners();
    assertEquals(1, owners1.size());
    assertEquals(owner1, owners1.get(0));

    List<Person> owners2 = registration2.getOwners();
    assertEquals(2, owners2.size());
    assertEquals(owner1, owners2.get(0));
    assertEquals(owner2, owners2.get(1));

    List<Person> owners3 = registration3.getOwners();
    assertEquals(2, owners3.size());
    assertEquals(owner3, owners3.get(0));
    assertEquals(owner2, owners3.get(1));
  }

  /**
   * Test GetMaxPassengers function.
   */
  @Test
  public void testGetMaxPassengers() {
    assertEquals(5, registration1.getMaxPassengers());
    assertEquals(10, registration2.getMaxPassengers());
    assertEquals(2, registration3.getMaxPassengers());
  }

  /**
   * Test CalculateExciseTax function.
   */
  @Test
  public void testCalculateExciseTax() {
    assertEquals(300.0, registration1.calculateExciseTax(), 0.01);
    assertEquals(150.0, registration2.calculateExciseTax(), 0.01);
    assertEquals(240.0, registration3.calculateExciseTax(), 0.01);
  }

  /**
   * Test equals function.
   */
  @Test
  public void testEquals() {
    assertNotEquals(null, registration1);
    assertEquals(registration4, registration2);
    assertNotEquals(registration4, registration3);
    assertNotEquals(registration4, registration1);
  }

  /**
   * Test toString function.
   */
  @Test
  public void testToString() {
    String s1 = "Registration:\nAUTO: Ford Year(2000) Price = $10000.00\n"
        + "Owned By: Ashley, 30 florence\nYear: 2023\nExcise Tax: $300.00";
    assertEquals(s1, registration1.toString());

    String s2 = "Registration:\nBOAT: Some Year(1990) Price = $3000.00\n"
        + "Owned By: Ashley, 30 florence; Jane, 19 brookline\nYear: 2012\nExcise Tax: $150.00";
    assertEquals(s2, registration2.toString());

    String s3 = "Registration:\nMOTORCYCLE: Any Year(2020) Price = $1000.00\n"
        + "Owned By: Kate, NEU; Jane, 19 brookline\nYear: 2000\nExcise Tax: $240.00";
    assertEquals(s3, registration3.toString());
  }
}