import java.text.DecimalFormat;

/**
 *Chenxuan Xu  - CS5004 HW_01
 *This class represents an electric vehicle. A vehicle has the following attributes:
 *names, battery size, state of charge, current efficiency, default efficiency.
 */
public class ElectricVehicle {
  private String names;
  private double batterySize;
  private double stateOfCharge;
  private double currentEfficiency;
  private final double defaultEfficiency;

  private void setSoc(double stateOfCharge) {
    if (stateOfCharge > 1.0) {
      this.stateOfCharge = 1.0;
    } else this.stateOfCharge = Math.max(stateOfCharge, 0.15);
  }

  /**
   * params in ElectricVehicle class.
   * names: the name of the electric vehicle.
   * batterySize: the battery size of the electric vehicle.
   * stateOfCharge: the state of charge of the electric vehicle.
   * defaultEfficiency: default efficiency of the electric vehicle.
   */
  public ElectricVehicle(String names, double batterySize,
                           double stateOfCharge, double defaultEfficiency) {
    this.names = names;
    this.batterySize = batterySize;
    this.stateOfCharge = stateOfCharge;

    if (this.batterySize < 10.0) this.batterySize = 10;
    if (this.batterySize > 150.0) this.batterySize = 150.0;

    if (this.stateOfCharge < 0.15) this.stateOfCharge = 0.15;
    if (this.stateOfCharge > 1.0) this.stateOfCharge = 1.0;

    if (defaultEfficiency < 0.5) this.defaultEfficiency = 0.5;
    else this.defaultEfficiency = Math.min(defaultEfficiency, 4.5);
    this.currentEfficiency = this.defaultEfficiency;

    if (this.names == null) this.names = "unknown EV";
    if (this.names.equals("")) this.names = "unknown EV";
  }


  /**
   * Set the value of state of charge in the specific range.
   */
  public void setStateOfCharge(double stateOfCharge) {
    setSoc(stateOfCharge);
  }


  /**
   * This method is to calculate the range of the EV.
   * Return the range of EV.
   */
  public double range() {
    return this.currentEfficiency * this.stateOfCharge * this.batterySize;
  }

  /**
   * This method is to update the efficiency of EV by specific range of current temperature value.
   * param currentTemp: current temperature in Fahrenheit.
   */
  public void updateEfficiency(double currentTemp) {
    if (currentTemp > 77.0) {
      this.currentEfficiency = 0.85 * this.defaultEfficiency;
    } else if ( currentTemp >= 15.0 && currentTemp < 65.0) {
      this.currentEfficiency = this.defaultEfficiency * ( 1 - ((65.0 - currentTemp) * 0.01));
    } else if (currentTemp < 15.0) {
      this.currentEfficiency = 0.5 * this.defaultEfficiency;
    } else {
      this.currentEfficiency = this.defaultEfficiency;
    }
  }


  /**
   * This method is to get the efficiency of EV.
   * return current efficiency of EV.
   */
  public double getEfficiency() {
    return this.currentEfficiency;
  }


  /**
   * This method is to get the battery size of EV.
   * return battery size of EV.
   */
  public double getBatterySize() {
    return this.batterySize;
  }


  /**
   * This method is to get the state of charge of EV.
   * return the state of charge of EV.
   */
  public double getStateOfCharge() {
    return this.stateOfCharge;
  }


  /**
   * This method is to get the name of EV.
   * return the name of EV.
   */
  public String getName() {
    return this.names;
  }



  /**
   * This method make EV objects to be represented as a String.
   * return the format string of EV.
   */
  @Override
  public String toString() {
    DecimalFormat df = new DecimalFormat("#.0%");
    return String.format("%s SOC: %s Range (miles): %.1f",
                getName(), df.format(this.stateOfCharge * 1.0), range());
  }

}




