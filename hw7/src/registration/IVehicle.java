package registration;

/**
 * IVehicle Interface.
 */
public interface IVehicle {

  /**
   * Get the type of vehicle.
   * @return type of vehicle.
   */
  String getVehicleType();

  /**
   * Get the make of vehicle.
   * @return make of vehicle.
   */
  String getMake();

  /**
   * Get the production year of vehicle.
   * @return production year of vehicle.
   */
  int getProductionYear();

  /**
   * Get the purchase price of vehicle.
   * @return purchase price of vehicle.
   */
  double getPurchasePrice();

  /**
   * Get the max passenger allowed in vehicle.
   * @return max passenger allowed in vehicle.
   */
  int getMaxPassenger();
}
