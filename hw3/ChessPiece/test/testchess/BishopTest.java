package testchess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.Bishop;
import chess.Color;
import org.junit.Test;

/**
 * Test implement class Bishop.
 */
public class BishopTest {
  /**
   * Test constructor of Bishop class.
   */
  @Test
  public void testConstructor() {
    try {
      new Bishop(-1, 8, Color.BLACK);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
    try {
      new Bishop(8, -1, Color.WHITE);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
  }

  /**
   * Test getRow method.
   */
  @Test
  public void testGetRow() {
    Bishop B1 = new Bishop(0,1,Color.WHITE);
    assertEquals(0, B1.getRow());
    Bishop B2 = new Bishop(7,1,Color.BLACK);
    assertEquals(7, B2.getRow());
  }

  /**
   * Test getColumn method.
   */
  @Test
  public void testGetColumn() {
    Bishop B3 = new Bishop(1,0, Color.WHITE);
    assertEquals(0,B3.getColumn());
    Bishop B4 = new Bishop(1,7, Color.WHITE);
    assertEquals(7,B4.getColumn());
  }

  /**
   * Test getColor method.
   */
  @Test
  public void testGetColor() {
    Bishop B5 = new Bishop(1,0, Color.WHITE);
    assertEquals(Color.WHITE, B5.getColor());
    Bishop B6 = new Bishop(1,0, Color.BLACK);
    assertEquals(Color.BLACK, B6.getColor());
  }

  /**
   * Test canMove method.
   */
  @Test
  public void testCanMove() {
    Bishop B7 = new Bishop(2,2, Color.WHITE);
    try {
      B7.canMove(-1, 8);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
    assertFalse(B7.canMove(2,2));
    assertFalse(B7.canMove(3,4));
    assertTrue(B7.canMove(4,4));
    assertTrue(B7.canMove(0,0));
  }

  /**
   * Test canKill method.
   */
  @Test
  public void canKill() {
    Bishop B8 = new Bishop(2,2,Color.BLACK);
    try {
      B8.canKill(new Bishop(8,-1,Color.WHITE));
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
    assertTrue(B8.canKill(new Bishop(3,3, Color.WHITE)));
    assertFalse(B8.canKill(new Bishop(3,3, Color.BLACK)));
    assertTrue(B8.canKill(new Bishop(0, 0, Color.WHITE)));

  }
}