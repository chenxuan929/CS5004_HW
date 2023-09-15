package registration;

import java.util.Collections;
import java.util.List;

/**
 * Registration class.
 */
public class Registration implements IRegistration {
  private int registrationYear;
  private IVehicle vehicle;
  private IJurisdiction jurisdiction;
  private List<Person> owner;

  /**
   * Constructor of registration class.
   * @param vehicle the vehicle.
   * @param jurisdiction the jurisdiction of the vehicle.
   * @param registrationYear the registration year of the vehicle.
   * @param owner the owner of the vehicle.
   */
  public Registration(IVehicle vehicle, IJurisdiction jurisdiction,
                      int registrationYear, List<Person> owner) {
    this.registrationYear = registrationYear;
    this.vehicle = vehicle;
    this.jurisdiction = jurisdiction;
    this.owner = Collections.unmodifiableList(owner);
  }

  /**
   * Get the registration year of vehicle.
   *
   * @return registration year of vehicle.
   */
  @Override
  public int getRegistrationYear() {
    return this.registrationYear;
  }

  /**
   * Get the production year of vehicle.
   *
   * @return production year of vehicle.
   */
  @Override
  public int getProductionYear() {
    return this.vehicle.getProductionYear();
  }

  /**
   * Get the jurisdiction of vehicle.
   *
   * @return jurisdiction of vehicle.
   */
  @Override
  public IJurisdiction getJurisdiction() {
    return this.jurisdiction;
  }

  /**
   * Get owner of vehicle.
   *
   * @return owner of vehicle.
   */
  @Override
  public List<Person> getOwners() {
    return this.owner;
  }

  /**
   * Get the max passengers of vehicle.
   *
   * @return max passengers of vehicle.
   */
  @Override
  public int getMaxPassengers() {
    return this.vehicle.getMaxPassenger();
  }

  /**
   * Calculate the excise tax of vehicle.
   *
   * @return excise tax of vehicle.
   */
  @Override
  public double calculateExciseTax() {
    return this.jurisdiction.exciseTax(vehicle);
  }

  /**
   * To string method.
   *
   * @return string.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("Registration:").append("\n");
    sb.append(vehicle.getVehicleType().toUpperCase()).append(": ")
        .append(vehicle.getMake()).append(" Year(")
        .append(vehicle.getProductionYear()).append(") Price = $")
        .append(String.format("%.2f", vehicle
          .getPurchasePrice())).append("\n").append("Owned By: ");

    for (int i = 0; i < owner.size(); i++) {
      sb.append(owner.get(i).getName()).append(", ").append(owner.get(i).getAddress()).append("; ");
    }
    sb.delete(sb.length() - 2, sb.length());

    sb.append("\n").append("Year: ").append(this.registrationYear)
        .append("\nExcise Tax: $").append(String.format("%.2f", calculateExciseTax()));
    return sb.toString();
  }

  /**
   * Equal methods.
   * @param o object.
   * @return a boolean.
   */
  @Override
  public boolean equals(Object o) {
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (o == this) {
      return true;
    }
    Registration other = (Registration) o;
    return this.registrationYear == other.registrationYear
        && this.vehicle.equals(other.vehicle)
        && this.owner.equals(other.owner);
  }

  /**
   * Hash code method.
   * @return hash code.
   */
  @Override
  public int hashCode() {
    int answer = 17;
    answer = 31 * answer + registrationYear;
    answer = 31 * answer + vehicle.hashCode();
    answer = 31 * answer + owner.hashCode();
    return answer;
  }
}
