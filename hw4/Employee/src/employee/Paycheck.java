package employee;

import java.text.DecimalFormat;

/**
 * Abstract class paycheck implements IPaycheck class.
 */
public abstract class Paycheck implements IPaycheck {
  protected double payRate;
  protected double beforeTax;

  /**
   * Constructor of Paycheck.
   * @param payRate pay rate of paycheck.
   */
  public Paycheck(double payRate) {
    double LimitPayRate = 0;
    if (payRate < LimitPayRate) {
      throw new IllegalArgumentException("Invalid pay rate, should be larger than 0");
    }
    this.payRate = payRate;
  }

  /**
   * Get total pay of the employee.
   * @return total pay.
   */
  public abstract double getTotalPay();


  /**
   * Get the pay for employee after taxes.
   * @return pay after taxes.
   */
  public double getPayAfterTaxes() {
    beforeTax = getTotalPay();
    int standardPay = 400;
    double lowRate = 0.1;
    double highRate = 0.15;
    double payAfterTaxes;

    if (beforeTax < standardPay) {
      payAfterTaxes = beforeTax * (1 - lowRate);
    }
    else {
      payAfterTaxes = beforeTax * (1 - highRate);
    }

    double roundLow = 0;
    double roundHigh = 0.01;
    if (payAfterTaxes > roundLow && payAfterTaxes < roundHigh ) {
      payAfterTaxes = 0.01;
    }
    return payAfterTaxes;
  }

  /**
   * Get the pay rate for employee.
   * @return pay rate.
   */
  public double getPayRate() {
    return this.payRate;
  }

  /**
   * Override toString method.
   */
  @Override
  public String toString() {
    DecimalFormat df = new DecimalFormat("0.00");
    return "Payment after taxes: $ " + df.format(getPayAfterTaxes());
  }
}
