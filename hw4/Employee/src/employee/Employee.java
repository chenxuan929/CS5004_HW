package employee;

import java.text.DecimalFormat;

/**
 * Employee class contains two kinds of employees: salaried and hourly.
 */
public class Employee {
  private String name;
  private String id;
  private double payRate;
  private int payInterval;
  private boolean isManager;
  private double hoursWorked;
  private IPaycheck NewPaycheck;

  /**
   * Constructor of Salaried employee.
   * @param name name of employee.
   * @param id id of employee.
   * @param payRate pay rate of employee.
   * @param payInterval frequently the employee is paid.
   * @param isManager if the employee is manager.
   */
  public Employee(String name, String id, double payRate, int payInterval, boolean isManager ) {
    int weekly = 1;
    int biWeekly = 2;
    int quWeekly = 4;
    if (payInterval != weekly && payInterval != biWeekly && payInterval != quWeekly ) {
      throw new IllegalArgumentException("Invalid pay interval is provided.");
    }
    if (name == null || id == null || name.length() == 0 || id.length() == 0 ) {
      throw new IllegalArgumentException("Invalid name or id provided.");
    }
    if (payRate < 0 || hoursWorked < 0) {
      throw new IllegalArgumentException("Pay rate or hours worked can not be negative.");
    }
    this.name = name;
    this.id = id;
    this.payRate = payRate;
    this.payInterval = payInterval;
    this.isManager = isManager;
    this.hoursWorked = -1;
    this.NewPaycheck = null;
  }

  /**
   * Constructor of hourly employee.
   * @param name name of employee.
   * @param id id of employee.
   * @param payRate pay rate of employee.
   * @param hoursWorked the number of hours the employee worked.
   */
  public Employee(String name, String id, double payRate, double hoursWorked) {
    int leastPayRate = 0;
    int leastHoursWorked = 0;
    if (name == null || id == null || name.length() == 0 || id.length() == 0 ) {
      throw new IllegalArgumentException("Invalid name or id provided.");
    }
    if (payRate < leastPayRate || hoursWorked < leastHoursWorked) {
      throw new IllegalArgumentException("Pay rate or hours worked can not be negative.");
    }
    this.name = name;
    this.id = id;
    this.payRate = payRate;
    this.isManager = false;
    this.hoursWorked = hoursWorked;
    this.NewPaycheck = null;
  }

  /**
   * Method to check if this employee is manager.
   */
  public boolean isManager() {
    return this.isManager;
  }

  /**
   * Method to get employee's name.
   * }
   */
  public String getName() {
    return this.name;
  }

  /**
   * Method to get employee's id.
   */
  public String getId() {
    return this.id;
  }

  /**
   * Method to get employee's pay rate.
   */
  public double getPayRate() {
    return this.payRate;
  }

  /**
   * Method to get employee's pay internal.
   */
  public int getPayInterval() {
    return this.payInterval;
  }

  /**
   * Method to get employee's work hours.
   */
  public double getHoursWorked() {
    return this.hoursWorked;
  }

  /**
   * Method to get employee's pay check.
   */
  public IPaycheck getPaycheck() {
    if (this.NewPaycheck == null) {
      if (this.hoursWorked == -1) {
        this.NewPaycheck = new SalariedPaycheck(this.payRate, this.payInterval);
      }  else {
        this.NewPaycheck = new HourlyPaycheck(this.payRate, this.hoursWorked);
      }
    }
    return this.NewPaycheck;
  }

  /**
   * Override to string method.
   * @return string.
   */
  @Override
  public String toString() {
    IPaycheck paycheck = getPaycheck();
    DecimalFormat df = new DecimalFormat("0.00");
    String myString = "Name: " + this.name + "\n" + "ID: " + this.id
        + "\n" + "Payment after taxes: $ " + df.format(paycheck.getPayAfterTaxes());
    return myString;
  }
}
