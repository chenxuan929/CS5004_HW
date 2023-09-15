package registration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class RegistrationSystem.
 */
public class RegistrationSystem {
  private static RegistrationSystem instance;
  private List<IRegistration> RegistrationList;

  /**
   * Private constructor to prevent instantiation from outside the class.
   */
  private RegistrationSystem() {
    RegistrationList = new ArrayList<>();
  }

  /**
   * Get the instance of Registration System.
   * @return instance.
   */
  public static RegistrationSystem getInstance() {
    if (instance == null) {
      instance = new RegistrationSystem();
    }
    return instance;
  }

  /**
   * Create a new vehicle in registration system.
   * @param kind kind of vehicle.
   * @param make make of vehicle.
   * @param productionYear production year of vehicle.
   * @param purchasePrice purchase price of vehicle.
   * @return new vehicle.
   * @throws IllegalArgumentException exceptions.
   */
  public IVehicle createVehicle(String kind, String make, int productionYear, double purchasePrice)
      throws  IllegalArgumentException {
    if (kind == null || make == null) {
      throw new IllegalArgumentException("Kind or make can not be null.");
    }
    if (kind.isEmpty() || make.isEmpty()) {
      throw new IllegalArgumentException("Kind or make can not be empty.");
    }
    int yearLowest = 1900;
    int yearHighest = 2023;
    if (productionYear < yearLowest || productionYear > yearHighest) {
      throw new IllegalArgumentException("Invalid production year, should between 1900 and 2023.");
    }
    if (purchasePrice < 0) {
      throw new IllegalArgumentException("Purchase price can not be negative.");
    }

    if (kind.equalsIgnoreCase("BOAT")) {
      return new Boat(make, productionYear, purchasePrice);
    }
    if (kind.equalsIgnoreCase("AUTO")) {
      return new Automobile(make, productionYear, purchasePrice);
    }
    if (kind.equalsIgnoreCase("MOTORCYCLE")) {
      return new Motorcycle(make, productionYear, purchasePrice);
    }
    else {
      return null;
    }
  }

  /**
   * Add a new registration.
   * @param vehicle the vehicle.
   * @param jurisdiction the jurisdiction of vehicle.
   * @param registrationYear the registration year of vehicle.
   * @param owners the owners of vehicle.
   */
  public void register(IVehicle vehicle, IJurisdiction jurisdiction,
                       int registrationYear, List<Person> owners) {
    Registration newRegister = new Registration(vehicle, jurisdiction, registrationYear, owners);
    if (!RegistrationList.contains(newRegister)) {
      RegistrationList.add(newRegister);
    }
  }

  /**
   * Get all the registrations in the system.
   * @return unmodifiable registration list.
   */
  public List<IRegistration> getAllRegistrations() {
    return Collections.unmodifiableList(RegistrationList);
  } // answer an unmodifiable list.

  /**
   * Get filtered list of registration.
   * @param query filter.
   * @return an unmodifiable list
   */
  public List<IRegistration> getFilteredList(Predicate<IRegistration> query) {
    return RegistrationList.stream().filter(query).collect(Collectors.toUnmodifiableList());
  } // answer an unmodifiable list.

  /**
   * Clear all registration system.
   */
  public void reboot() {
    RegistrationList.clear();
  } // reset the system to initial "start state"
}
