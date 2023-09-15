package employee;

/**
 * HourlyPaycheck class.
 */
public class HourlyPaycheck extends Paycheck {
  private double hoursWorked;
  private double totalPay;


  /**
   * Constructor of HourlyPaycheck.
   * @param payRate pay rate of Salaried Paycheck.
   * @param hoursWorked working hours.
   * @throws IllegalArgumentException for hours worked.
   */
  public HourlyPaycheck(double payRate, double hoursWorked) throws IllegalArgumentException {
    super(payRate);
    int leastPayRate = 0;
    int leastHoursWorked = 0;
    if (payRate < leastPayRate || hoursWorked < leastHoursWorked) {
      throw new IllegalArgumentException("Pay rate or hours worked can not be negative.");
    }
    this.hoursWorked = hoursWorked;
  }

  /**
   * Method to calculate total pay.
   */
  @Override
  public double getTotalPay() {
    int standardHours = 40;
    double overTimeRate = 1.5;
    if (this.hoursWorked <= standardHours) {
      totalPay = this.payRate * this.hoursWorked;
    } else {
      totalPay = this.payRate * (standardHours + (hoursWorked - standardHours) * overTimeRate);
    }
    return totalPay;
  }

  /**
   * Method to add or subtract hours to current worked hours.
   * @param hoursAdded the number of adding hours.
   */
  public void addHoursWorked(double hoursAdded) {
    if (this.hoursWorked + hoursAdded < 0) {
      this.hoursWorked = 0;
    } else {
      this.hoursWorked = this.hoursWorked + hoursAdded;
    }
    totalPay = getTotalPay();
  }

  /**
   * Method to reset the current working hours to zero.
   */
  public void resetHoursWorked() {
    this.hoursWorked = 0;
  }

  /**
   * Method to get current working hours.
   * @return hours employee worked.
   */
  public double getHoursWorked() {
    return this.hoursWorked;
  }
}

