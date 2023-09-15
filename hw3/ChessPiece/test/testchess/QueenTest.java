package testchess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.Color;
import chess.Queen;
import org.junit.Test;

/**
 * Test implement class Queen.
 */
public class QueenTest {
  /**
   * Test the constructor of Queen class.
   */
  @Test
  public void testConstructor() {
    try {
      new Queen(-3, 7, Color.BLACK);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
    try {
      new Queen(1, -2, Color.WHITE);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
  }

  /**
   * Test getRow method.
   */
  @Test
  public void testGetRow() {
    Queen B1 = new Queen(3,1,Color.WHITE);
    assertEquals(3, B1.getRow());
    Queen B2 = new Queen(0,1,Color.BLACK);
    assertEquals(0, B2.getRow());
  }

  /**
   * Test getColumn method.
   */
  @Test
  public void testGetColumn() {
    Queen B3 = new Queen(0,7, Color.WHITE);
    assertEquals(7,B3.getColumn());
    Queen B4 = new Queen(2,0, Color.WHITE);
    assertEquals(0,B4.getColumn());
  }

  /**
   * Test getColor method.
   */
  @Test
  public void testGetColor() {
    Queen B5 = new Queen(1,0, Color.WHITE);
    assertEquals(Color.WHITE, B5.getColor());
    Queen B6 = new Queen(1,0, Color.BLACK);
    assertEquals(Color.BLACK, B6.getColor());
  }

  /**
   * Test canMove method.
   */
  @Test
  public void testCanMove() {
    Queen B7 = new Queen(0,0, Color.BLACK);
    try {
      B7.canMove(-1,9);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
    assertFalse(B7.canMove(0,0));
    assertFalse(B7.canMove(2,3));
    assertTrue(B7.canMove(0,7));
    assertTrue(B7.canMove(5,5));
  }

  /**
   * Test canKill method.
   */
  @Test
  public void testCanKill() {
    Queen B8 = new Queen(2,7, Color.BLACK);
    try {
      B8.canKill(new Queen(0,9,Color.BLACK));
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
    assertTrue(B8.canKill(new Queen(0,5,Color.WHITE)));
    assertFalse(B8.canKill(new Queen(1,5,Color.WHITE)));
    assertFalse(B8.canKill(new Queen(2,7,Color.BLACK)));
  }
}