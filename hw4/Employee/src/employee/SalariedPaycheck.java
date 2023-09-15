package employee;

/**
 * SalariedPaycheck class.
 */
public class SalariedPaycheck extends Paycheck {
  private int payInterval;

  /**
   * Constructor of SalariedPaycheck.
   * @param payRate pay rate of Salaried Paycheck.
   * @param payInterval pay interval of Salaried Paycheck.
   * @throws IllegalArgumentException for pay interval and pay rate.
   */
  public SalariedPaycheck(double payRate, int payInterval) throws IllegalArgumentException {
    super(payRate);
    int weekly = 1;
    int biWeekly = 2;
    int quWeekly = 4;
    if (payInterval != weekly && payInterval != biWeekly && payInterval != quWeekly) {
      throw new IllegalArgumentException("Invalid pay interval is provided.");
    }
    if (payRate < 0) {
      throw new IllegalArgumentException("Invalid pay rate");
    }
    this.payInterval = payInterval;
  }

  /**
   * Method to calculate the total pay depends on Salaried Paycheck's pay interval.
   * @return pay interval.
   */
  @Override
  public double getTotalPay() {
    return (this.payRate / 52) * this.payInterval;
  }

  /**
   * Method to get the pay interval.
   * @return pay interval.
   */
  public int getPayInterval() {
    return this.payInterval;
  }
}
