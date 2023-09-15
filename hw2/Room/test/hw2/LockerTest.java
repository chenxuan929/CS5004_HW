package hw2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * Test the Locker class.
 */
public class LockerTest {
  /**
   * Test the constructor exception when the passed size is invalid.
   */
  @Test
  public void testConstructor() {
    try {
      new Locker(10,0,100);
    } catch (IllegalArgumentException e) {
      assertEquals("Max size information can not be less than 1.", e.getMessage());
    }
    try {
      new Locker(10,10,0);
    } catch (IllegalArgumentException e) {
      assertEquals("Max size information can not be less than 1.", e.getMessage());
    }
    try {
      new Locker(1,10,100);
    } catch (IllegalArgumentException e) {
      assertEquals("Max size information can not be less than 1.", e.getMessage());
    }
  }

  /**
   * Test addMail and pickup function.
   */
  @Test
  public void testAddMail() {
    Locker l = new Locker(10, 20, 30);
    Recipient r = new Recipient("Chenxuan", "Xu", "chenxuan@xy.com");
    MailItem m = new MailItem(5,10, 15, r);
    l.addMail(m);
    MailItem pickedUpMailItem = l.pickupMail(r);
    assertEquals(m, pickedUpMailItem);
  }
}