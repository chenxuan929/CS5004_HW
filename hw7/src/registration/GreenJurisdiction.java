package registration;

/**
 * Class Green Jurisdiction.
 */
public class GreenJurisdiction implements IJurisdiction {

  /**
   * Calculate the excise tax of vehicle.
   * @param vehicle vehicle.
   * @return excise tax amount.
   */
  @Override
  public double exciseTax(IVehicle vehicle) {
    double tax = 0.04;
    double excise = vehicle.getPurchasePrice() * tax
        + vehicle.getMaxPassenger() * 100;
    return excise;
  }

  /**
   * Return the name of jurisdiction.
   * @return name.
   */
  @Override
  public String toString() {
    return "Green Jurisdiction";
  }
}


