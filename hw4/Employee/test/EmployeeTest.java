import static org.junit.Assert.assertEquals;

import employee.Employee;
import employee.HourlyPaycheck;
import employee.IPaycheck;
import employee.SalariedPaycheck;
import org.junit.Test;


/**
 * Test for employee class.
 */
public class EmployeeTest {
  /**
   * Test the constructor of SalariedPaycheck.
   */
  @Test
  public void testSalariedConstructor() {
    Employee Salaried = new Employee("X", "929", 30.00,1,true);
    assertEquals("X", Salaried.getName());
    assertEquals("929", Salaried.getId());
    assertEquals(30.00, Salaried.getPayRate(),0.01);
    assertEquals(1, Salaried.getPayInterval(),0.01);
    assertEquals(true, Salaried.isManager());

    Employee Salaried2 = new Employee("L", "979", 50,2,false);
    assertEquals("L", Salaried2.getName());
    assertEquals("979", Salaried2.getId());
    assertEquals(50, Salaried2.getPayRate(),0.01);
    assertEquals(2, Salaried2.getPayInterval(),0.01);
    assertEquals(false, Salaried2.isManager());
  }

  /**
   * Test for constructor of HourlyPaycheck.
   */
  @Test
  public void testHourlyPaycheckConstructor() {
    Employee Hourly = new Employee("X","929",30,35);
    assertEquals("X", Hourly.getName());
    assertEquals("929", Hourly.getId());
    assertEquals(30, Hourly.getPayRate(),0.01);
    assertEquals(35, Hourly.getHoursWorked(),0.01);

    Employee Hourly2 = new Employee("L","0",40,45);
    assertEquals("L", Hourly2.getName());
    assertEquals("0", Hourly2.getId());
    assertEquals(40, Hourly2.getPayRate(),0.01);
    assertEquals(45, Hourly2.getHoursWorked(),0.01);
  }

  /**
   * Test for the invalid input.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidInput() {
    Employee badNameS = new Employee("", "999",40,1,true);
    Employee badIdS = new Employee("X",null,40,1,true);
    Employee badPayRateS = new Employee("Xx", "9990",-100,1,true);
    Employee badPayIntervalS = new Employee("Xx", "9990",40,6,true);

    Employee badNameH = new Employee(null,"77",40,15);
    Employee badIdH = new Employee("Lll","",40,15);
    Employee badPayRateH = new Employee("Lll","77",-1,15);
    Employee badHoursWorkedH = new Employee("Lll","77",40,-1);
  }

  /**
   * Test for GetPaycheck method.
   */
  @Test
  public void testGetPaycheck() {
    Employee S = new Employee("Xxx", "999",40,1,true);
    IPaycheck paycheckForS = S.getPaycheck();
    assertEquals(true, paycheckForS instanceof SalariedPaycheck);
    assertEquals(false, paycheckForS instanceof HourlyPaycheck);

    Employee H = new Employee("Xxx", "999",40,10);
    IPaycheck paycheckForH = H.getPaycheck();
    assertEquals(false, paycheckForH instanceof SalariedPaycheck);
    assertEquals(true, paycheckForH instanceof HourlyPaycheck);
  }

  /**
   * Test for toString method for SalariedPaycheck.
   */
  @Test
  public void testToStringS() {
    Employee S = new Employee("Xxx", "A999",5200,1,true);
    assertEquals("Name: Xxx\nID: A999\nPayment after taxes: $ 90.00", S.toString());

    Employee S2 = new Employee("Xxx", "A999",52000,1,true);
    assertEquals("Name: Xxx\nID: A999\nPayment after taxes: $ 850.00", S2.toString());

    Employee S3 = new Employee("Xxx", "A999",0.52,1,true);
    assertEquals("Name: Xxx\nID: A999\nPayment after taxes: $ 0.01", S3.toString());
  }

  /**
   * Test for toString method for HourlyPaycheck.
   */
  @Test
  public void testToStringH() {
    Employee H = new Employee("Lll", "ABc7",10,20);
    assertEquals("Name: Lll\nID: ABc7\nPayment after taxes: $ 180.00", H.toString());

    Employee H2 = new Employee("Lll", "ABc7",10,50);
    assertEquals("Name: Lll\nID: ABc7\nPayment after taxes: $ 467.50", H2.toString());

    Employee H3 = new Employee("Lll", "ABc7",0.01,1);
    assertEquals("Name: Lll\nID: ABc7\nPayment after taxes: $ 0.01", H3.toString());
  }
}