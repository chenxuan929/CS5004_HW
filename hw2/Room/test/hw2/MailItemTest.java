package hw2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Test the MailItem class with 2 example: M1, M2.
 */
public class MailItemTest {
  private MailItem M1;
  private MailItem M2;

  /**
   * Set value for 2 examples contain width, height, depth, and recipient.
   */
  @Before
  public void setUp() {
    M1 = new MailItem(10, 20, 30, new Recipient("Chenxuan", "Xu", "Chenxuan@neu.edu"));
    M2 = new MailItem(5,5,5, new Recipient("Xuanyu", "Liu", "xuanyuliu@neu.edu"));
  }

  /**
   * Test for getRecipient function.
   */
  @Test
  public void getRecipient() {
    assertEquals(new Recipient("Chenxuan", "Xu", "Chenxuan@neu.edu"), M1.getRecipient());
    assertEquals(new Recipient("Xuanyu", "Liu", "xuanyuliu@neu.edu"), M2.getRecipient());
    try {
      new MailItem(10,10,10, new Recipient("", "", ""));
    } catch (IllegalArgumentException e) {
      assertEquals("Recipient must be provided, can not be null.", e.getMessage());
    }
  }

  /**
   * Test for getHeight function.
   */
  @Test
  public void getHeight() {
    assertEquals(20, M1.getHeight());
    assertEquals(5, M2.getHeight());
    try {
      new MailItem(10, 0, 10, new Recipient("Tom", "T", "tomt@neu.edu"));
    } catch (IllegalArgumentException e) {
      assertEquals("Size information can not be less than 1.", e.getMessage());
    }
  }

  /**
   * Test for getWidth function.
   */
  @Test
  public void getWidth() {
    assertEquals(10, M1.getWidth());
    assertEquals(5, M2.getWidth());
    try {
      new MailItem(0, 10, 10, new Recipient("Tom", "T", "tomt@neu.edu"));
    } catch (IllegalArgumentException e) {
      assertEquals("Size information can not be less than 1.", e.getMessage());
    }
  }

  /**
   * Test for getDepth function.
   */
  @Test
  public void getDepth() {
    assertEquals(30, M1.getDepth());
    assertEquals(5, M2.getDepth());
    try {
      new MailItem(10, 10, 0, new Recipient("Tom", "T", "tomt@neu.edu"));
    } catch (IllegalArgumentException e) {
      assertEquals("Size information can not be less than 1.", e.getMessage());
    }
  }
}