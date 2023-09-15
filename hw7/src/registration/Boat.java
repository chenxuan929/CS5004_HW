package registration;

/**
 * Class Boats.
 */
public class Boat implements IVehicle {
  private final String make;
  private final int yearP;
  private final double priceP;
  private final String type;
  private final int maxP;

  /**
   * Constructor of Boats class.
   * @param make make of vehicle.
   * @param yearP production year of vehicle.
   * @param priceP purchase price of vehicle.
   */
  public Boat(String make, int yearP, double priceP) {
    this.make = make;
    this.yearP = yearP;
    this.priceP = priceP;
    this.type = "Boat";
    this.maxP = 10;
  }

  /**
   * Get the type of vehicle.
   *
   * @return type of vehicle.
   */
  @Override
  public String getVehicleType() {
    return this.type;
  }

  /**
   * Get the make of vehicle.
   *
   * @return make of vehicle.
   */
  @Override
  public String getMake() {
    return this.make;
  }

  /**
   * Get the production year of vehicle.
   *
   * @return production year of vehicle.
   */
  @Override
  public int getProductionYear() {
    return this.yearP;
  }

  /**
   * Get the purchase price of vehicle.
   *
   * @return purchase price of vehicle.
   */
  @Override
  public double getPurchasePrice() {
    return this.priceP;
  }

  /**
   * Get the max passenger allowed in vehicle.
   *
   * @return max passenger allowed in vehicle.
   */
  @Override
  public int getMaxPassenger() {
    return this.maxP;
  }
}
