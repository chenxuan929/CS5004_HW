package registration;

/**
 * Class Red Jurisdiction.
 */
public class RedJurisdiction implements IJurisdiction {

  /**
   * Calculate the excise tax of vehicle.
   * @param vehicle vehicle.
   * @return excise tax amount.
   */
  @Override
  public double exciseTax(IVehicle vehicle) {
    double tax = 0.05;
    double excise = vehicle.getPurchasePrice() * tax;
    return excise;
  }

  /**
   * Return the name of jurisdiction.
   * @return name.
   */
  @Override
  public String toString() {
    return "Red Jurisdiction";
  }
}

