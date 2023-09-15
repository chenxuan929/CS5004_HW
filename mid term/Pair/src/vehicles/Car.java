package vehicles;
public class Car implements IVehicle {
  private double currentSpeed;
  private final double maxSpeed;

  public Car (double maxSpeed) {
    this.currentSpeed = 0;
    this.maxSpeed = maxSpeed;
    if (maxSpeed < 0) {
      throw new IllegalArgumentException("max speed can not be negative");
    }
  }

  @Override
  public double getCurrentSpeed() {
    return this.currentSpeed;
  }

  @Override
  public void accelerate(double delta) {
    double cur = this.currentSpeed + delta;
    if (cur > this.maxSpeed) {
      this.currentSpeed = this.maxSpeed;
    }
    if (cur <= 0) {
      this.currentSpeed = 0;
    }
  }

  @Override
  public void park() {
    this.currentSpeed = 0;
  }
}
