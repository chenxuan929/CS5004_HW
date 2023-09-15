package registration;

/**
 * Class person.
 */
public class Person {
  private String name;
  private String address;

  /**
   * Constructor of person class.
   * @param name name of person.
   * @param address address of person.
   */
  public Person(String name, String address) {
    this.name = name;
    this.address = address;
  }

  /**
   * Get the name of person.
   * @return name of person.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get the address of person.
   * @return address of person.
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * Return a string of the name and address of person.
   * @return a String.
   */
  @Override
  public String toString() {
    return name + ", " + address;
  }
}
