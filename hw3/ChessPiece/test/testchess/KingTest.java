package testchess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.Color;
import chess.King;
import org.junit.Test;

/**
 * Test implement class King.
 */
public class KingTest {
  /**
   * Test the constructor of King class.
   */
  @Test
  public void testConstructor() {
    try {
      new King(-1, 8, Color.BLACK);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
    try {
      new King(8, -1, Color.WHITE);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
  }

  /**
   * Test getRow method.
   */
  @Test
  public void testGetRow() {
    King B1 = new King(0,1,Color.WHITE);
    assertEquals(0, B1.getRow());
    King B2 = new King(7,1,Color.BLACK);
    assertEquals(7, B2.getRow());
  }

  /**
   * Test getColumn method.
   */
  @Test
  public void testGetColumn() {
    King B3 = new King(1,0, Color.WHITE);
    assertEquals(0,B3.getColumn());
    King B4 = new King(1,7, Color.WHITE);
    assertEquals(7,B4.getColumn());
  }

  /**
   * Test getColor method.
   */
  @Test
  public void testGetColor() {
    King B5 = new King(1,0, Color.WHITE);
    assertEquals(Color.WHITE, B5.getColor());
    King B6 = new King(1,0, Color.BLACK);
    assertEquals(Color.BLACK, B6.getColor());
  }

  /**
   * Test canMove method.
   */
  @Test
  public void testCanMove() {
    King B7 = new King(2,2, Color.WHITE);
    try {
      B7.canMove(-1, 8);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
    assertFalse(B7.canMove(2,2));
    assertTrue(B7.canMove(2,3));
    assertFalse(B7.canMove(2,4));
    assertTrue(B7.canMove(1,2));
    assertFalse(B7.canMove(4,2));
    assertFalse(B7.canMove(6,7));
  }

  /**
   * Test canKill method.
   */
  @Test
  public void testCanKill() {
    King B8 = new King(6,3, Color.BLACK);
    try {
      B8.canKill(new King(0,9,Color.WHITE));
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
    assertTrue(B8.canKill(new King(6,4,Color.WHITE)));
    assertFalse(B8.canKill(new King(6,5,Color.WHITE)));
    assertFalse(B8.canKill(new King(6,4,Color.BLACK)));
  }
}