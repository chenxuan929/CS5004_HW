package testchess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.Color;
import chess.Knight;
import org.junit.Test;


/**
 * Test implement class Knight.
 */
public class KnightTest {
  /**
   * Test the constructor of Knight class.
   */
  @Test
  public void testConstructor() {
    try {
      new Knight(0, 8, Color.WHITE);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
    try {
      new Knight(2, -1, Color.BLACK);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
  }

  /**
   * Test getRow method.
   */
  @Test
  public void testGetRow() {
    Knight B1 = new Knight(3,1,Color.WHITE);
    assertEquals(3, B1.getRow());
    Knight B2 = new Knight(0,1,Color.BLACK);
    assertEquals(0, B2.getRow());
  }

  /**
   * Test getColumn method.
   */
  @Test
  public void testGetColumn() {
    Knight B3 = new Knight(0,7, Color.WHITE);
    assertEquals(7,B3.getColumn());
    Knight B4 = new Knight(2,0, Color.WHITE);
    assertEquals(0,B4.getColumn());
  }

  /**
   * Test getColor method.
   */
  @Test
  public void testGetColor() {
    Knight B5 = new Knight(1,0, Color.WHITE);
    assertEquals(Color.WHITE, B5.getColor());
    Knight B6 = new Knight(1,0, Color.BLACK);
    assertEquals(Color.BLACK, B6.getColor());
  }

  /**
   * Test canMove method.
   */
  @Test
  public void testCanMove() {
    Knight B7 = new Knight(0,0, Color.BLACK);
    try {
      B7.canMove(0,9);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
    assertFalse(B7.canMove(1,1));
    assertFalse(B7.canMove(0,0));
    assertTrue(B7.canMove(1,2));
    assertTrue(B7.canMove(2,1));
  }

  /**
   * Test canKill method.
   */
  @Test
  public void testCanKill() {
    Knight B8 = new Knight(5,1, Color.BLACK);
    try {
      B8.canKill(new Knight(-3,1,Color.BLACK));
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid position for chess piece", e.getMessage());
    }
    assertTrue(B8.canKill(new Knight(7,2,Color.WHITE)));
    assertTrue(B8.canKill(new Knight(6,3,Color.WHITE)));
    assertFalse(B8.canKill(new Knight(6,2,Color.BLACK)));
    assertFalse(B8.canKill(new Knight(7,3, Color.WHITE)));
    assertFalse(B8.canKill(new Knight(5,1, Color.WHITE)));

  }

}