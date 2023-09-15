package registration;

/**
 * Class Blue Jurisdiction.
 */
public class BlueJurisdiction implements IJurisdiction {

  /**
   * Calculate the excise tax of vehicle.
   * @param vehicle vehicle.
   * @return excise tax amount.
   */
  @Override
  public double exciseTax(IVehicle vehicle) {
    double tax = 0.03;
    double excise = vehicle.getPurchasePrice() * tax;
    int yearStandard = 2000;
    int yearTax = 99;
    if (vehicle.getProductionYear() < yearStandard) {
      excise += yearTax;
    }
    return excise;
  }

  /**
   * Return the name of jurisdiction.
   * @return name.
   */
  @Override
  public String toString() {
    return "Blue Jurisdiction";
  }
}
