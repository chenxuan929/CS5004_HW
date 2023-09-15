package testchess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.Color;
import chess.Pawn;
import org.junit.Test;

/**
 * Test implement class Pawn.
 */
public class PawnTest {
  /**
   * Test the constructor of Pawn class.
   */
  @Test
  public void testConstructor() {
    try {
      new Pawn(0, 8, Color.WHITE);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
    try {
      new Pawn(2, 7, Color.BLACK);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
  }

  /**
   * Test getRow method.
   */
  @Test
  public void testGetRow() {
    Pawn B1 = new Pawn(3,1,Color.WHITE);
    assertEquals(3, B1.getRow());
    Pawn B2 = new Pawn(0,1,Color.BLACK);
    assertEquals(0, B2.getRow());
  }

  /**
   * Test getColumn method.
   */
  @Test
  public void testGetColumn() {
    Pawn B3 = new Pawn(1,6, Color.WHITE);
    assertEquals(6,B3.getColumn());
    Pawn B4 = new Pawn(2,0, Color.BLACK);
    assertEquals(0,B4.getColumn());
  }

  /**
   * Test getColor method.
   */
  @Test
  public void testGetColor() {
    Pawn B5 = new Pawn(1,0, Color.WHITE);
    assertEquals(Color.WHITE, B5.getColor());
    Pawn B6 = new Pawn(1,0, Color.BLACK);
    assertEquals(Color.BLACK, B6.getColor());
  }

  /**
   * Test canMove method.
   */
  @Test
  public void testCanMove() {
    Pawn B7 = new Pawn(6,2, Color.BLACK);
    try {
      B7.canMove(-1,0);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
    assertFalse(B7.canMove(6,2));
    assertFalse(B7.canMove(7,3));
    assertFalse(B7.canMove(4,3));
    assertTrue(B7.canMove(4,2));
    assertTrue(B7.canMove(5,2));
  }

  /**
   * Test canKill method.
   */
  @Test
  public void testCanKill() {
    Pawn B8 = new Pawn(1,5, Color.WHITE);
    try {
      B8.canKill(new Pawn(0,9,Color.BLACK));
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
    assertFalse(B8.canKill(new Pawn(1,5,Color.BLACK)));
    assertTrue(B8.canKill(new Pawn(3,4,Color.BLACK)));
    assertFalse(B8.canKill(new Pawn(4,5,Color.BLACK)));
    assertFalse(B8.canKill(new Pawn(3,4,Color.WHITE)));
  }
}