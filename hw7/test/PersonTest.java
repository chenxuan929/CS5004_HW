import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import registration.Person;

/**
 * Test class of Person class.
 */
public class PersonTest {
  private Person person1;
  private Person person2;
  private Person person3;

  /**
   * Initializes three Person objects for use in testing.
   */
  @Before
  public void setUp() {
    person1 = new Person("Alice", "123 Main St");
    person2 = new Person("Bob", "456 Second St");
    person3 = new Person("Charlie", "789 Third St");
  }

  /**
   * Test getName method.
   */
  @Test
  public void testGetName() {
    assertEquals("Alice", person1.getName());
    assertEquals("Bob", person2.getName());
    assertEquals("Charlie", person3.getName());
  }

  /**
   * Test getAddress method.
   */
  @Test
  public void testGetAddress() {
    assertEquals("123 Main St", person1.getAddress());
    assertEquals("456 Second St", person2.getAddress());
    assertEquals("789 Third St", person3.getAddress());
  }

  /**
   * Test toString method.
   */
  @Test
  public void testToString() {
    assertEquals("Alice, 123 Main St", person1.toString());
    assertEquals("Bob, 456 Second St", person2.toString());
    assertEquals("Charlie, 789 Third St", person3.toString());
  }
}
