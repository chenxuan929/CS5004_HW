package registration;

/**
 * Interface class jurisdiction.
 */
public interface IJurisdiction {

  /**
   * Calculate excise tax of vehicle.
   * @param vehicle vehicle.
   * @return 0.0
   */
  default double exciseTax(IVehicle vehicle) {
    return 0.0;
  }
}
