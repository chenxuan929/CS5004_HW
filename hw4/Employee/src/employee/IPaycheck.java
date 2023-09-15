package employee;

/**
 * Interface class called IPaycheck.
 */
public interface IPaycheck {
  /**
   * Method to get the total pay of employee.
   * @return total pay.
   */
  double getTotalPay();

  /**
   * Method to get the pay amount after taxes.
   * @return pay amount after taxes.
   */
  double getPayAfterTaxes();

  /**
   * Method to get the pay rate.
   * @return pay rate of employee.
   */
  double getPayRate();
}
