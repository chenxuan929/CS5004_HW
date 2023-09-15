package vehicles;

public class Plane implements IFlyingVehicle {
  private double currentSpeed;
  private final double maxSpeed;
  private boolean inAir;

  public Plane(double maxSpeed) {
    if (maxSpeed < 0) {
      throw new IllegalArgumentException("max speed can not be negative");
    }
    this.currentSpeed = 0;
    this.maxSpeed = maxSpeed;
    this.inAir = false;
  }


  @Override
  public void takeOff() {
    int defaultSpeed = 100;
    if (this.currentSpeed > defaultSpeed && !this.inAir) {
      this.inAir = true;
    }
  }

  @Override
  public void land() {
    this.currentSpeed = 10;
    this.inAir = false;
  }

  @Override
  public boolean inTheAir() {
    return this.inAir;
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
    if (!this.inAir) {
      this.currentSpeed = 0;
    }
  }
}
