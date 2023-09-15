package hw2;

/**
 * This is a class represents a recipient with first name, last name and email.
 */
public class Recipient {
  private final String firstName;
  private final String lastName;
  private final String email;

  /**
   * Constructs a Recipient object with given first name, last name, and email.
   * Throws IllegalArgumentException if any of above are null.
   * @param firstName first name of the recipient.
   * @param lastName last name of the recipient.
   * @param email email of the recipient.
   */
  public Recipient(String firstName, String lastName, String email) {
    if (firstName == null || lastName == null || email == null) {
      throw new IllegalArgumentException("String information can not be empty.");
    }
    if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
      throw new IllegalArgumentException("Empty string is not accept.");
    }
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  /**
   * Returns first name of the recipient.
   * @return first name of the recipient.
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Returns last name of the recipient.
   * @return last name of the recipient.
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Returns email of the recipient.
   * @return email of the recipient.
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * Returns a string representation of recipient in format "firstName lastName Email: email".
   * @return a string representation of recipient.
   */
  @Override
  public String toString() {
    return String.format("%s %s Email:%s", firstName, lastName, email);
  }

  /**
   * Compares this recipient to a specified object.
   * Compare two object, if is same, return true.
   * If object is null or two objects have different class, return false.
   * Assign other to Recipient then compare the name and email of other and this.
   * @param other the object to compare this recipient.
   * @return true if the recipients are equal, false otherwise.
   */
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    Recipient recipient = (Recipient) other;
    return firstName.equals(recipient.firstName)
            && lastName.equals(recipient.lastName)
            && email.equals(recipient.email);
  }
}

