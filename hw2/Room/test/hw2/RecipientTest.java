package hw2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Test the Room class with 3 example recipient: recipient1, recipient2, recipient3.
 */
public class RecipientTest {
  private Recipient recipient1;
  private Recipient recipient2;
  private Recipient recipient3;

  /**
   * Set value for 3 examples contain firstname, lastname, and email.
   */
  @Before
  public void setUp() {
    recipient1 = new Recipient("Tom", "X", "tomx@cs5004.com");
    recipient2 = new Recipient("Jerry", "Y", "jerryy@cs5004.com");
    recipient3 = new Recipient("Moni", "M", "monim@cs5004.com");
  }

  /**
   * Test getFirstName function.
   */
  @Test
  public void testGetFirstName() {
    assertEquals("Tom", recipient1.getFirstName());
    assertEquals("Jerry", recipient2.getFirstName());
    assertEquals("Moni", recipient3.getFirstName());
  }

  /**
   * Test getLastName function.
   */
  @Test
  public void getLastName() {
    assertEquals("X", recipient1.getLastName());
    assertEquals("Y", recipient2.getLastName());
    assertEquals("M", recipient3.getLastName());
  }

  /**
   * Test getEmail function.
   */
  @Test
  public void getEmail() {
    assertEquals("tomx@cs5004.com", recipient1.getEmail());
    assertEquals("jerryy@cs5004.com", recipient2.getEmail());
    assertEquals("monim@cs5004.com", recipient3.getEmail());
  }

  /**
   * Test ToString function.
   * Should be format like - FirstName LastName Email:xxx@yyyy.com
   */
  @Test
  public void testToString() {
    assertEquals("Tom X Email:tomx@cs5004.com", recipient1.toString());
    assertEquals("Jerry Y Email:jerryy@cs5004.com", recipient2.toString());
    assertEquals("Moni M Email:monim@cs5004.com", recipient3.toString());
  }

  /**
   * Test Equals function.
   */
  @Test
  public void testEquals() {
    Recipient another = new Recipient("Tom", "X", "tomx@cs5004.com");
    assertTrue(recipient1.equals(another));
    assertFalse(recipient2.equals(another));
    assertFalse(recipient3.equals(another));
  }
}