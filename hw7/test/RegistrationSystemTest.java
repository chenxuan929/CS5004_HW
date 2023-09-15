import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import registration.Automobile;
import registration.BlueJurisdiction;
import registration.Boat;
import registration.IJurisdiction;
import registration.IRegistration;
import registration.IVehicle;
import registration.Motorcycle;
import registration.Person;
import registration.RedJurisdiction;
import registration.RegistrationSystem;

/**
 * RegistrationSystem test class.
 */
public class RegistrationSystemTest {
  private RegistrationSystem registrationSystem;

  /**
   * Test for GetInstance function.
   */
  @Test
  public void testGetInstance() {
    RegistrationSystem system1 = RegistrationSystem.getInstance();
    RegistrationSystem system2 = RegistrationSystem.getInstance();
    assertNotNull(system1);
    assertNotNull(system2);
    assertEquals(system1, system2);
  }

  /**
   * Test for CreateVehicle function.
   */
  @Test
  public void testCreateVehicle() {
    IVehicle boat = RegistrationSystem.getInstance()
        .createVehicle("BOAT", "Bayliner", 2005, 20000);
    assertNotNull(boat);
    assertTrue(boat instanceof Boat);

    IVehicle auto = RegistrationSystem.getInstance()
        .createVehicle("AUTO", "Toyota", 2015, 25000);
    assertNotNull(auto);
    assertTrue(auto instanceof Automobile);

    IVehicle motorcycle = RegistrationSystem.getInstance()
        .createVehicle("MOTORCYCLE", "Harley Davidson", 2020, 30000);
    assertNotNull(motorcycle);
    assertTrue(motorcycle instanceof Motorcycle);
  }

  /**
   * Test for CreateVehicleExceptions function.
   */
  @Test
  public void testCreateVehicleExceptions() {
    // Test null values for kind and make
    assertThrows(IllegalArgumentException.class, () -> registrationSystem.getInstance()
        .createVehicle(null, "make", 2000, 10000.0));
    assertThrows(IllegalArgumentException.class, () -> registrationSystem.getInstance()
        .createVehicle("kind", null, 2000, 10000.0));

    // Test empty values for kind and make
    assertThrows(IllegalArgumentException.class, () -> registrationSystem.getInstance()
        .createVehicle("", "make", 2000, 10000.0));
    assertThrows(IllegalArgumentException.class, () -> registrationSystem.getInstance()
        .createVehicle("kind", "", 2000, 10000.0));

    // Test invalid production year
    assertThrows(IllegalArgumentException.class, () -> registrationSystem.getInstance()
        .createVehicle("kind", "make", 1899, 10000.0));
    assertThrows(IllegalArgumentException.class, () -> registrationSystem.getInstance()
        .createVehicle("kind", "make", 2024, 10000.0));

    // Test negative purchase price
    assertThrows(IllegalArgumentException.class, () -> registrationSystem.getInstance()
        .createVehicle("kind", "make", 2000, -10000.0));

    // Test invalid vehicle kind
    assertNull(registrationSystem.getInstance()
        .createVehicle("bus", "make", 2000, 10000.0));
  }

  /**
   * Test for Register function.
   */
  @Test
  public void testRegister() {
    RegistrationSystem s = RegistrationSystem.getInstance();
    IVehicle vehicle = new Automobile("Toyota", 2022, 25000.0);
    IJurisdiction blue = new BlueJurisdiction();
    List<Person> owners = new ArrayList<>();

    owners.add(new Person("Ashley", "30 florence"));
    s.register(vehicle, blue, 2022, owners);
    List<IRegistration> registrations = s.getAllRegistrations();
    assertEquals(1, registrations.size());

    // Try to register the same vehicle again and see if repeat in registration.
    s.register(vehicle, blue, 2022, owners);
    registrations = s.getAllRegistrations();
    assertEquals(1, registrations.size());
  }

  /**
   * Test for GetAllRegistrations function.
   */
  @Test
  public void testGetAllRegistrations() {
    RegistrationSystem s = RegistrationSystem.getInstance();
    List<Person> owners = new ArrayList<>();
    owners.add(new Person("Ashley", "30 florence"));
    owners.add(new Person("Ella", "Brown"));
    owners.add(new Person("Frank", "Davis"));
    IVehicle vehicle = s.createVehicle("AUTO", "Toyota", 2022, 25000.0);
    IJurisdiction blue = new BlueJurisdiction();
    s.register(vehicle, blue, 2022, owners);
    List<IRegistration> r1 = s.getAllRegistrations();
    assertNotNull(r1);
    assertEquals(1, r1.size());
    assertEquals(3, owners.size());

    IJurisdiction red = new RedJurisdiction();
    s.register(vehicle, red, 2000, owners);
    assertEquals(2, r1.size());
  }

  /**
   * Test for GetFilteredList function.
   */
  @Test
  public void testGetFilteredList() {
    List<Person> owners1 = new ArrayList<>();
    List<Person> owners2 = new ArrayList<>();
    owners1.add(new Person("Ashley", "30 Florence"));
    owners2.add(new Person("Ella", "Brown"));
    owners2.add(new Person("Frank", "Davis"));
    owners2.add(new Person("Grace", "Wilson"));
    RegistrationSystem s = RegistrationSystem.getInstance();
    IVehicle vehicle1 = s.createVehicle("AUTO", "Toyota", 2022, 25000.0);
    IVehicle vehicle2 = s.createVehicle("MOTORCYCLE", "Honda", 2022, 15000.0);
    IJurisdiction blue = new BlueJurisdiction();
    IJurisdiction red = new RedJurisdiction();
    s.register(vehicle1, blue, 2022, owners1);
    s.register(vehicle2, red, 2021, owners2);

    List<IRegistration> result1 = s.getFilteredList(r -> r.getProductionYear() == 2022);
    assertEquals(2, result1.size());

    List<IRegistration> result2 = s.getFilteredList(r -> r.getOwners().size() == 3);
    assertEquals(1, result2.size());

    List<IRegistration> result3 = s.getFilteredList(r -> r.getRegistrationYear() == 2021);
    assertEquals(1, result3.size());
  }

  /**
   * Test for Reboot function.
   */
  @Test
  public void testReboot() {
    RegistrationSystem system = RegistrationSystem.getInstance();
    IVehicle vehicle = system.createVehicle("AUTO", "Toyota", 2022, 25000.0);
    IJurisdiction blue = new BlueJurisdiction();
    List<Person> owners = new ArrayList<>();
    owners.add(new Person("Ashley", "30 florence"));
    system.register(vehicle, blue, 2022, owners);
    List<IRegistration> registrations = system.getAllRegistrations();
    assertFalse(registrations.isEmpty());

    system.reboot();
    registrations = system.getAllRegistrations();
    assertTrue(registrations.isEmpty());
  }
}