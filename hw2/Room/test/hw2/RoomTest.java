package hw2;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the Room class with 3 example points: r1, r2, r3.
 */
public class RoomTest {
  private Room r1;
  private Room r2;
  private Room r3;

  /**
   * Set number for 3 examples: 50, 100, 200.
   */
  @Before
  public void setUp() {
    r1 = new Room(RoomType.SINGLE, 50.0 );
    r2 = new Room(RoomType.DOUBLE, 100);
    r3 = new Room(RoomType.FAMILY, 200);
  }

  /**
   * Test isAvailable() function.
   */
  @Test
  public void test_isAvailable() {
    Assert.assertTrue(r1.isAvailable());
    r1.bookRoom(1);
    assertEquals(false, r1.isAvailable());

    Assert.assertTrue(r2.isAvailable());
    r2.bookRoom(10);
    assertEquals(true, r2.isAvailable());

    Assert.assertTrue(r3.isAvailable());
    r3.bookRoom(0);
    assertEquals(true, r3.isAvailable());
  }

  /**
   * Test bookRoom() function.
   */
  @Test
  public void test_bookRoom() {
    r1.bookRoom(1);
    r2.bookRoom(1);
    r3.bookRoom(100);
    Assert.assertFalse(r1.isAvailable());
    assertEquals(1, r1.getNumberOfGuests());
    Assert.assertFalse(r2.isAvailable());
    assertEquals(1, r2.getNumberOfGuests());
    Assert.assertTrue(r3.isAvailable());
    assertEquals(0, r3.getNumberOfGuests());
  }

  /**
   * Test getNumberOfGuests() function.
   */
  @Test
  public void test_getNumberOfGuests() {
    assertEquals(0, r1.getNumberOfGuests());
    assertEquals(0, r2.getNumberOfGuests());
    r1.bookRoom(1);
    assertEquals(1, r1.getNumberOfGuests());
    r2.bookRoom(2);
    assertEquals(2, r2.getNumberOfGuests());
    r3.bookRoom(5);
    assertEquals(0, r3.getNumberOfGuests());
  }

  /**
   * Test invalid price for new Room.
   */
  @Test
  public void testInvalidPrice() {
    try {
      new Room(RoomType.SINGLE, -1);
    } catch (IllegalArgumentException e) {
      assertEquals("Price of room can not be negative number", e.getMessage());
    }
  }
}