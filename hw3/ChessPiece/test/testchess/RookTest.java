package testchess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.Color;
import chess.Rook;
import org.junit.Test;

/**
 * Test implement class King.
 */
public class RookTest {
  /**
   * Test the constructor of Rook class.
   */
  @Test
  public void testConstructor() {
    try {
      new Rook(-3, 9, Color.BLACK);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
    try {
      new Rook(10, 0, Color.WHITE);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
  }

  /**
   * Test getRow method.
   */
  @Test
  public void testGetRow() {
    Rook B1 = new Rook(5, 1, Color.WHITE);
    assertEquals(5, B1.getRow());
    Rook B2 = new Rook(0, 1, Color.BLACK);
    assertEquals(0, B2.getRow());
  }

  /**
   * Test getColumn method.
   */
  @Test
  public void testGetColumn() {
    Rook B3 = new Rook(1, 0, Color.WHITE);
    assertEquals(0, B3.getColumn());
    Rook B4 = new Rook(0, 2, Color.WHITE);
    assertEquals(2, B4.getColumn());
  }

  /**
   * Test getColor method.
   */
  @Test
  public void testGetColor() {
    Rook B5 = new Rook(1, 0, Color.WHITE);
    assertEquals(Color.WHITE, B5.getColor());
    Rook B6 = new Rook(1, 0, Color.BLACK);
    assertEquals(Color.BLACK, B6.getColor());
  }

  /**
   * Test canMove method.
   */
  @Test
  public void testCanMove() {
    Rook B7 = new Rook(3, 6, Color.WHITE);
    try {
      B7.canMove(-1, 9);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
    assertFalse(B7.canMove(3,6));
    assertTrue(B7.canMove(3,0));
    assertTrue(B7.canMove(0,6));
    assertFalse(B7.canMove(4,5));
  }

  /**
   * Test canKill method.
   */
  @Test
  public void testCanKill() {
    Rook B8 = new Rook(5, 5, Color.WHITE);
    try {
      B8.canMove(0, -7);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
    assertTrue(B8.canKill(new Rook(5, 0, Color.BLACK)));
    assertTrue(B8.canKill(new Rook(7, 5, Color.BLACK)));
    assertFalse(B8.canKill(new Rook(6, 6, Color.BLACK)));
    assertFalse(B8.canKill(new Rook(5,0,Color.WHITE)));

  }
}